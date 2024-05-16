package co.com.flamingo.queryTRX.types;

public class POSTransaction {
	private String transactionNmbr;
	private String store;
	private String terminal;
	private String date;
	private String time;
	private String totalAmnt;
	private String totalDisc;
	private String customer;
	private String operator;
	private ItemList itemList;
	private TenderList tenderList;
	
	public POSTransaction() {
		
	}

	public String getTransactionNmbr() {
		return transactionNmbr;
	}

	public void setTransactionNmbr(String transactionNmbr) {
		this.transactionNmbr = transactionNmbr;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTotalAmnt() {
		return totalAmnt;
	}

	public void setTotalAmnt(String totalAmnt) {
		this.totalAmnt = totalAmnt;
	}

	public String getTotalDisc() {
		return totalDisc;
	}

	public void setTotalDisc(String totalDisc) {
		this.totalDisc = totalDisc;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public ItemList getItemList() {
		return itemList;
	}

	public void setItemList(ItemList itemList) {
		this.itemList = itemList;
	}

	public TenderList getTenderList() {
		return tenderList;
	}

	public void setTenderList(TenderList tenderList) {
		this.tenderList = tenderList;
	}
}
