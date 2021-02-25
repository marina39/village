package com.village.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Gift extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7147503521917214720L;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "gift")
	private List<Combination> combination;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Combination> getGifting() {
		return combination;
	}

	public void setCombination(List<Combination> combination) {
		this.combination = combination;
	}

}
