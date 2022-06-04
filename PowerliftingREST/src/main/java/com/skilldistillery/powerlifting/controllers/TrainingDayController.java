package com.skilldistillery.powerlifting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.powerlifting.entites.TrainingDay;
import com.skilldistillery.powerlifting.services.TrainingDayService;

@RequestMapping("api")
@RestController
public class TrainingDayController {

	@Autowired
	private TrainingDayService trainingDayServ;
	
	@GetMapping("tranningDay")
	public List<TrainingDay> index(){
		
		return trainingDayServ.index();
	}
	
}
