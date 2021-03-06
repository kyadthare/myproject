package com.humanServices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for the PROVIDERTYPE table. typeId is the primary key column.
 * 
 * @author balachandra
 *
 */

@Entity
@Table(name = "PROVIDERTYPE")
public class ProviderType {
	
	private Long typeId;
	private String description;

	@Id
	@Column(name = "typeId")
	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
