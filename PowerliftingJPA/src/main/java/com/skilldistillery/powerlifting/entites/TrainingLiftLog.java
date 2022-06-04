package com.skilldistillery.powerlifting.entites;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "training_day_log")
public class TrainingLiftLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "lift_log")
	private String lift;

	@Column(name = "first_set_rep_total")
	private Integer firstSetRepTotal;

	@Column(name = "second_set_rep_total")
	private Integer secondSetRepTotal;

	@Column(name = "third_set_rep_total")
	private Integer thirdSetRepTotle;

	@Column(name = "amrap_rep_total")
	private Integer amrapRepTotal;

	private Integer rpe;

	@Column(name = "date_created")
	@CreationTimestamp
	private LocalDateTime dateCreated;

	@Column(name = "training_day_lift_id")
	private Integer trainingDayId;

	@Column(name = "user_id")
	private Integer userId;

	public TrainingLiftLog() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLift() {
		return lift;
	}

	public void setLift(String lift) {
		this.lift = lift;
	}

	public Integer getFirstSetRepTotal() {
		return firstSetRepTotal;
	}

	public void setFirstSetRepTotal(Integer firstSetRepTotal) {
		this.firstSetRepTotal = firstSetRepTotal;
	}

	public Integer getSecondSetRepTotal() {
		return secondSetRepTotal;
	}

	public void setSecondSetRepTotal(Integer secondSetRepTotal) {
		this.secondSetRepTotal = secondSetRepTotal;
	}

	public Integer getThirdSetRepTotle() {
		return thirdSetRepTotle;
	}

	public void setThirdSetRepTotle(Integer thirdSetRepTotle) {
		this.thirdSetRepTotle = thirdSetRepTotle;
	}

	public Integer getAmrapRepTotal() {
		return amrapRepTotal;
	}

	public void setAmrapRepTotal(Integer amrapRepTotal) {
		this.amrapRepTotal = amrapRepTotal;
	}

	public Integer getRpe() {
		return rpe;
	}

	public void setRpe(Integer rpe) {
		this.rpe = rpe;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getTrainingDayId() {
		return trainingDayId;
	}

	public void setTrainingDayId(Integer trainingDayId) {
		this.trainingDayId = trainingDayId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TrainingLog [id=" + id + ", lift=" + lift + ", firstSetRepTotal=" + firstSetRepTotal
				+ ", secondSetRepTotal=" + secondSetRepTotal + ", thirdSetRepTotle=" + thirdSetRepTotle
				+ ", amrapRepTotal=" + amrapRepTotal + ", rpe=" + rpe + ", dateCreated=" + dateCreated
				+ ", trainingDayId=" + trainingDayId + ", userId=" + userId + "]";
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
		TrainingLiftLog other = (TrainingLiftLog) obj;
		return id == other.id;
	}

}
