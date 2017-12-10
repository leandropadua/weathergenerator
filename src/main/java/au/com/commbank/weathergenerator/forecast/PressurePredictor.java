package au.com.commbank.weathergenerator.forecast;

import au.com.commbank.weathergenerator.EarthParameters;

/**
 * This class predict the atmospheric pressure based on other factors
 * @author leandropadua
 *
 */
public class PressurePredictor {
	
	/**
	 * This function returns the predicted pressure at a certain elevation
	 * It is discarded the effect of the temperature on pressure as it is
	 * less relevant than elevation for the temperature variation experienced
	 * on Earth.
	 * @param position Elevation in meters
	 * @return Atmospheric pressure in hPa
	 */
	public static double predict(int elevation) {
		// Assuming linear
		double pressure = elevation 
				* (EarthParameters.PRESSURE_AT_MAX_ELEVATION - EarthParameters.PRESSURE_AT_SEA_LEVEL)/EarthParameters.MAX_ELEVATION
				+ EarthParameters.PRESSURE_AT_SEA_LEVEL;
		return pressure;
	}

}
