package com.humanServices.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity class for the QUALITYSTARRATING table.
 * ratingId is the primary key column.
 * 
 * @author balachandra
 *
 */
@Entity
@Table(name = "QUALITYSTARRATING")
public class QualityStarRating {

	private int ratingId;
	private String description;

	@Id
	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
