package au.com.commbank.weathergenerator;

import static org.junit.Assert.*;
import java.sql.Timestamp;
import org.junit.Test;

public class WeatherTest {
	
	@Test
	public void shouldPrintFieldsSeparatedWithVerticalBars() {
		
		Weather weatherSydney = new Weather("Sydney",
				new Position(-33.86,151.21,39),
				Timestamp.valueOf("2015-12-23 05:02:12"),
				Condition.RAIN,
				12.5,
				1004.3,
				97);
		
		Weather weatherMelbourne = new Weather("Melbourne",
				new Position(-37.83,144.98,7),
				Timestamp.valueOf("2015-12-24 15:30:55"),
				Condition.SNOW,
				-5.301,
				998.4,
				55);
		
		Weather weatherAdelaide = new Weather("Adelaide",
				new Position(-34.92,138.62,48),
				Timestamp.valueOf("2016-01-03 12:35:37"),
				Condition.SUNNY,
				39.40,
				1114.10,
				12);
		
		assertEquals("Sydney|-33.86,151.21,39|2015-12-23T05:02:12Z|Rain|+12.5|1004.3|97",
				weatherSydney.toString());
		assertEquals("Melbourne|-37.83,144.98,7|2015-12-24T15:30:55Z|Snow|-5.3|998.4|55",
				weatherMelbourne.toString());
		assertEquals("Adelaide|-34.92,138.62,48|2016-01-03T12:35:37Z|Sunny|+39.4|1114.1|12",
				weatherAdelaide.toString());
	}
	
	
}
