package au.com.commbank.weathergenerator.util;

import static org.junit.Assert.*;

import org.junit.Test;

import au.com.commbank.weathergenerator.Position;

public class RandomPositionGeneratorTest {

	private static final int MAX_LATITUDE = 90;
	private static final int MAX_LONGITUDE = 180;
	private static final int EVEREST_ELEVATION = 8848;

	@Test
	public void shouldGenerateValidEarthPosition() {
		Position randomPosition = RandomPositionGenerator.generatePosition();
		assertTrue(randomPosition.getLatitude() < MAX_LATITUDE);
		assertTrue(randomPosition.getLatitude() > -MAX_LATITUDE);
		assertTrue(randomPosition.getLongitude() < MAX_LONGITUDE);
		assertTrue(randomPosition.getLongitude() > -MAX_LONGITUDE);
		assertTrue(randomPosition.getElevation() < EVEREST_ELEVATION);
	}
}
