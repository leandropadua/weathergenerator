package au.com.commbank.weathergenerator.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

/**
 * This class contains the basic configuration for the App
 * @author leandropadua
 *
 */
public class Configuration {

	private int numberOfLocations;
	private boolean useNamedLocations;
	
	public int getNumberOfLocations() {
		return numberOfLocations;
	}

	public boolean isUseNamedLocations() {
		return useNamedLocations;
	}

	/**
	 * Create a new configuration loading data from a JSON file
	 * @param filename The location of the file
	 * @throws IOException 
	 * @throws NumberFormatException
	 */
	public Configuration(String filename) throws IOException, NumberFormatException {
		String configContent = readFile(filename, StandardCharsets.UTF_8);
		loadConfig(configContent);
	}
	
	/**
	 * Create Configuration and set a default value for the properties.
	 */
	public Configuration(){
		this.numberOfLocations = 10;
	}
	
	private static String readFile(String path, Charset encoding) throws IOException 
	{
	  return new String(Files.readAllBytes(Paths.get(path)), encoding);
	}
	
	private void loadConfig(String config) throws NumberFormatException {
		JSONObject jsonConfig = new JSONObject(config);
		String numberOfLocations = jsonConfig.getString("numberOfLocations");
		this.numberOfLocations = Integer.parseInt(numberOfLocations);
		this.useNamedLocations = jsonConfig.getBoolean("useNamedLocations");
	}
	
}
