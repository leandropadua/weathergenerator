package au.com.commbank.weathergenerator;

import java.util.Date;

import au.com.commbank.weathergenerator.forecast.WeatherForecaster;
import au.com.commbank.weathergenerator.util.LocationGenerator;
import au.com.commbank.weathergenerator.util.RandomDateGenerator;
import au.com.commbank.weathergenerator.util.RandomPositionGenerator;

/**
 * This class is used to generate random weather data
 * @author leandropadua
 *
 */
public class WeatherGenerator {
	
	private LocationGenerator locationGenerator;
	
    public WeatherGenerator(String locationsFile) {
    	locationGenerator = new LocationGenerator(locationsFile);
	}

	public WeatherGenerator() {}

	/**
	 * This method generate a random position and a random date
	 * Based on that, it uses a Weather Forecaster to predict
	 * how the weather would be for that position and time
	 * @param n number of weathers to generate
	 * @return An array of weather with size n
	 */
	public Weather[] generate(int n) {
		Weather[] weatherData = new Weather[n];
    	WeatherForecaster weatherForecaster = new WeatherForecaster();
    	for(int i = 0; i < n; i++){
    		Date date = RandomDateGenerator.generateForLastYear();
    		Position position = RandomPositionGenerator.generatePosition();
    		Weather weather = weatherForecaster.forecast(position, date);
    		if(locationGenerator != null) {
    			weather.setLocation(locationGenerator.generateLocationName());
    		}
    		weatherData[i] = weather;
    	}
		return weatherData;
	}
}
