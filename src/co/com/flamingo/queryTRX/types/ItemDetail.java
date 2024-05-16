package co.com.flamingo.queryTRX.types;

public class ItemDetail {
	private String itemCode;
	private String signo;
	private int itemPrice;
	private int itemQty;
	private int itemDiscount;
	private String remision;
	private String indicat1;
	
	public ItemDetail() {
		
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}

	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	public int getItemDiscount() {
		return itemDiscount;
	}
	public void setItemDiscount(int itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

	public String getRemision() {
		return remision;
	}

	public void setRemision(String remision) {
		this.remision = remision;
	}

	public String getIndicat1() {
		return indicat1;
	}

	public void setIndicat1(String indicat1) {
		this.indicat1 = indicat1;
	}
}
