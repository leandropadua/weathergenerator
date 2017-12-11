package au.com.commbank.weathergenerator;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void out() {
		String configFile = Paths
				.get(System.getProperty("user.dir"), "src", "test", "data", "config-single-weather.json").toString();
		String locationsFile = Paths.get(System.getProperty("user.dir"), "src", "test", "data", "locations.txt")
				.toString();
		App.printWeatherData(configFile, locationsFile);
		String weatherPrinted = outContent.toString();

		// Each line has 6 vertical bars
		int countVerticalBars = weatherPrinted.length() - weatherPrinted.replace("|", "").length();
		assertEquals(6, countVerticalBars);
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}
