package au.com.commbank.weathergenerator.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is used to generate a random date
 * 
 * @author leandropadua
 *
 */
public final class RandomDateGenerator {

	/**
	 * Private constructor to prevent class instantiation
	 */
	private RandomDateGenerator() {
	}

	/**
	 * Generate a date in a interval
	 * 
	 * @param first
	 *            Beginning of interval
	 * @param last
	 *            End of interval
	 * @return a random date on the specified interval
	 */
	public static Date generate(Date first, Date last) {
		long offset = first.getTime();
		long end = last.getTime();
		long diff = end - offset + 1;
		Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));
		return rand;
	}

	/**
	 * Generate a date on the interval of one year from the current date.
	 * 
	 * @return a random date for the past year
	 */
	public static Date generateForLastYear() {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, -1);
		Date lastYear = cal.getTime();
		return generate(lastYear, today);
	}
}
