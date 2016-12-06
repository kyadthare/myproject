package com.humanServices.controller;

import com.humanServices.entity.Address;
import com.humanServices.entity.ProviderType;
import com.humanServices.entity.QualityStarRating;

/**
 * To hold search criteria as an object and process further.
 * 
 * @author balachandra
 *
 */
public class ProviderSearchBO {

	private String providerName;
	private ProviderType providerType;
	private String county;
	private String city;
	private QualityStarRating qualityRating;

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public ProviderType getProviderType() {
		return providerType;
	}

	public void setProviderType(ProviderType providerType) {
		this.providerType = providerType;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public QualityStarRating getQualityRating() {
		return qualityRating;
	}

	public void setQualityRating(QualityStarRating qualityRating) {
		this.qualityRating = qualityRating;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
