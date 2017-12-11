package au.com.commbank.weathergenerator;

/**
 * This class represents a position on Earth described using latitude, longitude
 * in degrees and elevation in meters.
 * 
 * @author leandropadua
 *
 */
public class Position {
	private Double latitude;
	private Double longitude;
	private int elevation;

	public Position(Double latitude, Double longitude, int elevation) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public int getElevation() {
		return elevation;
	}

}
