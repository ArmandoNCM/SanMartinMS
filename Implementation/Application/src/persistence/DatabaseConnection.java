package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class implements a Singleton pattern for the DataBase connection It
 * quickly implements methods to send queries to the database
 * 
 * @author ArmandoNCM
 *
 */
public class DatabaseConnection {
	/**
	 * Used by the SQL syntax to enquote string values
	 */
	private static final char QUOTATION_SYMBOL = '\'';
	/**
	 * Date format used to persist Date objects into DATETIME MySQL Type
	 */
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * Database User
	 * 
	 * TODO change user
	 */
	private static final String DB_USER = "root";
	/**
	 * Database user password
	 * 
	 * TODO change password
	 */
	private static final String DB_PASSWORD = "welcome1";
	/**
	 * Used by the SQL syntax as a Column separator
	 */
	public static final char COLUMN_SEPARATOR = ',';

	public static final String CONNECTION_URL = "";
	/**
	 * Singleton pattern
	 */
	private static DatabaseConnection instance;
	/**
	 * JDBC Connection
	 */
	private Connection connection;

	/**
	 * Private constructor used by Singleton pattern
	 */
	private DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Queries the database with the given query string
	 * 
	 * @param query
	 *            SQL Query
	 * @return ResultSet containing for the query
	 */
	public ResultSet queryDatabase(String query) {
		try {
			Statement statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Executes an UPDATE or INSERT operation with the given SQL statement
	 * 
	 * @param statement
	 *            SQL Statement to execute
	 * @return True if the operation was successful
	 */
	public boolean executeUpdate(String query) {
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			connection.commit();
			return result == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Returns an instance of the DatabaseConnection Uses Singleton pattern
	 * 
	 * @return Class instance
	 */
	public static final DatabaseConnection getInstance() {
		if (instance == null)
			instance = new DatabaseConnection();
		return instance;
	}

	/**
	 * Enquotes a string value using the QUOTATION_SYMBOL
	 * 
	 * @param columnValue
	 *            String to enquote
	 * @return Enquoted String
	 */
	public static final String enquoteColumn(String columnValue) {
		if (columnValue == null)
			return null;
		return QUOTATION_SYMBOL + columnValue + QUOTATION_SYMBOL;
	}

	/**
	 * Format Date into String to insert in Database
	 * 
	 * @param date
	 *            Date to be formated
	 * @return Date formated as String
	 */
	public static final String formatDate(Date date) {
		return QUOTATION_SYMBOL + DATE_FORMAT.format(date) + QUOTATION_SYMBOL;
	}
}
