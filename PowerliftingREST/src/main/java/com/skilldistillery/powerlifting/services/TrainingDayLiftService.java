package com.skilldistillery.powerlifting.services;

import java.util.List;

import com.skilldistillery.powerlifting.entites.TrainingDayLift;

public interface TrainingDayLiftService {

	List<TrainingDayLift> findAll();

	TrainingDayLift findById(int id);

	TrainingDayLift create(TrainingDayLift trainingDayLift);

	TrainingDayLift update(TrainingDayLift trainingDayLift, Integer trainingDayLiftId);

	Boolean delete(Integer trainingDayLiftId);

}
