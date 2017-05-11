package persistence.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import core.ItemsCache;
import entity.Invoice;
import entity.OrderDetail;
import persistence.DatabaseConnection;

/**
 * This class handles the persistence specifically for the OrderDetail class
 * 
 * @author ArmandoNCM
 *
 */
public class OrderDetailHandler {

	private static final String TABLE_NAME = "ORDER_DETAIL";
	private static final String INVOICE = "INVOICE";
	private static final String DETAIL_ITEM = "DETAIL_ITEM";
	private static final String QUANTITY = "QUANTITY";
	private static final String UNIT_PRICE = "UNIT_PRICE";
	private static final String IVA_PERCENT = "IVA_PERCENT";
	private static final String SQL_QUERY = "SELECT * FROM " + TABLE_NAME + " WHERE " + INVOICE + "=";
	private static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES";

	/**
	 * Fetches all OrderDetails for a give Invoice
	 * 
	 * @param invoice
	 *            Invoice whose details are to be fetched
	 * @return Collection of Invoice Details
	 */
	public static final Collection<OrderDetail> fetchInvoiceDetails(Invoice invoice) {
		String invoiceNumber = invoice.getSerialNumber();
		DatabaseConnection dbConnection = DatabaseConnection.getInstance();
		String sqlQuery = SQL_QUERY + DatabaseConnection.enquoteColumn(invoiceNumber);
		ResultSet result = dbConnection.queryDatabase(sqlQuery);
		try {
			OrderDetail orderDetail;
			Collection<OrderDetail> details = new ArrayList<>(); 
			while (result.next()) {
				orderDetail = new OrderDetail();
				orderDetail.setInvoice(invoice);
				orderDetail.setItem(ItemsCache.getInstance().getItem(result.getString(DETAIL_ITEM)));
				orderDetail.setQuantity(result.getInt(QUANTITY));
				orderDetail.setUnitPrice(result.getInt(UNIT_PRICE));
				orderDetail.setIvaPercent(result.getInt(IVA_PERCENT));
				details.add(orderDetail);
			}
			return details;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Persists an order detail to the Database
	 * 
	 * @param invoice
	 *            Invoice whose details are to be persisted
	 */
	public static final void persistInvoiceDetails(Invoice invoice) {
		DatabaseConnection dbConnection = DatabaseConnection.getInstance();
		String sqlInsert = SQL_INSERT;
		for (OrderDetail orderDetail : invoice.getOrderDetails()) {
			if (!sqlInsert.equals(SQL_INSERT))
				sqlInsert += ',';

			sqlInsert += "(";
			sqlInsert += DatabaseConnection.enquoteColumn(orderDetail.getInvoice().getSerialNumber());
			sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
			sqlInsert += DatabaseConnection.enquoteColumn(orderDetail.getItem().getCode());
			sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
			sqlInsert += orderDetail.getQuantity();
			sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
			sqlInsert += orderDetail.getItem().getPrice();
			sqlInsert += DatabaseConnection.COLUMN_SEPARATOR;
			sqlInsert += orderDetail.getItem().getIvaPercent();
			sqlInsert += ")";

		}
		dbConnection.executeUpdate(sqlInsert);
	}

}
