package com.humanServices.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity class for PROVIDER table. providerId is the primary key column.
 * 
 * @author balachandra
 *
 */

@Entity
@Table(name = "PROVIDER")
public class Provider {

	private Long providerId;
	private String name;
	private String licenseType;
	private ProviderType providerType;
	private Address address;
	private QualityStarRating rating;
	private Long capacity;
	private String phoneNumber;

	@Id
	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "typeId")
	public ProviderType getProviderType() {
		return providerType;
	}

	public void setProviderType(ProviderType providerType) {
		this.providerType = providerType;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ratingId")
	public QualityStarRating getRating() {
		return rating;
	}

	public void setRating(QualityStarRating rating) {
		this.rating = rating;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}