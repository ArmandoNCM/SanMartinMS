package entity;

/**
 * This class represents the details per item in an Invoice
 * 
 * @author ArmandoNCM
 *
 */
public class OrderDetail {
	/**
	 * Invoice to whom this order details respond to
	 */
	private Invoice invoice;
	/**
	 * Item in question
	 */
	private Item item;
	/**
	 * Number of units
	 */
	private int quantity;
	/**
	 * Price per unit of the product at the time the order was placed
	 */
	private int unitPrice;
	/**
	 * IVA tax percent at the time the order was placed
	 */
	private int ivaPercent;

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getIvaPercent() {
		return ivaPercent;
	}

	public void setIvaPercent(int ivaPercent) {
		this.ivaPercent = ivaPercent;
	}
	/**
	 * Calculates the IVA tax to pay
	 * @return IVA Tax
	 */
	public float getIVATotal(){
		return ((float)quantity * ivaPercent) / 100F;
	}
	/**
	 * Calculates the Subtotal without IVA tax
	 * @return Subtotal
	 */
	public int getSubtotal(){
		return quantity * unitPrice;
	}
	/**
	 * Calculate Total with IVA tax
	 * @return Total
	 */
	public float getTotal(){
		return ((float) getSubtotal()) + getIVATotal();
	}

}
