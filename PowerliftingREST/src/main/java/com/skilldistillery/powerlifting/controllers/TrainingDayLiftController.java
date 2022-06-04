package com.skilldistillery.powerlifting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.powerlifting.entites.TrainingDayLift;
import com.skilldistillery.powerlifting.services.TrainingDayLiftService;

@RequestMapping("api")
@RestController
public class TrainingDayLiftController {

	@Autowired
	private TrainingDayLiftService trainingDayLiftServ;
	
	@GetMapping("traningDayLift")
	public List<TrainingDayLift> index(){
		
		return trainingDayLiftServ.index();
	}
	
}
