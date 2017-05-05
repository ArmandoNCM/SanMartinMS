package persistence.handlers;

import entity.Invoice;
import persistence.DatabaseConnection;

/**
 * This class handles the persistence of Invoices
 * @author ArmandoNCM
 *
 */
public class InvoiceHandler {
	private static final String TABLE_NAME = "INVOICE";
	private static final String SERIAL_NUMBER = "SERIAL_NUMBER";
	private static final String PLACED_DATE = "PLACED_DATE";
	private static final String CLIENT = "CLIENT";
	private static final String PAYMENT_DAYS = "PAYMENT_DAYS";
	private static final String SQL_QUERY_SINGLE_INVOICE = "SELECT * FROM " + TABLE_NAME + " WHERE " + SERIAL_NUMBER + "=";
	private static final String SQL_QUERY_MULTIPLE_INVOICE = "SELECT * FROM " + TABLE_NAME + " WHERE " + CLIENT + "=";
	/**
	 * Fetches a single Invoice given the invoice number
	 * @param invoiceNumber Number of the invoice whose data is to be fetched
	 * @return Invoice whose number was given
	 */
	public static final Invoice fetchInvoice(String invoiceNumber){
		
		DatabaseConnection connection = DatabaseConnection.getInstance();
		String query = SQL_QUERY_SINGLE_INVOICE;

		
		
		return null;
	}
}
