package com.village.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.village.entity.Personage;

@Repository
public interface PersonageRepository extends JpaRepository<Personage, Long> {

}
