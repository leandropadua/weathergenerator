package au.com.commbank.weathergenerator.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class LocationGeneratorTest {

	private LocationGenerator defaultGenerator;
	private LocationGenerator generator;
	private Path path;

	@Before
	public void init(){
		defaultGenerator = new LocationGenerator();
		path = Paths.get(System.getProperty("user.dir"), "src", "test", "data", "locations.txt");
	}
	
	@Test
	public void shouldLoadLocations() throws IOException {
		generator = new LocationGenerator(path.toString());
		String generated = generator.generateLocationName();
		assertTrue(!generated.isEmpty() && !generated.equals("Location 1"));
	}
	
	@Test
	public void shouldLoadDefaultGenerator(){
		String generated = defaultGenerator.generateLocationName();
		assertTrue(generated.equals("Location 1"));
	}
	
}
