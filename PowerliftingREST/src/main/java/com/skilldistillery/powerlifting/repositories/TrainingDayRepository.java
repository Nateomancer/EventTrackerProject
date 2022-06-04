package com.skilldistillery.powerlifting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.powerlifting.entites.TrainingDay;

public interface TrainingDayRepository extends JpaRepository<TrainingDay, Integer>{

}
