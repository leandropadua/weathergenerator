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
	
	public static Season getOpposite(Season season) {
		Season opposite = season;
		switch(season){
			case AUTUMN: opposite = SPRING; break;
			case SPRING: opposite = AUTUMN; break;
			case SUMMER: opposite = WINTER; break;
			case WINTER: opposite = SUMMER; break;
		}
		return opposite;
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
