package au.com.commbank.weathergenerator.forecast;

import java.util.Random;

import au.com.commbank.weathergenerator.Condition;

/**
 * Generate condition based on the humidity and temperature
 *  
 * @author leandropadua
 *
 */
public final class ConditionPredictor {

	/**
	 * The prediction is modeled to be proportional to humidity
	 * 
	 * @param humidity in %
	 * @param temperature in Celsius
	 * @return A weather condition
	 */
	public static Condition predict(int humidity, double temperature) {
		
		// Add random factor between 0.5 and 1.0
		double randomFactor = 0.5 + 0.5 * new Random().nextDouble();
		
		// Chance of snow grows with humidity and with the decrease of temperature
		double chanceOfSnow = temperature > -1 ? 0 : Math.min(humidity - temperature, 100) * randomFactor;
		if(chanceOfSnow > 40) {
			return Condition.SNOW;
		}
		
		// Chance of rain grows with humidity
		double chanceOfRain = humidity * randomFactor;
		if(chanceOfRain > 40) {
			return Condition.RAIN;
		}
		
		return Condition.SUNNY;
	}

}
