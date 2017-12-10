package au.com.commbank.weathergenerator.util;

import java.io.*;
import java.util.ArrayList;

/**
 * This class generates names for locations
 * @author leandropadua
 *
 */
public class LocationGenerator {
	
	private ArrayList<String> locations;
	private int counter = 0;

	/**
	 * Create a Location Generator and load names from file
	 * @param locationsFile File with locations at each line
	 * @throws IOException
	 */
	public LocationGenerator(String locationsFile) throws IOException {
		loadLocationsFromFile(locationsFile);
	}

	/**
	 * Default generator will create names like Location N
	 */
	public LocationGenerator() {
		locations = new ArrayList<String>();
	}

	private void loadLocationsFromFile(String locationsFile) throws IOException {
		File file = new File(locationsFile);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		locations = new ArrayList<String>();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			locations.add(line);
		}
		fileReader.close();
	}

	/**
	 * Gets a random name from the loaded names
	 * Generate a default name if there's no name available
	 * @return A location name
	 */
	public String generateLocationName() {
		if(locations.size() == 0) {
			counter ++;
			return "Location " + counter;
		}
		
		int random = (int)(Math.random() * locations.size()) ;
		String location = locations.get(random);
		locations.remove(random);
		return location;
	}

}
