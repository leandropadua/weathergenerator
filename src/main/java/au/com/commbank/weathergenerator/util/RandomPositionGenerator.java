package au.com.commbank.weathergenerator.util;

import java.util.Random;

import au.com.commbank.weathergenerator.PlanetParameters;
import au.com.commbank.weathergenerator.Position;

/**
 * This class generates a random position on Earth
 * 
 * @author leandropadua
 *
 */
public final class RandomPositionGenerator {

	/**
	 * Private constructor to prevent class instantiation
	 */
	private RandomPositionGenerator() {
	}

	private static double generateDouble(double min, double max) {
		return min + (max - min) * new Random().nextDouble();
	}

	private static int generateInt(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	/**
	 * Generate a random geographic Position including latitude, longitude and
	 * elevation
	 * 
	 * @return random Position
	 */
	public static Position generatePosition() {
		double latitude = generateDouble(-90.0, 90.0);
		double longitude = generateDouble(-180.0, 180.0);
		int elevation = generateInt(0, 2 * PlanetParameters.AVERAGE_ELEVATION);

		// In rare situations the elevation must be high
		int dice = generateInt(1, 6);
		if (dice == 6) {
			elevation = generateInt(0, PlanetParameters.MAX_ELEVATION);
		}
		return new Position(latitude, longitude, elevation);
	}

}
