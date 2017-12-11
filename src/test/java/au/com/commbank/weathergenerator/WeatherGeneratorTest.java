package au.com.commbank.weathergenerator;

import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;

import org.junit.Test;

public class WeatherGeneratorTest {
	
	@Test
	public void shouldGenerateValidWeather(){
		String locationsFile = Paths.get(System.getProperty("user.dir"), "src", "test", "data", "locations.txt").toString();
		WeatherGenerator generator = new WeatherGenerator(locationsFile);
		Weather[] weatherData = generator.generate(1);
		Weather weather = weatherData[0];
		assertTrue(weather.getCondition() != null &&
				!weather.getLocation().isEmpty() &&
				weather.getPressure() > 0 && 
				weather.getHumidity() > 0 &&
				weather.getTemperature() > -273);
	}
}
