package au.com.commbank.weathergenerator;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {
	
	@Test
	public void shouldLoadConfigurationFromFile(){
		assertTrue(App.loadConfiguration());
	}
	
	@Test
	public void shouldLoadLocationsFromFile(){
		assertTrue(App.loadLocations());
	}
	
}
