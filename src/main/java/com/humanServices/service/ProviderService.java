package com.humanServices.service;

import java.util.List;

import com.humanServices.controller.ProviderSearchBO;
import com.humanServices.entity.Provider;
import com.humanServices.entity.ProviderType;
import com.humanServices.entity.QualityStarRating;

/**
 * Service Interface that gets the response from DAO and compose the search
 * results in the required form.
 * 
 * @author balachandra
 *
 */

public interface ProviderService {

	public List<Provider> searchProviders(ProviderSearchBO searchBo);

	public List<ProviderType> getProviderTypes();

	public List<QualityStarRating> getRatings();

	public List<String> getCities(String county);

	public List<String> getCounties();

}
