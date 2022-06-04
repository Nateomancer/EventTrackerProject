package com.skilldistillery.powerlifting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.powerlifting.entites.TrainingDay;
import com.skilldistillery.powerlifting.repositories.TrainingDayRepository;

@Service
public class TrainingDayServiceImpl implements TrainingDayService {

	@Autowired
	private TrainingDayRepository trainingDayRepo;
	
	@Override
	public List<TrainingDay> index() {
		
		return trainingDayRepo.findAll();
	}

}
