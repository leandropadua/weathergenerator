package au.com.commbank.weathergenerator.forecast;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import au.com.commbank.weathergenerator.PlanetParameters;
import au.com.commbank.weathergenerator.Position;
import au.com.commbank.weathergenerator.Season;

/**
 * This class can be used to forecast temperature on earth
 * @author leandropadua
 *
 */
public class TemperaturePredictor {

	/**
	 * Predict the temperature based on position and date
	 * @param position
	 * @param date
	 * @return temperature
	 */
	public static double predict(Position position, Date date, boolean useRandomFactor) {

		double temperature = PlanetParameters.AVERAGE_TEMPERATURE_AT_ZERO_LATITUDE;
		
		if(useRandomFactor){
			// random factor between 0.8 to 1.2 to include other factors
			double randomFactor = 0.8 + (1.2 - 0.8) * new Random().nextDouble();
			temperature *= randomFactor;
		}
		
		double seasonFactor = getSeasonFactor(position.getLatitude(), date);
		temperature *= seasonFactor;
		
		double timeOfDayFactor = getTimeOfDayFactor(date);
		temperature *= timeOfDayFactor;
		
		double latitudeFactor = getLatitudeFactor(position.getLatitude());
		temperature += latitudeFactor;

		double elevationFactor = getElevationFactor(position.getElevation());
		temperature += elevationFactor;
		
		return temperature;
	}
	
	public static double predict(Position position, Date date) {
		return predict(position, date, true);
	}

	/**
	 * Drop temperature when is night and increase during the day
	 * The drop is higher hour close to midnight and the increase
	 * is higher when is close to midday
	 * @param date
	 * @return factor to multiply temperature
	 */
	private static double getTimeOfDayFactor(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		double timeOfDayFactor = 1.0;
		
		if(hour > 11 && hour < 14) {
			timeOfDayFactor = 1.2;
		}
		
		if (hour < 5 || hour > 23) {
			timeOfDayFactor = 0.8;
		}
		
		if(hour > 5 && hour < 7) {
			timeOfDayFactor = 0.9;
		}
		
		if(hour > 14 && hour < 16) {
			timeOfDayFactor = 1.1;
		}
		
		return timeOfDayFactor;
	}

	/**
	 * For simplicity this function consider that temperature will
	 * drop 4 degrees every kilometer up
	 * @param elevation in meters
	 * @return temperature drop as negative number
	 */
	private static double getElevationFactor(int elevation) {
		return -elevation * 4 / 1000;
	}

	/**
	 * For simplicity this function consider that temperature will drop
	 * 1C every 5 degrees if |lat| < 30
	 * 1C every 3 degrees if 30 < |lat| < 60
	 * 1C every 2 degrees if |lat| > 90 
	 * @param latitude in degrees
	 * @return temperature drop as negative number
	 */
	private static double getLatitudeFactor(double latitude) {
		double drop = 0;
		double positiveLatitude = Math.abs(latitude);
		int dropFactor = 5;
		
		while(positiveLatitude > 0){
			drop += Math.min(30.0,positiveLatitude)/dropFactor;
			positiveLatitude -= 30;
			dropFactor -= dropFactor/2;
		}
		
		return -drop;
	}

	/**
	 * Increase temperature during summer and decrease during winter
	 * @param latitude
	 * @param date
	 * @return season factor to multiply temperature
	 */
	private static double getSeasonFactor(double latitude, Date date) {
		Season season = Season.getSeason(latitude, date);
		double seasonFactor;
		switch(season) {
			case SUMMER:
				seasonFactor = 1.5;
				break;
			case WINTER:
				seasonFactor = 0.25;
				break;
			default:
				seasonFactor = 1.0;
				break;
		}

		return seasonFactor;
	}


}
