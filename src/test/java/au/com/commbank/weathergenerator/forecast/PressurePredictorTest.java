package au.com.commbank.weathergenerator.forecast;

import static org.junit.Assert.*;

import org.junit.Test;

import au.com.commbank.weathergenerator.PlanetParameters;

public class PressurePredictorTest {

	@Test
	public void shouldBePreciseAtSeaLevel(){
		assertTrue(Math.abs(PlanetParameters.PRESSURE_AT_SEA_LEVEL - PressurePredictor.predict(0)) < 0.01);
	}
	
	@Test
	public void shouldBeLowerAtHighElevation(){
		assertTrue(Math.abs(PlanetParameters.PRESSURE_AT_MAX_ELEVATION - PressurePredictor.predict(PlanetParameters.MAX_ELEVATION)) < 0.01);
	}
}
