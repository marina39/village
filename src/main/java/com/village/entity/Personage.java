package com.village.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Personage extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6043161471296013395L;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "personage")
	private List<Gifting> gifting;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Gifting> getGifting() {
		return gifting;
	}

	public void setGifting(List<Gifting> gifting) {
		this.gifting = gifting;
	}
	
}
