package au.com.commbank.weathergenerator.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void shouldParseNumberOfLocations() throws NumberFormatException, IOException{
		Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "data", "config.json");
		Configuration configuration = new Configuration(path.toString());
		assertEquals(15, configuration.getNumberOfLocations());
	}
	
	@Test
	public void shouldReturnDefaultConfiguration(){
    	Configuration configuration = new Configuration();
    	try {
			configuration = new Configuration("blah blah");
		} catch (Exception e) { }
    	assertEquals(10, configuration.getNumberOfLocations());
	}
}
