package entity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;


/**
 * This class represents an Invoice
 * 
 * @author ArmandoNCM
 *
 */
public class Invoice {
	/**
	 * Serial consecutive number that identifies an Invoice
	 */
	private String serialNumber;
	/**
	 * Date in which the invoice was registered
	 */
	private Date placedDate;
	/**
	 * Client to whom the invoice is related to
	 */
	private Client client;
	/**
	 * Number of days the client will have to make the payment
	 * 
	 */
	private int paymentDays;
	/**
	 * Invoice details per item
	 */
	private Collection<OrderDetail> orderDetails;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getPaymentDays() {
		return paymentDays;
	}

	public void setPaymentDays(int paymentDays) {
		this.paymentDays = paymentDays;
	}
	/**
	 * Get Order Details of the Invoice
	 * @return
	 */
	public Iterable<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * Adds an order detail belonging to one of the items in the invoice
	 * 
	 * @param detail
	 *            Order Detail of an Item in this Invoice
	 */
	public void addOrderDetail(OrderDetail detail) {
		detail.setInvoice(this);
		orderDetails.add(detail);
	}

	/**
	 * Calculates the IVA tax to pay
	 * 
	 * @return IVA Tax
	 */
	public float getIVATotal() {
		Iterator<OrderDetail> detailIterator = getOrderDetails().iterator();
		OrderDetail detail;
		float ivaTotal = 0;
		while (detailIterator.hasNext()) {
			detail = detailIterator.next();
			ivaTotal += detail.getIVATotal();
		}
		return ivaTotal;
	}

	/**
	 * Calculates the Subtotal without IVA tax
	 * 
	 * @return Subtotal
	 */
	public int getSubtotal() {
		Iterator<OrderDetail> detailIterator = getOrderDetails().iterator();
		OrderDetail detail;
		int subtotal = 0;
		while (detailIterator.hasNext()) {
			detail = detailIterator.next();
			subtotal += detail.getSubtotal();
		}
		return subtotal;
	}

	/**
	 * Calculate Total with IVA tax
	 * 
	 * @return Total
	 */
	public float getTotal() {
		return ((float) getSubtotal()) + getIVATotal();
	}

	/**
	 * Calculates days remaining until Invoice expiration
	 * 
	 * @return Number of days remaining or -1 if it's already expired
	 */
	public int getDaysUntilExpiration() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(placedDate);
		calendar.add(Calendar.DAY_OF_MONTH, paymentDays);
		Date expirationDate = calendar.getTime();
		Date currentDate = new Date();
		if (currentDate.before(expirationDate)) {
			long millisecondsPerDay = 1000L * 60 * 60 * 24;
			long millisecondsDifference = expirationDate.getTime() - currentDate.getTime();
			return (int) (millisecondsDifference / millisecondsPerDay);
		} else
			return -1;
	}
	
	@Override
	public String toString() {
		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
		return "No. " + serialNumber + " " + format.format(placedDate);
	}

}
