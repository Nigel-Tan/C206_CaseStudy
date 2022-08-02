
public class Deals {
	private String deal_id;
	private String item_name;
	private String seller_email;
	private String buyer_email;
	private Double transaction_price;
	private String close_date;
	private String status;

	public Deals(String deal_id, String item_name, String seller_email, String buyer_email, Double transaction_price, String close_date) {
		this.deal_id = deal_id;
		this.item_name = item_name;
		this.seller_email = seller_email;
		this.buyer_email = buyer_email;
		this.transaction_price = transaction_price;
		this.close_date = close_date;
		status = "Active";
	}

	public String getDeal_id() {
		return deal_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public String getBuyer_email() {
		return buyer_email;
	}

	public String getStatus() {
		return status;
	}

	public Double getTransaction_price() {
		return transaction_price;
	}
	
	public String getClose_date() {
		return close_date;
	}

	public String display() {
		String output = String.format("%-20s %-10s %-30s %-20s %-10s", deal_id, item_name, seller_email, buyer_email,
				transaction_price, close_date, status);
		return output;
	}
}
