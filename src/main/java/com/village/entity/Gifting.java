package com.village.entity;

import javax.persistence.*;

@Entity
public class Gifting extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2457460816999529580L;
	
	@ManyToOne
	@JoinColumn(name = "id_personage_fk")
	private Personage personage;
	
	@ManyToOne
	@JoinColumn(name = "id_gift_fk")
	private Gift gift;
	
	private Integer score;

	public Personage getPersonage() {
		return personage;
	}

	public void setPersonage(Personage personage) {
		this.personage = personage;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
