package core;

import java.util.HashMap;
import java.util.Map;

/**
 * This class handles the Environment Variables of the Invoicing System
 * 
 * @author ArmandoNCM
 *
 */
public class EnvironmentVariables {

	/**
	 * Invoicing Resolution number issued by the local authorities (DIAN)
	 */
	public final static String INVOICING_RESOLUTION = "INVOICING_RESOLUTION";
	/**
	 * Map used to store the Key, Value pairs of Environment Variables
	 */
	private static Map<String, String> environmentVariables = new HashMap<>();
	/**
	 * Adds a new Environment Variable
	 * @param key Key of the Environment Variable to store
	 * @param value Value of the Environment Variable to store 
	 */
	public static void addEnvironmentVariable(String key, String value) {
		environmentVariables.put(key, value);
	}
	/**
	 * Retrieves an Environment Variable 
	 * @param key Key of the Environment Variable to retrieve
	 * @return Value of the Environment Variable
	 */
	public static String getEnvironmentVariable(String key) {
		return environmentVariables.get(key);
	}

}
