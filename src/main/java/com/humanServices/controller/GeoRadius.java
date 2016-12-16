package com.humanServices.controller;

/**
 * To hold geo radius and description from search criteria
 * 
 * @author balachandra
 *
 */

public class GeoRadius {

	private int radius;
	private String description;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
