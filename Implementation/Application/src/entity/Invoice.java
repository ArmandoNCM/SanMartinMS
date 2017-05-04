package entity;

import java.util.Collection;
import java.util.Date;

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
	 * Discount percentage applied for the sale
	 * 
	 * TODO Check if this actually applies
	 */
	private int discountPercentage;
	/**
	 * Number of days the client will have to make the payment
	 * 
	 * TODO Check if this is a relevant data piece
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

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public int getPaymentDays() {
		return paymentDays;
	}

	public void setPaymentDays(int paymentDays) {
		this.paymentDays = paymentDays;
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

	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
}
