package com.humanServices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.humanServices.Dao.ProviderDao;
import com.humanServices.entities.Address;
import com.humanServices.entities.Provider;
import com.humanServices.entities.ProviderType;
import com.humanServices.entities.QualityStarRating;
import com.humanServices.searchBo.ProviderSearchBo;

@Service("providerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProviderServiceImpl implements ProviderService{
	
	@Autowired
	 private ProviderDao providerDao;

	public List<Provider> searchProviders(ProviderSearchBo searchBo) {
		return providerDao.searchProviders(searchBo);
	}

	public List<ProviderType> searchProviderTypes() {
		return providerDao.searchProviderTypes();
	}

	public List<QualityStarRating> listRatings() {
		return providerDao.listRatings();
	}


	public List<Address> listCity() {
		return  prepareListofCities(providerDao.listAddresses());
	}
	
	public List<Address> listCounty() {
		return  prepareListofCounties(providerDao.listAddresses());
	}
	
	private List<Address> prepareListofCities(List<Address> addresses) {
		List<Address> entities = null;
		boolean isExists = false;
		if (addresses != null && !addresses.isEmpty()) {
			entities = new ArrayList<Address>();
			Address entity = null;
			for (Address address : addresses) {
				entity = new Address();
				isExists = false;
				for (int i = 0; i < entities.size(); i++) {
					isExists = true;
					if (!entities.get(i).getCity().equals(address.getCity())) {
						isExists = false;
					}
				}
				if (!isExists) {
					entity.setAddressId(address.getAddressId());
					entity.setCity(address.getCity());
					entities.add(entity);
				}
			}
		}
		return entities;
	}

	private List<Address> prepareListofCounties(List<Address> addresses) {
		List<Address> entities = null;
		boolean isExists = false;
		if (addresses != null && !addresses.isEmpty()) {
			entities = new ArrayList<Address>();
			Address entity = null;
			for (Address address : addresses) {
				entity = new Address();
				isExists = false;
				for (int i = 0; i < entities.size(); i++) {
					isExists = true;
					if (entities.get(i).getCountyNumber() != address
							.getCountyNumber()) {
						isExists = false;
					}
				}
				if (!isExists) {
					entity.setAddressId(address.getAddressId());
					entity.setCountyNumber(address.getCountyNumber());
					entity.setCounty(address.getCounty());
					entities.add(entity);
				}
			}
		}
		return entities;
	}


}
