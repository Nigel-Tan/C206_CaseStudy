
public class Bid {
	private String bid_id;
	private String item_name;
	private String seller_email;
	private String buyer_email;
	private double bid_price;
	public Bid(String bid_id, String item_name, String seller_email, String buyer_email, double bid_price) {
		this.bid_id = bid_id;
		this.item_name = item_name;
		this.seller_email = seller_email;
		this.buyer_email = buyer_email;
		this.bid_price = bid_price;
	}
	public String getBid_id() {
		return bid_id;
	}
	public void setBid_id(String bid_id) {
		this.bid_id = bid_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public String getBuyer_email() {
		return buyer_email;
	}
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}
	public double getBid_price() {
		return bid_price;
	}
	public void setBid_price(double bid_price) {
		this.bid_price = bid_price;
	}
	public String display() {
		String output = String.format("%-20s %-10s %-30s %-20s %-10.2f",bid_id,item_name,seller_email,buyer_email,bid_price);
		return output;


	}
}
