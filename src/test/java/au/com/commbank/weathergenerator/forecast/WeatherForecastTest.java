package au.com.commbank.weathergenerator.forecast;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import au.com.commbank.weathergenerator.Position;
import au.com.commbank.weathergenerator.Weather;

public class WeatherForecastTest {

	private Position position;
	private Date date;
	Weather weather;
	WeatherForecaster forecaster;
	
	@Before
	public void init(){
		position = new Position(0.0, 0.0, 0);
		date = Timestamp.valueOf("2015-12-25 0:02:12");
		forecaster = new WeatherForecaster();
		weather = forecaster.forecast(position, date);
	}
	
	@Test
	public void shouldNotBeEmpty() {
		assertTrue(weather.getCondition() != null &&
				weather.getDatetime().equals(date) &&
				weather.getLocation() == "" &&
				weather.getPosition().equals(position) &&
				weather.getPressure() > 0 && 
				weather.getHumidity() > 0 &&
				weather.getTemperature() > -273);
				
	}
	
}
