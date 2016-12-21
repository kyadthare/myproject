package com.humanServices.service;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.humanServices.controller.ProviderSearchBO;
import com.humanServices.dao.ProviderDAO;
import com.humanServices.entity.Address;
import com.humanServices.entity.Provider;
import com.humanServices.entity.ProviderType;
import com.humanServices.entity.QualityStarRating;

/**
 * Implements the functionalities of ProviderService.
 * 
 * @author balachandra
 *
 */

@Service("providerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private ProviderDAO providerDao;

	public List<Provider> searchProviders(ProviderSearchBO searchBo) {
		List<Provider> providerList = providerDao.searchProviders(searchBo);
		if(null !=searchBo.getGeoRadius()){
			Map<String, Double> CitiesInVicinity = listCitiesInVicinity(searchBo, providerList);
			providerList = getProvidersInVicinity(providerList,CitiesInVicinity);
		}
		return providerList;
	}

	public List<ProviderType> getProviderTypes() {
		return providerDao.getProviderTypes();
	}

	public List<QualityStarRating> getRatings() {
		return providerDao.getRatings();
	}

	public List<String> getCities(String county) {
		return providerDao.getCities(county);
	}

	public List<String> getCounties() {
		return providerDao.getCounties();
	}
	
	/**
	 * 
	 * @param searchBo
	 * @param providerList
	 * @return List the urls with 10 destinations in the query string
	 */
	public List<String> urlBuilder(ProviderSearchBO searchBo,
			List<Provider> providerList) {

		StringBuilder urlBuilder = new StringBuilder();
		StringBuilder refDestinationBuilder = new StringBuilder();
		List<String> cityList = new ArrayList<String>();
		String city;
		int destinationSize = 10;
		List<String> urlBatchList = new ArrayList<String>();

		try {
			
			//logic to get the distinct cities
			for (Provider provider : providerList) {
				city = provider.getAddress().getCity().replace(" ", "+");
				if (refDestinationBuilder.indexOf(city) < 0) {
					refDestinationBuilder.append(city).append(",").append("MS").append(",USA|");
					cityList.add(city);
				} else {
					continue;
				}
			}
			
			// logic of building the url
			for (int j = 0; j < cityList.size(); j++) {

				if (j % destinationSize == 0) {
					if (urlBuilder.length() > 0) {
						urlBatchList.add(urlBuilder.toString());
					}
					urlBuilder = new StringBuilder();
					urlBuilder.append("http://maps.googleapis.com/maps/api/distancematrix/json?origins=");
					urlBuilder.append(searchBo.getCity().replace(" ", "+")).append(",").append("MS").append(",USA&destinations=");
				}
				urlBuilder.append(cityList.get(j)).append(",").append("MS").append(",USA|");
			}
			if (urlBuilder.length() > 0) {
				urlBatchList.add(urlBuilder.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return urlBatchList;
	}

	/**
	 * 
	 * @param searchBo
	 * @param urlBatchList
	 * @return List all the cities with in the searched geo radius.
	 */
	public Map<String, Double> listCitiesInVicinity(ProviderSearchBO searchBo,
			List<Provider> providerList) {

		String distance, destination, response, status;
		double distanceInMiles;
		URL url;
		HttpURLConnection conn;
		InputStream in;
		JsonParser jsonParser = new JsonParser();
		Map<String, Double> citiesInVicinity = new HashMap<String, Double>();

		try {
			List<String> urlBatchList = urlBuilder(searchBo, providerList);
			for (int j = 0; j < urlBatchList.size(); j++) {

				url = new URL(urlBatchList.get(j));
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setChunkedStreamingMode(1200);
				conn.setDoOutput(true);
				in = new BufferedInputStream(conn.getInputStream());
				response = org.apache.commons.io.IOUtils.toString(in, "UTF-8");

				status = jsonParser.parse(response).getAsJsonObject().get("status").getAsString();
				if (status.equalsIgnoreCase("OK")) {
					JsonArray destinations = jsonParser.parse(response)
							.getAsJsonObject().getAsJsonArray("destination_addresses");
					JsonArray elements = jsonParser.parse(response)
							.getAsJsonObject().getAsJsonArray("rows").get(0)
							.getAsJsonObject().getAsJsonArray("elements");

					for (int i = 0; i < elements.size(); i++) {
						distance = elements.get(i).getAsJsonObject()
								.get("distance").getAsJsonObject().get("text").getAsString();
						distanceInMiles = Double.parseDouble(distance.split(" ")[0].trim()) * 0.621371;
						if (distanceInMiles < 1) {
							distanceInMiles = 0;
						}
						destination = destinations.get(i).getAsString().split("\\,")[0];
						if (distanceInMiles <= searchBo.getGeoRadius().getRadius()) {
							citiesInVicinity.put(destination, distanceInMiles);
						}
					}
				} else if (status.equalsIgnoreCase("INVALID_REQUEST")) {
					continue;
				} else {
					--j;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return citiesInVicinity;
	}

	
	private List<Provider> getProvidersInVicinity(List<Provider> providerList,
			Map<String, Double> citiesInVicinity) {
		Address address;
		List<Provider> removeList = new ArrayList<Provider>();
		boolean isExists = false;
		for (Provider provider : providerList) {

			for (String city : citiesInVicinity.keySet()) {
				address = provider.getAddress();
				isExists = false;
				if (address.getCity().equalsIgnoreCase(city)) {
					address.setDistance(citiesInVicinity.get(city));
					isExists = true;
					break;
				}
			}
			if (!isExists) {
				removeList.add(provider);
			}
		}
		providerList.removeAll(removeList);
		return providerList;
	}

}
