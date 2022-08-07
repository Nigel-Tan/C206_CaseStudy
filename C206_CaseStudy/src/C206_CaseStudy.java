import java.util.ArrayList;

public class C206_CaseStudy {
//if you see this message it means that you have pulled from nigel case study repo.
//note, you can reference my work as our jobs are mostly similar -nigel

	private ArrayList<Account> accountList = new ArrayList<Account>();
	Account a1 = new Account("jon", "buyer", "jon@gmail.com", "jon123");
	Account a2 = new Account("mary", "buyer", "mary@gmail.com", "mary123");

	private ArrayList<Item> itemList = new ArrayList<Item>();
	private ArrayList<Deals> dealsList = new ArrayList<Deals>();
	private ArrayList<Bid> bidList = new ArrayList<Bid>();
	private ArrayList<Category> categoryList = new ArrayList<Category>();

	private static final int OPTION_BID = 4;
	private static final int OPTION_ITEM = 3;
	private static final int OPTION_CATEGORY = 2;
	private static final int OPTION_ACCOUNT = 1;
	private static final int OPTION_DEAL = 5;
	private static final int OPTION_QUIT = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C206_CaseStudy start = new C206_CaseStudy();
		start.start();
	}

	public void start() {
		int option = 0;
		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_ACCOUNT) {
				accountOptions();
			} else if (option == OPTION_CATEGORY) {

				categoryOption();

			} else if (option == OPTION_ITEM) {
				itemOptions();

			} else if (option == OPTION_BID) {
				bidOptions();

			} else if (option == OPTION_DEAL) {
				dealsOptions();

			} else if (option == OPTION_QUIT) {

			}
		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop APP");
		System.out.println("1. Manage Accounts");
		System.out.println("2. Manage categories");
		System.out.println("3. Manage items");
		System.out.println("4. Manage bid");
		System.out.println("5. Manage deals");
		System.out.println("6. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// account methods
	public static Account addAccount(ArrayList<Account> accountList, String name, String role, String email,
			String password) { // add account (nigel)
		Account a = null;
		if (!(name.isBlank() || role.isBlank() || email.isBlank() || password.isBlank())) { // check that input is not
																							// empty
			a = new Account(name.strip(), role.strip(), email.strip(), password); // strip is used to remove extra
																					// useless white spaces
			accountList.add(a);
			System.out.println("Account added!");
		} else {
			System.out.println("Error with registration details, please ensure all fields are correctly filled!");
		}
		return a;

	}

	public static String retrieveAccounts(ArrayList<Account> accountList) { // retrieve list of account (nigel)
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {

			output += String.format("%-83s\n", accountList.get(i).display());
		}
		return output;
	}

	public static void viewAllAccounts(ArrayList<Account> accountList) { // final view output (nigel)
		C206_CaseStudy.setHeader("Account LIST");
		String output = String.format("%-20s %-10s %-30s %-20s %-10s\n", "Name", "Role", "Email", "Password", "Status");
		output += retrieveAccounts(accountList);
		System.out.println(output);
	}

	public static void removeAccount(ArrayList<Account> accountList, String email) { // remove account (nigel)
		boolean found = false;
		for (Account a : accountList) { // loop to find the email if it exist
			if (a.getEmail().equalsIgnoreCase(email.strip())) {
				accountList.remove(a);
				found = true;
				break;
			}
		}
		if (found) { // if item is found and deleted
			System.out.println("User deleted.");
		} else {
			System.out.println("No user can be found with that email!");
		}
	}

	private void accountOptions() {
		int option = 0;
		accountOptionMenu();
		while (option != 4) {
			option = Helper.readInt("Enter your option > ");
			if (option == 1) {
				viewAllAccounts(accountList);
			} else if (option == 2) {
				String name = Helper.readString("Enter name > ");
				String role = Helper.readString("Enter role > ");
				String email = Helper.readString("Enter email > ");
				String password = Helper.readString("Enter Password");
				addAccount(accountList, name, role, email, password);
			} else if (option == 3) {
				String email = Helper.readString("Enter email to delete account > ");
				removeAccount(accountList, email);
			} else if (option == 4) {
				System.out.println("Returning to main menu");
			} else {
				System.out.println("Invalid option,returning to main menu.");
			}
			break; // after every action in the manage account, they will return to main menu
		}
	}

	public void accountOptionMenu() {
		Helper.line(50, "-");
		System.out.println("Manage account options");
		Helper.line(50, "-");
		System.out.println("1.View accounts\n2.Add account\n3.Delete account\n4.Exit");
		Helper.line(50, "-");
	}

	// XAVIER SEAH 21029616
	private void itemOptionsMenu() {
		// TODO Auto-generated method stub
		Helper.line(50, "-");
		System.out.println("Manage Item options");
		Helper.line(50, "-");
		System.out.println("1.Add item\n2.View all items\n3. Delete item based on name\n4.Exit");
		Helper.line(50, "-");
	}

	private void itemOptions() {

		int option = 0;
		itemOptionsMenu();
		while (option != 4) {
			option = Helper.readInt("Enter your option > ");
			if (option == 1) {
				String name = Helper.readString("Enter Item name > ");
				String description = Helper.readString("Enter description > ");
				double bidprice = Helper.readDouble("Enter minimum bid prices > ");
				String auctionstart = Helper.readString("Enter auction start >");
				double bidincrement = Helper.readDouble("Enter bid increment > ");
				Item(itemList, name, description, bidprice, auctionstart, bidincrement);
			} else if (option == 2) {
				C206_CaseStudy.setHeader("Item LIST");
				String output = String.format("%-20s %-10s %-30s %-20s %-10s\n", "Name", "Description",
						"Minimum bid price", "Auction start", "End date");
				output += retrieveItems(itemList);
				System.out.println(output);

			} else if (option == 3) {
				String item = Helper.readString("Enter item to delete account > ");
				removeItem(itemList, item);
			} else if (option == 4) {
				System.out.println("Returning to main menu");
			} else {
				System.out.println("Invalid option,returning to main menu.");
			}
			break; // after every action in the manage account, they will return to main menu
		}
	}

	public static String retrieveItems(ArrayList<Item> itemList2) {

		String output = "";

		for (int i = 0; i < itemList2.size(); i++) {

			output += String.format("%-83s\n", itemList2.get(i).display());
			output += String.format("%-83s\n", itemList2.get(i).display());

		}
		return output;
	}

	public void removeItem(ArrayList<Item> itemList2, String item) {
		// TODO Auto-generated method stub
		boolean found = false;
		for (Item i : itemList2) {
			if (i.getName().equalsIgnoreCase(item.strip())) {
				itemList2.remove(i);
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Item is deleted.");
		} else {
			System.out.println("No item can be found with that name!");
		}
	}

	public Item Item(ArrayList<Item> itemList2, String name, String description, double bidprice, String auctionstart,
			double bidincrement) {
		Item i = null;
		// TODO Auto-generated method stub
		if (!(name.isBlank() || description.isBlank() || auctionstart.isBlank())) {
			i = new Item(name.strip(), description.strip(), bidincrement, auctionstart.strip(), auctionstart, 0);
			itemList.add(i);
			System.out.println("Item added!");
		} else {
			System.out.println("Error with registration details, please ensure all fields are correctly filled!");
		}
		return i;

	}

	// itemsAdd
	public static void additemList(ArrayList<Item> itemList, Item il) {
		itemList.add(il);

	}

	// NG KAI TING 21010191
	private void categoryOptionMenu() {
		// TODO Auto-generated method stub
		Helper.line(50, "-");
		System.out.println("View Category");
		Helper.line(50, "-");
		System.out.println("1.Add category\n2.View all categories\n3. Delete category based on name\n4.Exit");
		Helper.line(50, "-");
	}

	private void categoryOption() {
		int option = 0;
		categoryOptionMenu();

		while (option != 4) {
			option = Helper.readInt("Enter your option > ");

			if (option == 1) {
				String name = Helper.readString("Enter name > ");
				categoryAdd(categoryList, name);
			}

			else if (option == 2) {
				C206_CaseStudy.setHeader("Category LIST");
				String output = String.format("%-20s\n", "Name");
				output += retrieveCategory(categoryList);
				System.out.println(output);

			} else if (option == 3) {
				String Category = Helper.readString("Enter category to delete account > ");
				removeCategory(categoryList, Category);

			} else if (option == 4) {
				System.out.println("Returning to main menu");

			} else {
				System.out.println("Invalid option,returning to main menu.");
			}
			break; // after every action in the manage account, they will return to main menu
		}
	}

	static Category categoryAdd(ArrayList<Category> categoryList2, String name) {
		// TODO Auto-generated method stub
		Category i = null;
		// TODO Auto-generated method stub
		if (!(name.isBlank())) {
			i = new Category(name.strip());
			categoryList2.add(i);
			System.out.println("Category added!");
		} else {
			System.out.println("Error with registration details, please ensure all fields are correctly filled!");
		}
		return i;

	}

	public static void removeCategory(ArrayList<Category> categoryList2, String category) {
		boolean found = false;
		for (Category i : categoryList2) {
			if (i.getCategory().equalsIgnoreCase(category.strip())) {
				categoryList2.remove(i);
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Item is deleted.");
		} else {
			System.out.println("No item can be found with that name!");
		}
	}

	public static String retrieveCategory(ArrayList<Category> categoryList2) {
		// TODO Auto-generated method stub
		String output = "";

		for (int i = 0; i < categoryList2.size(); i++) {

			output += String.format("%-83s\n", categoryList2.get(i).display());
		}
		return output;

	}

	// Deals LIMPEH DO ONE
	private void dealsOptionsMenu() {
		// TODO Auto-generated method stub
		Helper.line(50, "-");
		System.out.println("Manage Deal options");
		Helper.line(50, "-");
		System.out.println("1.Add Deals\n2.View all deals\n3.Delete Deals based on Deal ID\n4.Exit");
		Helper.line(50, "-");
	}

	public static Deals addDeals(ArrayList<Deals> dealsList, String deal_id, String item_name, String seller_email,
			String buyer_email, Double transaction_price) { // add account (Hirthik)
		Deals d = null;
		if (!(deal_id.isBlank() || item_name.isBlank() || seller_email.isBlank() || buyer_email.isBlank())) {
			d = new Deals(deal_id.strip(), item_name.strip(), seller_email.strip(), buyer_email.strip(),
					transaction_price);
			dealsList.add(d);
			System.out.println("Deal added!");
		} else {
			System.out.println("Error with deal details, please ensure all fields are correctly filled!");
		}
		return d;
	}

	public static void adddealsList(ArrayList<Deals> dealsList, Deals dl) {
		dealsList.add(dl);

	}

	private void dealsOptions() {
		int option = 0;
		dealsOptionsMenu();
		while (option != 4) {
			option = Helper.readInt("Enter your option > ");
			if (option == 1) {
				String deal_id = Helper.readString("Enter Deal ID > ");
				String item_name = Helper.readString("Enter Item name > ");
				double transaction_price = Helper.readDouble("Enter Transaction price > ");
				String seller_email = Helper.readString("Enter Seller email >");
				String buyer_email = Helper.readString("Enter buyer email > ");
				addDeals(dealsList, deal_id, item_name, seller_email, buyer_email, transaction_price);
			} else if (option == 2) {
				C206_CaseStudy.setHeader("Deal LIST");
				String output = String.format("%-20s %-10s %-10s %-10s %-10s\n", "Deal ID", "Item name", "Seller email",
						"Buyer email", "Transaction Price");
				output += retrieveDeals(dealsList);
				System.out.println(output);

			} else if (option == 3) {
				String deal_id = Helper.readString("Enter Deal ID to delete deal > ");
				removeDeals(dealsList, deal_id);
			} else if (option == 4) {
				System.out.println("Returning to main menu");
			} else {
				System.out.println("Invalid option,returning to main menu.");
			}
			break; // after every action in the manage account, they will return to main menu
		}
	}

	private void removeDeals(ArrayList<Deals> dealsList, String deal_id) {
		// TODO Auto-generated method stub
		boolean found = false;
		for (Deals i : dealsList) {
			if (i.getDeal_id().equalsIgnoreCase(deal_id)) {
				dealsList.remove(i);
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Deal is deleted.");
		} else {
			System.out.println("No Deal can be found with that Deal ID!");
		}
	}

	private String retrieveDeals(ArrayList<Deals> dealsList) {
		String output = "";

		for (int i = 0; i < dealsList.size(); i++) {

			output += String.format("%-83s\n", dealsList.get(i).display());
		}
		return output;
	}

// BENJAMIN NG 21008768

private void bidOptionsMenu() {
	// TODO Auto-generated method stub
	Helper.line(50, "-");
	System.out.println("Manage Bid options");
	Helper.line(50, "-");
	System.out.println("1.Add bid\n2.View all bids\n3. Delete bid based on bid id\n4.Exit");
	Helper.line(50, "-");
}

private void bidOptions() {

	int option = 0;
	bidOptionsMenu();
	while (option != 4) {
		option = Helper.readInt("Enter your option > ");
		if (option == 1) {
			String bid_id = Helper.readString("Enter bid id > ");			
			String item_name = Helper.readString("Enter item name > ");	
			String seller_email = Helper.readString("Enter seller email > ");	
			String buyer_email = Helper.readString("Enter buyer email > ");	
			double bid_price = Helper.readDouble("Enter bid price > ");	
			addBid(bidList, bid_id, item_name, seller_email, buyer_email, bid_price);
		} else if (option == 2) {
			viewAllBids(bidList);

		} else if (option == 3) {
			String bid = Helper.readString("Enter bid id to delete bid > ");
			deleteBid(bidList, bid);
		} else if (option == 4) {
			System.out.println("Returning to main menu");
		} else {
			System.out.println("Invalid option,returning to main menu.");
		}
		break; // after every action in the manage account, they will return to main menu
	}
}
		public static Bid addBid(ArrayList<Bid> bidList, String bid_id, String item_name, String seller_email,
				String buyer_email, double bid_price) { // add account
			Bid f = new Bid (bid_id, item_name, seller_email, buyer_email, bid_price);
			if (!(bid_id.isBlank() || item_name.isBlank() || seller_email.isBlank() || buyer_email.isBlank())) { // check that input is not
																						// empty
				bidList.add(f);
				System.out.println("bid added!");
				
			} else {
				System.out.println("Error with bid details, please double check your fields!");
			}
			return f;

		}

		public static String retrieveBids(ArrayList<Bid> bidList) { // retrieve list of account (nigel)
			String output = "";

			for (int i = 0; i < bidList.size(); i++) {

				output += String.format("%-83s\n", bidList.get(i).display());
			}
			return output;
		}

		public static void viewAllBids(ArrayList<Bid> bidList) { // final view output 
			C206_CaseStudy.setHeader("Bid LIST");
			String output = String.format("%-20s %-10s %-30s %-20s %-10s","bid_id","item_name","seller_email","buyer_email","bid_price");
			output += retrieveBids(bidList);
			System.out.println(output);
		}

		public static void deleteBid(ArrayList<Bid> bidList, String bid_id) { // remove account
			boolean found = false;
			for (Bid f : bidList) { // loop to find the email if it exist
				if (f.getBid_id().equalsIgnoreCase(bid_id.strip())) {
					bidList.remove(f);
					found = true;
					break;
				}
			}
			if (found) { // if bid is found and deleted
				System.out.println("bid deleted.");
			} else {
				System.out.println("No bid can be found with that bid id!");
			}
		}
}

