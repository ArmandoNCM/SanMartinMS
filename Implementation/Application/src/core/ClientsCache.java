package core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entity.Client;

/**
 * This class holds a Map of the existing Clients in cache memory Uses Singleton
 * pattern
 * 
 * @author ArmandoNCM
 *
 */
public class ClientsCache {
	/**
	 * Instance used in Singleton
	 */
	private static ClientsCache instance;
	/**
	 * Map used to cache clients
	 */
	private Map<String, Client> clients;

	/**
	 * Private constructor used in Singleton
	 */
	private ClientsCache() {
		clients = new HashMap<>();
	}

	/**
	 * Caches a client to memory
	 * 
	 * @param client
	 *            Client to be cached
	 */
	public void cacheClient(Client client) {
		clients.put(client.getNit(), client);
	}

	/**
	 * Retrieves a cached client given his NIT
	 * 
	 * @param nit
	 *            NIT of the Client to be retrieved
	 * @return A client
	 */
	public Client getClient(String nit) {
		return clients.get(nit);
	}

	/**
	 * Singleton pattern
	 * 
	 * @return Instance of the Clients Cache
	 */
	public static final ClientsCache getInstance() {
		if (instance == null)
			instance = new ClientsCache();
		return instance;
	}

	/**
	 * Gets a collection of clients
	 * 
	 * @return Collection of clients
	 */
	public Collection<Client> getClients() {
		return clients.values();
	}

}
