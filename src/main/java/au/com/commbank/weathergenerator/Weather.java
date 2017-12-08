package au.com.commbank.weathergenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Weather {
	private String name;
	private Position position;
	private Date datetime;
	private Condition condition;
	private Double temperature;
	private Double pressure;
	private int humidity;
	
	public Weather(String name, Position position, Date datetime, Condition condition, Double temperature,
			Double pressure, int humidity) {
		super();
		this.name = name;
		this.position = position;
		this.datetime = datetime;
		this.condition = condition;
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return String.format("%s|%.2f,%.2f,%d|%s|%s|%+.1f|%.1f|%d",
				name,
				position.getLatitude(),
				position.getLongitude(),
				position.getElevation(),
				new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(datetime),
				condition,
				temperature,
				pressure,
				humidity);
	}

}
