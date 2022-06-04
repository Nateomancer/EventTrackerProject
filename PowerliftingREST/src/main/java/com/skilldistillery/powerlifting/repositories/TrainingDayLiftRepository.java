package com.skilldistillery.powerlifting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.powerlifting.entites.TrainingDayLift;

public interface TrainingDayLiftRepository extends JpaRepository<TrainingDayLift, Integer>{

}
