package au.com.commbank.weathergenerator.forecast;

import au.com.commbank.weathergenerator.EarthParameters;

public class HumidityPredictor {

	public static int predict(double pressure, double temperature) {
		
		//Random factor that should be improved to consider position
		double humidity = 80*Math.random();
		
		// humidity is considered here to be inverse with pressure
		humidity *= 1 + (EarthParameters.PRESSURE_AT_SEA_LEVEL - pressure)/EarthParameters.PRESSURE_AT_SEA_LEVEL;

		// Approximating humidity to add an exponential factor for temperature
		humidity += Math.exp(0.1*temperature);
		
		// limiting humidity by 100
		return Math.min((int)humidity, 100);
	}

}
