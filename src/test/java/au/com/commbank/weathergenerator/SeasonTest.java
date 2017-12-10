package au.com.commbank.weathergenerator;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

public class SeasonTest {

	@Test
	public void shouldBeSummerInAustralia(){
		double latitude = -31;
		Date xmas = Timestamp.valueOf("2015-12-25 05:02:12");
		assertEquals(Season.SUMMER, Season.getSeason(latitude, xmas));
	}
	
	@Test
	public void shouldBeWinterInBelarus(){
		double latitude = 56;
		Date xmas = Timestamp.valueOf("2015-12-25 05:02:12");
		assertEquals(Season.WINTER, Season.getSeason(latitude, xmas));
	}
	
	@Test
	public void shouldShowOpposite() {
		assertEquals(Season.SPRING, Season.getOpposite(Season.AUTUMN));
		assertEquals(Season.SUMMER, Season.getOpposite(Season.WINTER));
	}
}
