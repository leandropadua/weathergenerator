package au.com.commbank.weathergenerator;

import java.nio.file.Paths;

import au.com.commbank.weathergenerator.util.Configuration;

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
	
    public static void main( String[] args )
    {
    	// Load configuration file
    	Configuration configuration = new Configuration();
    	try {
			configuration = new Configuration(CONFIG_FILE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error on config.json. Using default configuration.");
		}
    	System.out.println(configuration.getNumberOfLocations());
    }
}
