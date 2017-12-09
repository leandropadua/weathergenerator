package au.com.commbank.weathergenerator;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import au.com.commbank.weathergenerator.forecast.WeatherForecaster;
import au.com.commbank.weathergenerator.localiser.Localiser;
import au.com.commbank.weathergenerator.util.Configuration;
import au.com.commbank.weathergenerator.util.RandomDateGenerator;
import au.com.commbank.weathergenerator.util.RandomPositionGenerator;

/**
 * Weather Generator
 * This app is used to generate weather information about different locations
 * on Earth. The result of an execution is printed on the output with multiple lines
 * in which each of them have the data of a specific location in a specific date.
 *
 */
public class App 
{
	private static final String CONFIG_FILE = Paths.get(System.getProperty("user.dir"),"config.json").toString();
	private static Configuration configuration;
	
    public static void main( String[] args )
    {
    	loadConfiguration();
    	WeatherForecaster weatherForecaster = new WeatherForecaster();
    	for(int i = 0; i < configuration.getNumberOfLocations(); i++){
    		Date date = RandomDateGenerator.generateForLastYear();
    		Position position = RandomPositionGenerator.generatePosition();
    		Weather weather = weatherForecaster.forecast(position, date);
    		weather.setLocation(Localiser.localise(position));
    		System.out.println(weather);
    	}
    }
    
    private static Configuration loadConfiguration() {
    	if(configuration != null) {
    		return configuration;
    	}
    	try {
    		configuration = new Configuration(CONFIG_FILE);
		} catch (Exception e) {
			System.out.println("[Error] Using default configuration due to failure on loading config. " + e.getMessage());
			configuration = new Configuration();
		}
		return configuration;
    }
    
}
