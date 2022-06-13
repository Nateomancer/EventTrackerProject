package com.skilldistillery.powerlifting.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.powerlifting.entites.TrainingDayLift;
import com.skilldistillery.powerlifting.repositories.TrainingDayLiftRepository;

@Service
public class TrainingDayLiftServiceImpl implements TrainingDayLiftService {

	@Autowired
	private TrainingDayLiftRepository trainingDayLiftRepo;

	@Override
	public List<TrainingDayLift> findAll() {

		return trainingDayLiftRepo.findAll();
	}

	@Override
	public TrainingDayLift findById(int id) {

		Optional<TrainingDayLift> op = trainingDayLiftRepo.findById(id);
		TrainingDayLift trainingDayLift = null;

		if (op.isPresent()) {
			trainingDayLift = op.get();

			return trainingDayLift;
		}
		return null;

	}

	@Override
	public TrainingDayLift create(TrainingDayLift trainingDayLift) {

		System.out.println(trainingDayLift);

		try {

			final String DEFAULT_LIFT = "DEFAULT LIFT";
			final Integer DEFAULT_SET_WEIGHT = 135;

			if (trainingDayLift.getTrainingLift().isEmpty() && trainingDayLift.getTrainingLift() == null) {
				trainingDayLift.setTrainingLift(DEFAULT_LIFT);
			}

			if (trainingDayLift.getFirstSetWeight() == null) {
				trainingDayLift.setFirstSetWeight(DEFAULT_SET_WEIGHT);
			}
			if (trainingDayLift.getSecondSetWeight() == null) {
				trainingDayLift.setSecondSetWeight(DEFAULT_SET_WEIGHT);
			}
			if (trainingDayLift.getThirdSetWeight() == null) {
				trainingDayLift.setThirdSetWeight(DEFAULT_SET_WEIGHT);
			}
			if (trainingDayLift.getAmrapWeight() == null) {
				trainingDayLift.setAmrapWeight(DEFAULT_SET_WEIGHT);
			}

			trainingDayLiftRepo.save(trainingDayLift);

		}

		catch (Exception e) {

			e.printStackTrace();
			System.err.println("USER ID NULL");

		}

		return trainingDayLift;

	}

	// update
	@Override
	public TrainingDayLift update(TrainingDayLift trainingDayLift, Integer trainingDayLiftId) {

		TrainingDayLift updater = findById(trainingDayLiftId);
		
		System.err.println("UPDATING TRAINING DAY LIFT");
		System.err.println("trainingDayLiftId" + trainingDayLiftId);
		System.err.println("UPDATING TRAINING DAY LIFT" + trainingDayLift);
		System.err.println("TRAINING DAY LIFT"+ updater);
		
		updater.setTrainingLift(trainingDayLift.getTrainingLift());
		updater.setFirstSetWeight(trainingDayLift.getFirstSetWeight());
		updater.setSecondSetWeight(trainingDayLift.getSecondSetWeight());
		updater.setThirdSetWeight(trainingDayLift.getSecondSetWeight());
		updater.setAmrapWeight(trainingDayLift.getAmrapWeight());

		return trainingDayLiftRepo.save(updater);

	}

	// delete
	@Override
	public Boolean delete(Integer trainingDayLiftId) {

		trainingDayLiftRepo.deleteById(trainingDayLiftId);

		return !trainingDayLiftRepo.existsById(trainingDayLiftId);

	}

}
