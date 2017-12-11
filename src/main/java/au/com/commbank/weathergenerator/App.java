package au.com.commbank.weathergenerator;

import java.nio.file.Paths;

import au.com.commbank.weathergenerator.util.Configuration;

/**
 * Weather Generator This App is used to generate weather information about
 * different locations on Earth. The result of an execution is printed on the
 * output with multiple lines in which each of them have the data of a specific
 * location in a specific date.
 *
 */
public class App {
	
	// Default configuration and location names file
	private static final String CONFIG_FILE = Paths.get(System.getProperty("user.dir"), "config.json").toString();
	private static final String LOCATIONS_FILE = Paths.get(System.getProperty("user.dir"), "data", "locations.txt")
			.toString();

	/**
	 * Entry point
	 * @param args
	 */
	public static void main(String[] args) {
		printWeatherData(CONFIG_FILE, LOCATIONS_FILE);
	}
	
	/**
	 * Print generated data according to configuration and locations file
	 * @param configFile
	 * @param locationsFile
	 */
	public static void printWeatherData(String configFile, String locationsFile) {
		Configuration configuration = new Configuration(configFile);
		WeatherGenerator weatherGenerator = configuration.useNamedLocations() ? new WeatherGenerator(locationsFile)
				: new WeatherGenerator();

		Weather[] weatherData = weatherGenerator.generate(configuration.getNumberOfLocations());
		for (Weather weather : weatherData) {
			System.out.println(weather);
		}
	}

}
