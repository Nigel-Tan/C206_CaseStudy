
public class Item {
	private String name;
	private String description;
	private double minimumbidprice;
	private String auctionstart;
	private String enddate;
	private double bidIncrement;

	public Item(String name, String description, double minimumbidprice, String auctionstart, String enddate,
			double bidIncrement) {
		this.name = name;
		this.description = description;
		this.minimumbidprice = minimumbidprice;
		this.auctionstart = auctionstart;
		this.enddate = enddate;
		this.bidIncrement = bidIncrement;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getMinimumbidprice() {
		return minimumbidprice;
	}

	public String getAuctionstart() {
		return auctionstart;
	}

	public String getEnddate() {
		return enddate;
	}

	public double getBidIncrement() {
		return bidIncrement;
	}

	public String display() {
		String output = String.format("%-20s %-10s %-30s %-20s %-10s", name, description, minimumbidprice, auctionstart,
				enddate);
		return output;
	}

}
