package core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entity.Item;

/**
 * This class holds a Map of the existing Items in cache memory Uses Singleton
 * pattern
 * 
 * @author ArmandoNCM
 *
 */
public class ItemsCache {

	/**
	 * Singleton pattern
	 */
	private static ItemsCache instance;
	/**
	 * Map of items
	 */
	private Map<String, Item> items;

	/**
	 * Private constructor for Singleton pattern
	 */
	private ItemsCache() {
		items = new HashMap<>();
	}

	/**
	 * Caches an item to memory
	 * 
	 * @param item
	 *            Item to cache
	 */
	public void addItem(Item item) {
		items.put(item.getCode(), item);
	}

	/**
	 * Retrieves an item from cache
	 * 
	 * @param itemCode
	 *            Code of the Item to retrieve
	 * @return Cached item
	 */
	public Item getItem(String itemCode) {
		return items.get(itemCode);
	}

	/**
	 * Gets all the cached items
	 * @return Items in Cache
	 */
	public Collection<Item> getItems() {
		return items.values();
	}

	/**
	 * Singleton pattern
	 * 
	 * @return Class instance
	 */
	public static final ItemsCache getInstance() {
		if (instance == null)
			instance = new ItemsCache();
		return instance;
	}

}
