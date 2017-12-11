package au.com.commbank.weathergenerator.forecast;

import static org.junit.Assert.*;

import org.junit.Test;

import au.com.commbank.weathergenerator.Condition;

public class ConditionTest {

	@Test
	public void shouldNotSnowInPositiveTemperatures() {
		assertTrue(ConditionPredictor.predict(0, 5) != Condition.SNOW);
	}

	@Test
	public void shouldRainWithHighHumidityAndPositiveTemperature() {
		assertTrue(ConditionPredictor.predict(100, 10) == Condition.RAIN);
	}

	@Test
	public void shouldSnowWithHighHumidityAndLowTemperature() {
		assertTrue(ConditionPredictor.predict(100, -10) == Condition.SNOW);
	}

	@Test
	public void shouldBeSunnyWhenDryAndWarm() {
		assertTrue(ConditionPredictor.predict(10, 30) == Condition.SUNNY);
	}

}
