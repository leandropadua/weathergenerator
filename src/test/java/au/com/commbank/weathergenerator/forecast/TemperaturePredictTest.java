package au.com.commbank.weathergenerator.forecast;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import au.com.commbank.weathergenerator.Position;

public class TemperaturePredictTest {

	private Position position;
	private Position positionHighLatitude;
	private Date night;
	private Date day;
	
	@Before
	public void init(){
		position = new Position(0.0, 0.0, 0);
		positionHighLatitude = new Position(85.0, 0.0, 0);
		night = Timestamp.valueOf("2015-12-25 0:02:12");
		day = Timestamp.valueOf("2015-12-25 12:02:12");
	}
	
	@Test
	public void shouldBeLowerAtNight() {
		double nightTemperature = TemperaturePredictor.predict(position, night, false);
		double dayTemperature = TemperaturePredictor.predict(position, day, false);
		assertTrue(dayTemperature > nightTemperature);
		
		night = Timestamp.valueOf("2015-12-25 06:02:12");
		day = Timestamp.valueOf("2015-12-25 15:02:12");
		nightTemperature = TemperaturePredictor.predict(position, night, false);
		dayTemperature = TemperaturePredictor.predict(position, day, false);
		assertTrue(dayTemperature > nightTemperature);
	}
	
	@Test
	public void shouldBeLowerAtHighLatitude() {
		double highLatitudeTemperature = TemperaturePredictor.predict(positionHighLatitude, day, false);
		double lowLatitudeTemperature = TemperaturePredictor.predict(position, day, false);
		assertTrue(lowLatitudeTemperature > highLatitudeTemperature);
	}
	
	@Test
	public void shouldBeHigherAtSummer() {
		Position australia = new Position(-31.0, 145.0, 1000);
		Date summerDay = Timestamp.valueOf("2015-12-25 0:00:00");
		Date winterDay = Timestamp.valueOf("2015-08-25 0:00:00");
		double summerTemperature = TemperaturePredictor.predict(australia, summerDay, false);
		double winterTemperature = TemperaturePredictor.predict(australia, winterDay, false);
		assertTrue(summerTemperature > winterTemperature);
	}
	
	@Test
	public void shouldBeLowerAtTheMountains(){
		Position mountain = new Position(0.0, 0.0, 5000);
		double seaTemperature = TemperaturePredictor.predict(position, day, false);
		double mountainTemperature = TemperaturePredictor.predict(mountain, day, false);
		assertTrue(seaTemperature > mountainTemperature);
	}
}
