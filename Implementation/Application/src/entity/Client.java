package entity;

import java.util.Map;

/**
 * This class represents a client that can have many dispatches of his own
 * 
 * @author ArmandoNCM
 *
 */
public class Client {

	/**
	 * This Map holds the dispatches in a Map<displayName, completeAddress>
	 */
	private Map<String, String> dispatches;

	/**
	 * The NIT of the client
	 */
	private String nit;
	/**
	 * Display Name of the Client
	 */
	private String name;

	public Map<String, String> getDispatches() {
		return dispatches;
	}

	public void setDispatches(Map<String, String> dispatches) {
		this.dispatches = dispatches;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
