package au.com.commbank.weathergenerator;

/**
 * This enum contains possible different types of weather conditions
 * 
 * @author leandropadua
 *
 */
public enum Condition {
	RAIN,SNOW,SUNNY;
	
	/**
	 * toString will display the name of the enum type using only the first
	 * word in capital letter.
	 */
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
