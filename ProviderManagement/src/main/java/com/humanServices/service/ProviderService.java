package com.humanServices.service;

import java.util.List;

import com.humanServices.entities.Address;
import com.humanServices.entities.Provider;
import com.humanServices.entities.ProviderType;
import com.humanServices.entities.QualityStarRating;
import com.humanServices.searchBo.ProviderSearchBo;

public interface ProviderService {
	
	public List<Provider> searchProviders(ProviderSearchBo searchBo);
	public List<ProviderType> searchProviderTypes();
	public List<QualityStarRating> listRatings();
	public List<Address> listCity();
	public List<Address> listCounty();

}