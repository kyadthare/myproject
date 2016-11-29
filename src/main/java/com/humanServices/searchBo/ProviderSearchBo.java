package com.humanServices.searchBo;

import com.humanServices.entities.Address;
import com.humanServices.entities.ProviderType;
import com.humanServices.entities.QualityStarRating;

public class ProviderSearchBo {
	
	private String providerName;
	private ProviderType providerType;
	private Address addressCounty;
	private Address addressCity;
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
	public Address getAddressCounty() {
		return addressCounty;
	}
	public void setAddressCounty(Address addressCounty) {
		this.addressCounty = addressCounty;
	}
	public Address getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(Address addressCity) {
		this.addressCity = addressCity;
	}
	public QualityStarRating getQualityRating() {
		return qualityRating;
	}
	public void setQualityRating(QualityStarRating qualityRating) {
		this.qualityRating = qualityRating;
	}
	

}
