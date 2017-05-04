package entity;

/**
 * This class represents an item
 * 
 * @author ArmandoNCM
 *
 */
public class Item {

	/**
	 * Item code in the Database
	 */
	private String code;
	/**
	 * Description of the Item
	 */
	private String description;
	/**
	 * Bar code of the item if it has any
	 */
	private String barCode;
	/**
	 * Unit price of the Item
	 */
	private int unitPrice;
	/**
	 * IVA tax percent paid for this item's unit
	 */
	private int ivaPercent;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public int getPrice() {
		return unitPrice;
	}

	public void setPrice(int price) {
		this.unitPrice = price;
	}

	public int getIvaPercent() {
		return ivaPercent;
	}

	public void setIvaPercent(int ivaPercent) {
		this.ivaPercent = ivaPercent;
	}

}
