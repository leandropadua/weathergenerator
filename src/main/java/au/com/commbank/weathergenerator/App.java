package au.com.commbank.weathergenerator;

import java.nio.file.Paths;

import au.com.commbank.weathergenerator.util.Configuration;

/**
 * Weather Generator
 * This App is used to generate weather information about different locations
 * on Earth. The result of an execution is printed on the output with multiple lines
 * in which each of them have the data of a specific location in a specific date.
 *
 */
public class App 
{
	private static final String CONFIG_FILE = Paths.get(System.getProperty("user.dir"),"config.json").toString();
	private static final String LOCATIONS_FILE = Paths.get(System.getProperty("user.dir"),"data","locations.txt").toString();
	
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration(CONFIG_FILE);
    	WeatherGenerator weatherGenerator = configuration.useNamedLocations() ? 
    			new WeatherGenerator(LOCATIONS_FILE) : new WeatherGenerator();
    	
    	Weather[] weatherData = weatherGenerator.generate(configuration.getNumberOfLocations());
    	for(Weather weather : weatherData){
    		System.out.println(weather);
    	}
    }
    
}
