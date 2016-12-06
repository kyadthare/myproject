package com.humanServices.dao;

import java.util.List;

import com.humanServices.controller.ProviderSearchBO;
import com.humanServices.entity.Address;
import com.humanServices.entity.Provider;
import com.humanServices.entity.ProviderType;
import com.humanServices.entity.QualityStarRating;
/**
 * DAO class which fetches the data from the database.
 * 
 * @author balachandra
 *
 */
public interface ProviderDAO {
	
	public List<Provider> searchProviders(ProviderSearchBO searchBO);
	public List<ProviderType> getProviderTypes();
	public List<QualityStarRating> getRatings();
	public List<String> getCounties();
	public List<String> getCities(String county);

}
