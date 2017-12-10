package au.com.commbank.weathergenerator;

import java.util.Calendar;
import java.util.Date;

public enum Season {
	WINTER,SPRING,SUMMER,AUTUMN;

	private static Season[] aussieSeasons = new Season[]{
		SUMMER, SUMMER,
		AUTUMN, AUTUMN, AUTUMN,
		WINTER, WINTER, WINTER,
		SPRING, SPRING, SPRING,
		SUMMER
	};
	
	private static Season getOpposite(Season season) {
		switch(season){
			case AUTUMN: return SPRING;
			case SPRING: return AUTUMN;
			case SUMMER: return WINTER;
			case WINTER: return SUMMER;
		}
		return season;
	}
	
	public static Season getSeason(double latitude, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		if(latitude < 0) {
			return (aussieSeasons[month]);
		}
		return getOpposite(aussieSeasons[month]);
	}
}
