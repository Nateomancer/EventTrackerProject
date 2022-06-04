package com.skilldistillery.powerlifting.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.powerlifting.entites.TrainingDayLift;
import com.skilldistillery.powerlifting.services.TrainingDayLiftService;

@RestController
@RequestMapping("api")
public class TrainingDayLiftController {

	@Autowired
	private TrainingDayLiftService trainingDayLiftServ;

	// Ping pong test
	@GetMapping("ping")
	public String ping() {

		return "pong";

	}

	// get a sing training day by id
	@GetMapping("trainingDayLifts/{id}")
	public TrainingDayLift showOneTrainingDayLift(@PathVariable Integer id, HttpServletResponse res) {

		TrainingDayLift trainingDayLift = trainingDayLiftServ.findById(id);
		if (trainingDayLift == null) {

			res.setStatus(404);
		}

		return trainingDayLift;

	}

	// get a list of the training day lifts
	@GetMapping("trainingDayLifts")
	public List<TrainingDayLift> getTrainingDayList(HttpServletResponse res) {

		List<TrainingDayLift> trainingDayLiftList = trainingDayLiftServ.findAll();

		if (trainingDayLiftList == null) {

			res.setStatus(404);
		}

		return trainingDayLiftList;
	}

	@PostMapping(path = "trainingDayLifts")
	public TrainingDayLift createNewTrainingDayLift(@RequestBody TrainingDayLift trainingDayLift,
			HttpServletRequest req, HttpServletResponse res) {

		try {

			trainingDayLift = trainingDayLiftServ.create(trainingDayLift);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(trainingDayLift.getId());
			res.setHeader("Location", url.toString());

		} catch (Exception e) {

			e.printStackTrace();
			res.setStatus(400);
			trainingDayLift = null;
		}

		return trainingDayLift;
	}

	@PatchMapping(path = "trainingDayLifts/{id}")
	public TrainingDayLift updateTrainingDayLift(@PathVariable Integer id,
			@RequestBody TrainingDayLift trainingDayLift, HttpServletRequest req, HttpServletResponse res) {

		try {

			trainingDayLift = trainingDayLiftServ.update(trainingDayLift, id);
			if (trainingDayLift == null) {
				res.setStatus(404);
				trainingDayLift = null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			res.setStatus(400);
			trainingDayLift = null;

		}

		return trainingDayLift;
	}

	@DeleteMapping(path = "trainingDayLifts/{id}")
	public void deleteTrainingDayLift(@PathVariable Integer id, HttpServletRequest req,
			HttpServletResponse res) {
		
		Boolean deleted=trainingDayLiftServ.delete(id);
		
		try {
			if (deleted) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.setStatus(400);

		}
	}
}