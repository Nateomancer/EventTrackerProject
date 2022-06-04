package com.skilldistillery.powerlifting.entites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrainingDayLiftTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private TrainingDayLift trainingDayLift;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		emf=Persistence.createEntityManagerFactory("PowerliftingJPA");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		
		em=emf.createEntityManager();
		trainingDayLift=em.find(TrainingDayLift.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		em.close();
		trainingDayLift=null;
		
	}

	@Test
	@DisplayName("test basic_entity_mapping")
	void test_basic_entity_mapping() {
		
		System.err.println("TESTING BASIC TRANING DAY MAPPINGS");
		System.err.println(trainingDayLift);
		assertNotNull(trainingDayLift);
		assertEquals("Bench",trainingDayLift.getTrainingLift());
		assertEquals(235, trainingDayLift.getFirstSetWeight());
		assertEquals(250, trainingDayLift.getSecondSetWeight());
		assertEquals(270, trainingDayLift.getThirdSetWeight());
		assertEquals(185, trainingDayLift.getAmrapWeight());
		
//		assertEquals(250, post.getCreatedAt().getYear());
//		assertEquals(3, post.getCreatedAt().getMonthValue());
		
		
	}

}
