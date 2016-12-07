package com.humanServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.humanServices.controller.ProviderSearchBO;
import com.humanServices.dao.ProviderDAO;
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
		return providerDao.searchProviders(searchBo);
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

}
