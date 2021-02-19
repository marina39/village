package com.village.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.village.entity.Gifting;

@Repository
public interface GiftingRepository extends JpaRepository<Gifting, Long> {
	
	@Query("select g from Gifting g where g.personage.id = ?1")
	public List<Gifting> findByPersonageId(Long id);

}
