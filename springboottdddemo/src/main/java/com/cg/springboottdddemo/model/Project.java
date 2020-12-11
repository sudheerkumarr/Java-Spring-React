package com.cg.springboottdddemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String projIdentifier;

	@Column
	private String description;

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String name, String projIdentifier, String description) {
		super();
		this.name = name;
		this.projIdentifier = projIdentifier;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProjIdentifier() {
		return projIdentifier;
	}

	public void setProjIdentifier(String projIdentifier) {
		this.projIdentifier = projIdentifier;
	}


	

}
