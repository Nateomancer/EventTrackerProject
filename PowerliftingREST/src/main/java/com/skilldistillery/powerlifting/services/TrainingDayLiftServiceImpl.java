package com.skilldistillery.powerlifting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.powerlifting.entites.TrainingDayLift;
import com.skilldistillery.powerlifting.repositories.TrainingDayLiftRepository;

@Service
public class TrainingDayLiftServiceImpl implements TrainingDayLiftService {

	@Autowired
	private TrainingDayLiftRepository trainingDayRepo;
	
	@Override
	public List<TrainingDayLift> index() {
		
		return trainingDayRepo.findAll();
	}

}
