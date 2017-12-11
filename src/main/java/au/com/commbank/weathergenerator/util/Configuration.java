package au.com.commbank.weathergenerator.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

/**
 * This class contains the basic configuration for the App
 * 
 * @author leandropadua
 *
 */
public class Configuration {

	private int numberOfLocations = 10;
	private boolean useNamedLocations = true;

	public int getNumberOfLocations() {
		return numberOfLocations;
	}

	public boolean useNamedLocations() {
		return useNamedLocations;
	}

	/**
	 * Create a new configuration loading data from a JSON file
	 * 
	 * @param filename
	 *            The location of the file
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public Configuration(String filename) throws NumberFormatException {
		String configContent;
		try {
			configContent = readFile(filename, StandardCharsets.UTF_8);
			loadConfig(configContent);
		} catch (IOException e) {
			System.err.println("Using default configuration due to failure on loading config.json: " + e.getMessage());
		}
	}

	private static String readFile(String path, Charset encoding) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)), encoding);
	}

	private void loadConfig(String config) {
		JSONObject jsonConfig = new JSONObject(config);
		this.numberOfLocations = jsonConfig.getInt("numberOfLocations");
		this.useNamedLocations = jsonConfig.getBoolean("useNamedLocations");
	}

}
