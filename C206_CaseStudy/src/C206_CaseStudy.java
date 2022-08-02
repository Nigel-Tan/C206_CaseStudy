import java.util.ArrayList;

public class C206_CaseStudy {
//if you see this message it means that you have pulled from nigel case study repo.
//note, you can reference my work as our jobs are mostly similar -nigel
	
	private ArrayList<Account> accountList = new ArrayList<Account>();
	Account a1 = new Account("jon","buyer","jon@gmail.com","jon123");
	Account a2 = new Account("mary","buyer","mary@gmail.com","mary123");
	
	
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

			}
			else if (option == OPTION_ITEM) {
				
			}
			else if (option ==OPTION_BID) {
				
			}
			else if (option ==OPTION_DEAL) {
				
			}
			else if (option ==OPTION_QUIT) {
				
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
	
	//account methods
	public static Account addAccount(ArrayList<Account> accountList,String name, String role, String email, String password) { //add account (nigel)
		Account a = null;
		if (!(name.isBlank()||role.isBlank()||email.isBlank()||password.isBlank())) { //check that input is not empty
			a = new Account(name.strip(),role.strip(),email.strip(),password); // strip is used to remove extra useless white spaces
			accountList.add(a);
			System.out.println("Account added!");
		}
		else {
			System.out.println("Error with registration details, please ensure all fields are correctly filled!");
		}
		return a;
		
	}
	
	public static String retrieveAccounts(ArrayList<Account> accountList) { //retrieve list of account (nigel)
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {

			output += String.format("%-83s\n",accountList.get(i).display());
		}
		return output;
	}
	
	public static void viewAllAccounts(ArrayList<Account> accountList) { //final view output (nigel)
		C206_CaseStudy.setHeader("Account LIST");
		String output = String.format("%-20s %-10s %-30s %-20s %-10s\n", "Name", "Role",
				"Email", "Password","Status");
		 output += retrieveAccounts(accountList);	
		System.out.println(output);
	}
	public static void removeAccount(ArrayList<Account> accountList,String email) { // remove account (nigel)
		boolean found = false;
		for (Account a: accountList) { //loop to find the email if it exist
			if (a.getEmail().equalsIgnoreCase(email.strip())) {
				accountList.remove(a);
				found = true;
				break;
			}
		}
		if (found) { //if item is found and deleted
			System.out.println("User deleted.");
		}
		else {
			System.out.println("No user can be found with that email!");
		}
	}
	private void accountOptions() {
		int option = 0;
		accountOptionMenu();
		while (option!=4) {
			option = Helper.readInt("Enter your option > ");
			if (option == 1) {
				viewAllAccounts(accountList);
			}
			else if (option ==2) {
				String name = Helper.readString("Enter name > ");
				String role = Helper.readString("Enter role > ");
				String email = Helper.readString("Enter email > ");
				String password = Helper.readString("Enter Password");
				addAccount(accountList,name,role,email,password);
			}
			else if (option ==3) {
				String email = Helper.readString("Enter email to delete account > ");
				removeAccount(accountList,email);
			}
			else if (option ==4) {
				System.out.println("Returning to main menu");
			}
			else {
				System.out.println("Invalid option,returning to main menu.");
			}
			break; //after every action in the manage account, they will return to main menu
		}
	}
	private void accountOptionMenu() {
		Helper.line(50, "-");
		System.out.println("Manage account options");
		Helper.line(50, "-");
		System.out.println("1.View accounts\n2z.Add account\n3.Delete account\n4.Exit");
		Helper.line(50, "-");
	}
	// itemsAdd
	public static void additemList(ArrayList<Item> itemList, Item il) {
		itemList.add(il);
	}

//	// itemView
//	public static String itemView(ArrayList<Item> itemlist) {
//		String output = "";
//		
//		for(int i = 0; i < itemlist.size(); i++) {
//			
//		}
	}

}
