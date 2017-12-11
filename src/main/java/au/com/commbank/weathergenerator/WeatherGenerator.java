package au.com.commbank.weathergenerator;

import java.util.Date;

import au.com.commbank.weathergenerator.forecast.WeatherForecaster;
import au.com.commbank.weathergenerator.util.LocationGenerator;
import au.com.commbank.weathergenerator.util.RandomDateGenerator;
import au.com.commbank.weathergenerator.util.RandomPositionGenerator;

public class WeatherGenerator {
	
	private LocationGenerator locationGenerator;
	
    public WeatherGenerator(String locationsFile) {
    	locationGenerator = new LocationGenerator(locationsFile);
	}

	public WeatherGenerator() {}

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
