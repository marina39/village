package com.village.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.village.entity.Gift;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {

}
