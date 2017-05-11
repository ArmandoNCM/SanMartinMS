package persistence.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import entity.Item;
import persistence.DatabaseConnection;

public class ItemHandler {
	
	private static final String ITEM_TABLE_NAME = "ITEM";
	private static final String ITEM_CODE = "ITEM_CODE";
	private static final String DESCRIPTION = "DESCRIPTION";
	private static final String BAR_CODE = "BAR_CODE";
	
	private static final String ITEM_PRICE_TABLE_NAME = "ITEM_PRICE";
	private static final String ITEM = "ITEM";
	private static final String SET_DATE = "SET_DATE";
	private static final String UNIT_PRICE = "UNIT_PRICE";
	private static final String IVA_PERCENT = "IVA_PERCENT";
	private static final String ACTIVE = "ACTIVE";
	
	private static final String SQL_QUERY = "SELECT * FROM " + ITEM_TABLE_NAME + " INNER JOIN " + ITEM_PRICE_TABLE_NAME + " ON " + ITEM_TABLE_NAME + "." + ITEM_CODE + "=" + ITEM_PRICE_TABLE_NAME + "." + ITEM + " WHERE " + ACTIVE + "='Y'";
	
	private static final String SQL_INSERT_ITEM = "INSERT INTO " + ITEM_TABLE_NAME + " VALUES (";
	
	private static final String SQL_INSERT_ITEM_PRICE = "INSERT INTO " + ITEM_PRICE_TABLE_NAME + " VALUES (";
	
	/**
	 * Fetches all the items in the database
	 * @return Collection of items
	 */
	public static final Collection<Item> fetchItems(){
		DatabaseConnection connection = DatabaseConnection.getInstance();
		String query = SQL_QUERY;
		ResultSet result = connection.queryDatabase(query);
		
		try {
			Item item;
			Collection<Item> items = new ArrayList<>();
			while(result.next()){
				item = new Item();
				item.setCode(result.getString(ITEM_CODE));
				item.setDescription(result.getString(DESCRIPTION));
				item.setPrice(result.getInt(UNIT_PRICE));
				item.setIvaPercent(result.getInt(IVA_PERCENT));
				item.setBarCode(result.getString(BAR_CODE));
				items.add(item);
			}
			return items;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Persists an item and its current price
	 * @param item Item to be persisted
	 */
	public static final void persistItem(Item item){
		DatabaseConnection connection = DatabaseConnection.getInstance();
		String sqlInsert = SQL_INSERT_ITEM;
		sqlInsert += DatabaseConnection.enquoteColumn(item.getCode());
		sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
		sqlInsert += DatabaseConnection.enquoteColumn(item.getDescription());
		sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
		sqlInsert += DatabaseConnection.enquoteColumn(item.getBarCode());
		sqlInsert += ")";

		connection.executeUpdate(sqlInsert);
		
		sqlInsert = SQL_INSERT_ITEM_PRICE;
		sqlInsert += DatabaseConnection.enquoteColumn(item.getCode());
		sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
		sqlInsert += DatabaseConnection.formatDate(new Date());
		sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
		sqlInsert += item.getPrice();
		sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
		sqlInsert += item.getIvaPercent();
		sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
		sqlInsert += "Y";
		sqlInsert += ")";
		
		connection.executeUpdate(sqlInsert);
	}
	
	// TODO Implement price update

}
