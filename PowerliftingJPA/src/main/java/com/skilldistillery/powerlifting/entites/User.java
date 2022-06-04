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
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private Integer weight;

	private String height;

	private Integer age;

	private String gender;

	@Column(name = "bench_pr")
	private Integer benchPR;

	@Column(name = "squat_pr")
	private Integer squartPR;

	@Column(name = "deadlift_pr")
	private Integer deadliftPR;

	private String username;

	private String password;

	private String role;

	private Integer active;

	@Column(name = "date_created")
	@CreationTimestamp
	private LocalDateTime dateCreated;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getBenchPR() {
		return benchPR;
	}

	public void setBenchPR(Integer benchPR) {
		this.benchPR = benchPR;
	}

	public Integer getSquartPR() {
		return squartPR;
	}

	public void setSquartPR(Integer squartPR) {
		this.squartPR = squartPR;
	}

	public Integer getDeadliftPR() {
		return deadliftPR;
	}

	public void setDeadliftPR(Integer deadliftPR) {
		this.deadliftPR = deadliftPR;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", weight=" + weight
				+ ", height=" + height + ", age=" + age + ", gender=" + gender + ", benchPR=" + benchPR + ", squartPR="
				+ squartPR + ", deadliftPR=" + deadliftPR + ", username=" + username + ", password=" + password
				+ ", role=" + role + ", active=" + active + ", dateCreated=" + dateCreated + "]";
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
		User other = (User) obj;
		return id == other.id;
	}

}
