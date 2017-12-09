package au.com.commbank.weathergenerator.util;

import java.util.Random;

import au.com.commbank.weathergenerator.Position;

/**
 * This class generates a random position on Earth
 * @author leandropadua
 *
 */
public final class RandomPositionGenerator {

	/**
	 * Private constructor to prevent class instantiation
	 */
	private RandomPositionGenerator(){}
	
	private final static int EVEREST_ALTITUDE = 8848; // in meters
	
	private static double generateDouble(double min, double max){
		return min + (max - min) * new Random().nextDouble();
	}
	
	private static int generateInt(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	/**
	 * Generate a random geographic Position
	 * including latitude, longitude and elevation
	 * @return random Position
	 */
	public static Position generatePosition() {
		
		double latitude = generateDouble(-90.0, 90.0);
		double longitude = generateDouble(-180.0, 180.0);
		int elevation = generateInt(0, EVEREST_ALTITUDE);
		return new Position(latitude,longitude,elevation);
	}
	
}
