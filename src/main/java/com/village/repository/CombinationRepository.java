package com.village.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.village.entity.Combination;

@Repository
public interface CombinationRepository extends JpaRepository<Combination, Long> {
	
	@Query("select c from Combination c where c.personage.id = ?1")
	public List<Combination> findByPersonageId(Long id);
	
	@Query("select c from Combination c where c.gift.id = ?1")
	public List<Combination> findByGiftId(Long id);

}
