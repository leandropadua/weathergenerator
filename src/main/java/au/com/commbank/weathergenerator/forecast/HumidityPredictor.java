package au.com.commbank.weathergenerator.forecast;

import au.com.commbank.weathergenerator.PlanetParameters;

/**
 * This class predict air humidity
 * 
 * @author leandropadua
 *
 */
public class HumidityPredictor {

	/**
	 * This prediction consider that humidity are mainly dependent on pressure
	 * and temperature Being inverse with pressure and exponential with
	 * temperature. It is assumed for simplicity that humidity has a max of 100.
	 * 
	 * @param pressure
	 *            in hPan
	 * @param temperature
	 *            in Celsius
	 * @return humidity in percent
	 */
	public static int predict(double pressure, double temperature) {

		// Random factor that should be improved to consider position
		double humidity = 80 * Math.random();

		// humidity is considered here to be inverse with pressure
		humidity *= 1 + (PlanetParameters.PRESSURE_AT_SEA_LEVEL - pressure) / PlanetParameters.PRESSURE_AT_SEA_LEVEL;

		// Approximating humidity to add an exponential factor for temperature
		humidity += Math.exp(0.1 * temperature);

		// limiting humidity by 100
		return Math.min((int) humidity, 100);
	}

}
