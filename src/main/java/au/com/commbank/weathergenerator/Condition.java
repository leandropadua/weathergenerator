package au.com.commbank.weathergenerator;

public enum Condition {
	RAIN,SNOW,SUNNY;
	
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
