package au.com.commbank.weathergenerator.forecast;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import au.com.commbank.weathergenerator.Position;
import au.com.commbank.weathergenerator.Weather;

public class WeatherForecastTest {

	@Test
	public void shouldNotBeEmpty() {
		Position position = new Position(0.0, 0.0, 0);
		Date date = Timestamp.valueOf("2015-12-25 0:02:12");
		WeatherForecaster forecaster = new WeatherForecaster();
		Weather weather = forecaster.forecast(position, date);

		assertTrue(weather.getCondition() != null && weather.getDatetime().equals(date)
				&& weather.getLocation().isEmpty() && weather.getPosition().equals(position)
				&& weather.getPressure() > 0 && weather.getHumidity() > 0 && weather.getTemperature() > -273);

	}

}
