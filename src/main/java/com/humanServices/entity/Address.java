package com.humanServices.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity class for the ADDRESS table. 
 * addressId is the primary key column.
 * 
 * @author balachandra
 *
 */
@Entity
@Table(name="ADDRESS")
public class Address {

	private int addressId;
	private int countyNumber;
	private String county;
	private String city;
	private int zipcode;

	@Id
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getCountyNumber() {
		return countyNumber;
	}

	public void setCountyNumber(int countyNumber) {
		this.countyNumber = countyNumber;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
