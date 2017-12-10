package au.com.commbank.weathergenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains all the bundled information of the weather
 * in a certain location and time.
 * 
 * @author leandropadua
 */
public class Weather {
	
	/*
	 * Location is an optional label describing one or more positions,
 	 * Position is a comma-separated triple containing latitude, longitude, and elevation in meters above sea level,
 	 * Local time is an ISO8601 date time,
 	 * Conditions is either Snow, Rain, Sunny,
 	 * Temperature is in °C,
 	 * Pressure is in hPa, and
 	 * Relative humidity is a %. 
	 */
	private String location;
	private Position position;
	private Date datetime;
	private Condition condition;
	private Double temperature;
	private Double pressure;
	private int humidity;
	
	public Weather(String name, Position position, Date datetime, Condition condition, Double temperature,
			Double pressure, int humidity) {
		super();
		this.location = name;
		this.position = position;
		this.datetime = datetime;
		this.condition = condition;
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
	}

	
	/**
	 * Used to print all the fields separated by vertical bars |
	 * E.g. Sydney|-33.86,151.21,39|2015-12-23T05:02:12Z|Rain|+12.5|1004.3|97
	 */
	@Override
	public String toString() {
		return String.format("%s|%.2f,%.2f,%d|%s|%s|%+.1f|%.1f|%d",
				location,
				position.getLatitude(),
				position.getLongitude(),
				position.getElevation(),
				new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(datetime),
				condition,
				temperature,
				pressure,
				humidity);
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getLocation() {
		return location;
	}


	public Position getPosition() {
		return position;
	}


	public Date getDatetime() {
		return datetime;
	}


	public Condition getCondition() {
		return condition;
	}


	public Double getTemperature() {
		return temperature;
	}


	public Double getPressure() {
		return pressure;
	}


	public int getHumidity() {
		return humidity;
	}
	
	

}
