package au.com.commbank.weathergenerator.forecast;

import static org.junit.Assert.*;

import org.junit.Test;

import au.com.commbank.weathergenerator.EarthParameters;

public class HumidityPredictorTest {

	@Test
	public void shouldBeHigherInHighTemeratures(){
		double humidityHighTemperature = 0;
		for(int i = 0; i < 100; i ++) {
		    double temperature = 30;
			humidityHighTemperature += HumidityPredictor.predict(EarthParameters.PRESSURE_AT_SEA_LEVEL, temperature);
		};
		humidityHighTemperature /= 100;
		
		double humidityLowTemperature = 0;
		for(int i = 0; i < 100; i ++) {
		    double temperature = 10;
		    humidityLowTemperature += HumidityPredictor.predict(EarthParameters.PRESSURE_AT_SEA_LEVEL, temperature);
		};
		humidityLowTemperature /= 100;
		
		assertTrue(humidityLowTemperature < humidityHighTemperature);
	}
}
