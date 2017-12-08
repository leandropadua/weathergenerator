package au.com.commbank.weathergenerator.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public final class RandomDateGenerator {

	private RandomDateGenerator() {}
	
	public static Date generate(Date first, Date last) {
		long offset = first.getTime();
		long end = last.getTime();
		long diff = end - offset + 1;
		Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
		return rand;
	}
	
	public static Date generate(){
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, -1);
		Date lastYear = cal.getTime();
		return generate(lastYear, today);
	}
}
