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
	/**
	 * Adds a new dispatch to the client
	 * @param displayName Display name of the dispatch
	 * @param address Address of the dispatch
	 */
	public void addDispatch(String displayName, String address){
		dispatches.put(displayName, address);
	}
	/**
	 * Retrieve the display names of the existent dispatches of the client
	 * @return Dispatches display names iterator
	 */
	public Iterable<String> getDispatchNames(){
		return dispatches.keySet();
	}
	/**
	 * Retrieve the full address of a dispatch
	 * @param dispatchName Name of the dispatch whose address is to be fetched
	 * @return Address of the dispatch
	 */
	public String getDispatchAddress(String dispatchName){
		return dispatches.get(dispatchName);
	}
	
	@Override
	public String toString() {
		return nit + " - " + name;
	}

}
