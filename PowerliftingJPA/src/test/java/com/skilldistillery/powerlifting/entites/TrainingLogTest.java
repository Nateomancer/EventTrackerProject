package com.skilldistillery.powerlifting.entites;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainingLogTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private TrainingLog trainingLog;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		emf = Persistence.createEntityManagerFactory("PowerliftingJPA");

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {

		em = emf.createEntityManager();
		trainingLog = em.find(TrainingLog.class, 1);

	}

	@AfterEach
	void tearDown() throws Exception {

		em.close();
		trainingLog = null;

	}

	@Test
	void test() {
		assertNotNull(trainingLog);
	}

}
