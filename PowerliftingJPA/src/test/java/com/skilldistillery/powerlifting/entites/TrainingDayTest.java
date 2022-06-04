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

class TrainingDayTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private TrainingDay trainingDay;

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
		trainingDay=em.find(TrainingDay.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		em.close();
		trainingDay=null;
		
	}

	@Test
	@DisplayName("test basic_entity_mapping")
	void test_basic_entity_mapping() {
		
		System.err.println("TESTING BASIC TRANING DAY MAPPINGS");
		System.err.println(trainingDay);
		assertNotNull(trainingDay);
		assertEquals("Bench",trainingDay.getTrainingLift());
		assertEquals(235, trainingDay.getFirstSetWeight());
		assertEquals(250, trainingDay.getSecondSetWeight());
		assertEquals(270, trainingDay.getThirdSetWeight());
		assertEquals(185, trainingDay.getAmrapWeight());
		
//		assertEquals(250, post.getCreatedAt().getYear());
//		assertEquals(3, post.getCreatedAt().getMonthValue());
		
		
	}

}
