package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

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
	
	@Nested
	class CalculateDietTests {
		
		@RepeatedTest(10)
		void should_ReturnCorrectDietPlan_When_CorrectCoder() {

			// given
			Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
			DietPlan expected = new DietPlan(2202, 110, 73, 275);
			
			// when 
			DietPlan actual = DietPlannerTest.this.dietPlanner.calculateDiet(coder);
			
			// then
			assertAll(
					() -> assertEquals(expected.getCalories(), actual.getCalories()),
					() -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate()),
					() -> assertEquals(expected.getFat(), actual.getFat()),
					() -> assertEquals(expected.getProtein(), actual.getProtein())
			);
		}
		
	}
	
}
