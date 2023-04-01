package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DietPlannerTest {

	private DietPlanner dietPlanner;
	
	@BeforeEach
	void setup() {
		this.dietPlanner = new DietPlanner(20, 30, 50);
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("A unit test was finished");
	}
	
	@Test
	void testCalculateDiet() {

		// given
		Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
		DietPlan expected = new DietPlan(2202, 110, 73, 275);
		
		// when 
		DietPlan actual = this.dietPlanner.calculateDiet(coder);
		
		// then
		assertAll(
				() -> assertEquals(expected.getCalories(), actual.getCalories()),
				() -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate()),
				() -> assertEquals(expected.getFat(), actual.getFat()),
				() -> assertEquals(expected.getProtein(), actual.getProtein())
		);
	}

}
