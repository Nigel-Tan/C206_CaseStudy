import java.util.ArrayList;

public class C206_CaseStudy {
//if you see this message it means that you have pulled from nigel case study repo.
	
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
		menu();
		int option = 0;
		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_ACCOUNT) {
				// View all items


			} else if (option == OPTION_CATEGORY) {
				// Add a new item

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
	public static void addAccount(ArrayList<Account> accountList,Account a) { //add account
		accountList.add(a);
	}
	
	public static String retrieveAccounts(ArrayList<Account> accountList) { //retrieve list of account
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {

			output += String.format("%-83s\n",accountList.get(i).display());
		}
		return output;
	}
	
	public static void viewAllAccounts(ArrayList<Account> accountList) {
		C206_CaseStudy.setHeader("Account LIST");
		String output = String.format("%-20s %-10s %-30s %-20s %-10s", "Name", "Role",
				"Email", "Password","Status");
		 output += retrieveAccounts(accountList);	
		System.out.println(output);
	}
	
	

}
