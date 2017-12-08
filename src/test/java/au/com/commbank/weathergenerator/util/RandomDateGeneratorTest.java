package au.com.commbank.weathergenerator.util;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class RandomDateGeneratorTest {

	@Test
	public void shouldGenerateDateForLastYear(){
		Date generated = RandomDateGenerator.generate();
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, -1);
		cal.add(Calendar.HOUR, 1);
		Date lastYear = cal.getTime();
		assertTrue(today.after(generated));
		assertTrue(lastYear.before(generated));
	}
	
	@Test
	public void shouldGenerateInInterval(){
		Date begin = Timestamp.valueOf("2015-12-23 05:02:12");
		Date end = Timestamp.valueOf("2016-11-24 15:32:40");
		Date generated = RandomDateGenerator.generate(begin, end);
		assertTrue(end.after(generated));
		assertTrue(begin.before(generated));
	}
}
