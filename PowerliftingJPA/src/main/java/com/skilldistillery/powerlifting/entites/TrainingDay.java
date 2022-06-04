package com.skilldistillery.powerlifting.entites;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "training_day_lift")
public class TrainingDay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "training_lift")
	private String trainingLift;

	@Column(name = "first_set_weight")
	private Integer firstSetWeight;

	@Column(name = "second_set_weight")
	private Integer secondSetWeight;

	@Column(name = "third_set_weight")
	private Integer thirdSetWeight;

	@Column(name = "amrap_weight")
	private Integer amrapWeight;

	@Column(name = "user_id")
	private Integer userId;

	public TrainingDay() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainingLift() {
		return trainingLift;
	}

	public void setTrainingLift(String trainingLift) {
		this.trainingLift = trainingLift;
	}

	public Integer getFirstSetWeight() {
		return firstSetWeight;
	}

	public void setFirstSetWeight(Integer firstSetWeight) {
		this.firstSetWeight = firstSetWeight;
	}

	public Integer getSecondSetWeight() {
		return secondSetWeight;
	}

	public void setSecondSetWeight(Integer secondSetWeight) {
		this.secondSetWeight = secondSetWeight;
	}

	public Integer getThirdSetWeight() {
		return thirdSetWeight;
	}

	public void setThirdSetWeight(Integer thirdSetWeight) {
		this.thirdSetWeight = thirdSetWeight;
	}

	public Integer getAmrapWeight() {
		return amrapWeight;
	}

	public void setAmrapWeight(Integer amrapWeight) {
		this.amrapWeight = amrapWeight;
	}

	@Override
	public String toString() {
		return "TrainingDay [id=" + id + ", trainingLift=" + trainingLift + ", firstSetWeight=" + firstSetWeight
				+ ", secondSetWeight=" + secondSetWeight + ", thirdSetWeight=" + thirdSetWeight + ", amrapWeight="
				+ amrapWeight + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingDay other = (TrainingDay) obj;
		return id == other.id;
	}

}
