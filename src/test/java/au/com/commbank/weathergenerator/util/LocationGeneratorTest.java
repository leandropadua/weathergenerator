package au.com.commbank.weathergenerator.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Test;

public class LocationGeneratorTest {


	@Test
	public void shouldLoadLocations() throws IOException {
		String locationsFile = Paths.get(System.getProperty("user.dir"), "src", "test", "data", "locations.txt").toString();
		LocationGenerator generator = new LocationGenerator(locationsFile);
		String generated = generator.generateLocationName();
		assertTrue(!generated.isEmpty() && !"Location 1".equals(generated));
	}
	
	@Test
	public void shouldLoadDefaultGenerator(){
		LocationGenerator defaultGenerator = new LocationGenerator("blah blah");
		String generated = defaultGenerator.generateLocationName();
		assertTrue("Location 1".equals(generated));
	}
	
}
