package au.com.commbank.weathergenerator;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

import au.com.commbank.weathergenerator.forecast.WeatherForecaster;
import au.com.commbank.weathergenerator.util.Configuration;
import au.com.commbank.weathergenerator.util.LocationGenerator;
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
	private static final String LOCATIONS_FILE = Paths.get(System.getProperty("user.dir"),"data","locations.txt").toString();
	private static Configuration configuration;
	private static LocationGenerator locationGenerator;
	
    public static void main( String[] args )
    {
    	loadConfiguration();
    	if(configuration.getNumberOfLocations() > 1000) {
    		System.out.println("Please configure the number of locations to be less than 1000.");
    		return;
    	}
    	WeatherForecaster weatherForecaster = new WeatherForecaster();
    	for(int i = 0; i < configuration.getNumberOfLocations(); i++){
    		Date date = RandomDateGenerator.generateForLastYear();
    		Position position = RandomPositionGenerator.generatePosition();
    		Weather weather = weatherForecaster.forecast(position, date);
    		if(configuration.isUseNamedLocations()) {
    			loadLocations();
    			weather.setLocation(locationGenerator.generateLocationName());
    		}
    		System.out.println(weather);
    	}
    }
    
    public static boolean loadLocations() {
    	if(locationGenerator != null) {
    		return true;
    	}
    	try {
			locationGenerator = new LocationGenerator(LOCATIONS_FILE);
		} catch (IOException e) {
			System.err.println("Using default location names due to failure on loading locations. " + e.getMessage());
			locationGenerator = new LocationGenerator();
			return false;
		}
    	return true;
	}

	public static boolean loadConfiguration() {
    	if(configuration != null) {
    		return true;
    	}
    	try {
    		configuration = new Configuration(CONFIG_FILE);
		} catch (Exception e) {
			System.err.println("Using default configuration due to failure on loading config. " + e.getMessage());
			configuration = new Configuration();
			return false;
		}
    	return true;
    }
    
}
