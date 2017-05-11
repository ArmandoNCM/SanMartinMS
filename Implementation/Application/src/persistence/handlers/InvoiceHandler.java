package persistence.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import core.ClientsCache;
import entity.Client;
import entity.Invoice;
import persistence.DatabaseConnection;

/**
 * This class handles the persistence of Invoices
 * 
 * @author ArmandoNCM
 *
 */
public class InvoiceHandler {
	private static final String TABLE_NAME = "INVOICE";
	private static final String SERIAL_NUMBER = "SERIAL_NUMBER";
	private static final String PLACED_DATE = "PLACED_DATE";
	private static final String CLIENT = "CLIENT";
	private static final String PAYMENT_DAYS = "PAYMENT_DAYS";
	private static final String SQL_QUERY_SINGLE_INVOICE = "SELECT * FROM " + TABLE_NAME + " WHERE " + SERIAL_NUMBER
			+ "=";
	private static final String SQL_QUERY_MULTIPLE_INVOICE = "SELECT * FROM " + TABLE_NAME + " WHERE " + CLIENT + "=";

	/**
	 * Fetches a single Invoice given the invoice number
	 * 
	 * @param invoiceNumber
	 *            Number of the invoice whose data is to be fetched
	 * @return Invoice whose number was given
	 */
	public static final Invoice fetchInvoice(String invoiceNumber) {

		DatabaseConnection connection = DatabaseConnection.getInstance();
		String query = SQL_QUERY_SINGLE_INVOICE;
		query += DatabaseConnection.enquoteColumn(invoiceNumber);
		ResultSet result = connection.queryDatabase(query);
		try {
			if (result.next()) {
				ClientsCache clientsCache = ClientsCache.getInstance();
				Invoice invoice = new Invoice();
				invoice.setSerialNumber(invoiceNumber);
				invoice.setClient(clientsCache.getClient(result.getString(CLIENT)));
				invoice.setPaymentDays(result.getInt(PAYMENT_DAYS));
				invoice.setPlacedDate(result.getDate(PLACED_DATE));
				return invoice;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Fetches all the invoices belonging to a client
	 * 
	 * @param client
	 *            Client whose invoices are to be fetched
	 * @return Invoices of the client
	 */
	public static final Collection<Invoice> fetchInvoices(Client client) {
		DatabaseConnection connection = DatabaseConnection.getInstance();
		String query = SQL_QUERY_MULTIPLE_INVOICE;
		query += DatabaseConnection.enquoteColumn(client.getNit());
		ResultSet result = connection.queryDatabase(query);
		try {
			Invoice invoice;
			Collection<Invoice> invoices = new ArrayList<>();
			while (result.next()) {
				invoice = new Invoice();
				invoice.setSerialNumber(result.getString(SERIAL_NUMBER));
				invoice.setClient(client);
				invoice.setPaymentDays(result.getInt(PAYMENT_DAYS));
				invoice.setPlacedDate(result.getDate(PLACED_DATE));
				invoices.add(invoice);
			}
			return invoices;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
