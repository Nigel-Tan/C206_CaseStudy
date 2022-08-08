import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//note, you can reference my work as our jobs are mostly similar -nigel

public class C206_CaseStudyTest {
	// setup of fields and arraylist
	private Account a1;
	private Account a2;
	private Category cc1;
	private Category cc2;
	private Category cc3;
	private Item il;
	private Item il2;
	private ArrayList<Account> accountList;
	private ArrayList<Item> itemList; 
	private Bid b1;
	private Bid b2;
	private ArrayList<Bid> bidList;

//	private Object catList;
	private ArrayList<Category> categoryList;

	@Before
	public void setUp() throws Exception {
		// details of the objects and arrayList
		a1 = new Account("jon", "buyer", "jon@gmail.com", "jon123");
		a2 = new Account("mary", "buyer", "mary@gmail.com", "mary123");
		accountList = new ArrayList<Account>();
		itemList = new ArrayList<Item>();
		il = new Item ("ruler", "long long", 0.66 , "1 August 2022", "8 August 2022", 1.00);
		il2 = new Item ("rubber", "pull and push", 1.00, "3 August 2022", "24 August 2022", 2.00);
		b1 = new Bid("2100", "ruler", "max210@gmail.com", "pete129@gmail.com", 30.00);
		b2 = new Bid("2101", "spoon", "liu3921@gmail.com", "tim213@gmail.com", 50.00);
		il = new Item("ruler", "long long", 0.66, "1 August 2022", "8 August 2022", 1.00);
		il2 = new Item("rubber", "pull and push", 1.00, "3 August 2022", "24 August 2022", 2.00);
		bidList = new ArrayList<Bid>();
		cc1 = new Category("shoes");
		cc2 = new Category("clothes");
		cc3 = new Category("electronics");
	}

	@After
	public void tearDown() throws Exception {
		// reset data to become null
		a1 = null;
		accountList = null;
		b1 = null;
		b2 = null;
		bidList = null;
	}

	@Test
	public void accountDelete() {
		// Account list is initially not null
		assertNotNull(accountList);

		// Account list has two account
		C206_CaseStudy.addAccount(accountList, "mary", "buyer", "mary@gmail.com", "mary123");
		C206_CaseStudy.addAccount(accountList, "jon", "buyer", "jon@gmail.com", "jon123");
		assertEquals(2, accountList.size());

		// Given a list with 2 account, after deleting 1 account, test if the size of
		// the list is 1 (delete mary account)
		C206_CaseStudy.removeAccount(accountList, "mary@gmail.com");
		assertEquals(1, accountList.size());
		// test if the expected output string same as the list of accounts retrieved
		// from the store
		String allAccount = C206_CaseStudy.retrieveAccounts(accountList);
		String testOutput = String.format("%-20s %-10s %-30s %-20s %-10s\n", "jon", "buyer", "jon@gmail.com", "jon123",
				"Active");
		assertEquals(testOutput, allAccount);

		// test if email not found, no user is deleted
		C206_CaseStudy.removeAccount(accountList, "wrongEmail@gmail.com");
		assertEquals(1, accountList.size());
	}

	@Test
	public void accountAdd() {
		// Test that account list is not null, so that a new account can be added to
		// (boundary)
		assertNotNull(accountList);

		// Test that given an empty list, after adding one account (normal),
		// • the size of the list is 1
		// • The account just added is as same as the first account of the list

		a1 = C206_CaseStudy.addAccount(accountList, "jon", "buyer", "jon@gmail.com", "jon123");
		assertEquals(1, accountList.size());
		assertSame(a1, accountList.get(0));

		// Test that Add another item. (normal)
		// • The size of the list is 2
		// • The account just added is as same as the 2nd account of the list

		a2 = C206_CaseStudy.addAccount(accountList, "mary", "buyer", "mary@gmail.com", "mary123");
		assertEquals(2, accountList.size());
		assertSame(a2, accountList.get(1));

		// Test that when an account details is invalid, account will not be added.
		// the name field is left blank
		C206_CaseStudy.addAccount(accountList, "", "buyer", "blankName@gmail.com", "mary123");
		assertEquals(2, accountList.size());
	}

	@Test
	public void accountView() {

		// Account list is initially not null
		assertNotNull(accountList);

		// Test that list is empty
		String allAccount = C206_CaseStudy.retrieveAccounts(accountList);
		String testOutput = "";
		assertEquals(testOutput, allAccount);

		// Given an empty list, after adding 2 accounts, test if the size of the list is
		// 2
		C206_CaseStudy.addAccount(accountList, "jon", "buyer", "jon@gmail.com", "jon123");
		C206_CaseStudy.addAccount(accountList, "mary", "buyer", "mary@gmail.com", "mary123");
		assertEquals(2, accountList.size());

		// test if the expected output string same as the list of accounts retrieved
		// from the store
		allAccount = C206_CaseStudy.retrieveAccounts(accountList);
		testOutput = String.format("%-20s %-10s %-30s %-20s %-10s\n", "jon", "buyer", "jon@gmail.com", "jon123",
				"Active");
		testOutput += String.format("%-20s %-10s %-30s %-20s %-10s\n", "mary", "buyer", "mary@gmail.com", "mary123",
				"Active");
		assertEquals(testOutput, allAccount);
	}

	@Test
	public void itemAdd() {
		// Account list is initially not null
		assertNotNull(itemList);

		// Test that list is empty
		C206_CaseStudy.additemList(itemList, il);
		assertEquals(1, itemList.size());
		assertSame(il, itemList.get(0));

		// test that add another item
		C206_CaseStudy.additemList(itemList, il2);
		assertEquals(2, itemList.size());
		assertSame(il2, itemList.get(1));

	}

	@Test
	public void itemView() {
		// Account list is initially not null
		assertNotNull(itemList);

		// Test that list is empty
		String allItems = "";
		String testOutput = "";
		assertEquals("Check that viewAll", testOutput, allItems);

		// test if the expected output string same as the list of accounts retrieved
		// from the store
		allItems = C206_CaseStudy.retrieveAccounts(accountList);
		testOutput = String.format("%-20s %-10s %-30s %-20s %-10s\n", "jon", "buyer", "jon@gmail.com", "jon123",
				"Active");
		testOutput += String.format("%-20s %-10s %-30s %-20s %-10s\n", "mary", "buyer", "mary@gmail.com", "mary123",
				"Active");
		assertEquals(testOutput, allItems);

	}

	@Test
	public void itemDelete() {
		assertNotNull(itemList);
		assertEquals(2, itemList.size());
	}

	@Test
	public void CategoryDelete() {
		// Account list is initially not null
		assertNotNull(categoryList);

		// Account list has two account
		C206_CaseStudy.categoryAdd(categoryList, "mary");
		C206_CaseStudy.categoryAdd(categoryList, "jon");
		assertEquals(2, categoryList.size());

		// Given a list with 2 account, after deleting 1 account, test if the size of
		// the list is 1 (delete mary account)
		C206_CaseStudy.removeCategory(categoryList, "mary@gmail.com");
		assertEquals(1, categoryList.size());
		// test if the expected output string same as the list of accounts retrieved
		// from the store
		String allAccount = C206_CaseStudy.retrieveCategory(categoryList);
		String testOutput = String.format("%-20s %-10s %-30s %-20s %-10s\n", "jon", "buyer", "jon@gmail.com", "jon123",
				"Active");
		assertEquals(testOutput, allAccount);

		// test if email not found, no user is deleted
		C206_CaseStudy.removeCategory(categoryList, "wrongEmail@gmail.com");
		assertEquals(1, categoryList.size());
	}

	@Test
	public void CategoryAdd() {
		// Test that account list is not null, so that a new account can be added to
		// (boundary)
		assertNotNull(categoryList);

		// Test that given an empty list, after adding one account (normal),
		// • the size of the list is 1
		// • The account just added is as same as the first account of the list

		cc1 = C206_CaseStudy.categoryAdd(categoryList, "jon");
		assertEquals(1, categoryList.size());
		assertSame(a1, categoryList.get(0));

		// Test that Add another item. (normal)
		// • The size of the list is 2
		// • The account just added is as same as the 2nd account of the list

		cc2 = C206_CaseStudy.categoryAdd(categoryList, "mary");
		assertEquals(2, categoryList.size());
		assertSame(a2, categoryList.get(1));

		// Test that when an account details is invalid, account will not be added.
		// the name field is left blank
		C206_CaseStudy.categoryAdd(categoryList, "");
		assertEquals(2, categoryList.size());
	}

	@Test
	public void CategoryView() {

		// Account list is initially not null
		assertNotNull(categoryList);

		// Test that list is empty
		String allAccount = C206_CaseStudy.retrieveCategory(categoryList);
		String testOutput = "";
		assertEquals(testOutput, allAccount);

		// Given an empty list, after adding 2 accounts, test if the size of the list is
		// 2
		C206_CaseStudy.categoryAdd(categoryList, "shoes");
		C206_CaseStudy.categoryAdd(categoryList, "mary");
		assertEquals(2, categoryList.size());

		// test if the expected output string same as the list of accounts retrieved
		// from the store
		allAccount = C206_CaseStudy.retrieveCategory(categoryList);
		testOutput = String.format("%-20s %-10s %-30s %-20s %-10s\n", "jon", "buyer", "jon@gmail.com", "jon123",
				"Active");
		testOutput += String.format("%-20s %-10s %-30s %-20s %-10s\n", "mary", "buyer", "mary@gmail.com", "mary123",
				"Active");
		assertEquals(testOutput, allAccount);
	}
	
	@Test
	public void bidAdd() {
		// Test that bid list is not null, so that a new bid can be added 
		// (boundary)
		assertNotNull(bidList);

		// Test that given an empty list, after adding one bid (normal),
		// • the size of the list is 1
		// • The bid just added is as same as the first bid of the list
		b2 = C206_CaseStudy.addBid(bidList, "2100", "ruler", "max210@gmail.com", "pete129@gmail.com", 30.00);
		assertEquals(1, bidList.size());
		assertSame(b2, bidList.get(0));

		// Test that Add another bid. (normal)
		// • The size of the list is 2
		// • The bid just added is as same as the 2nd bid of the list

		b2 = C206_CaseStudy.addBid(bidList, "2101", "spoon", "liu3921@gmail.com", "tim213@gmail.com", 50.00);

		assertEquals(2, accountList.size());
		assertSame(a2, accountList.get(1));
	}
		


	@Test
	public void bidDelete() {
		// Bid list is initially not null
		assertNotNull(bidList);

		// Bid list has two bids, after removing 1 bid, test if size of list become 1
		C206_CaseStudy.addBid(bidList, "2100", "ruler", "max210@gmail.com", "pete129@gmail.com", 30.00);	
		C206_CaseStudy.addBid(bidList, "2101", "spoon", "liu3921@gmail.com", "tim213@gmail.com", 50.00);
		assertEquals(2, bidList.size());
		bidList.remove(0);
		assertEquals(1,bidList.size());

	
		// continue from number 2 test, remove another item, then test if list is empty
		bidList.remove(0);
		assertEquals(0,bidList.size());

	}

	
	@Test
	public void Viewbids() {

		// Account list is initially not null
		assertNotNull(bidList);

		// Test that list is empty
		String allbid = C206_CaseStudy.retrieveBids(bidList);
		assertEquals(bidList, bidList.size());

		// Given an empty list, after adding 2 accounts, test if the size of the list is
		// 2
		C206_CaseStudy.addBid(bidList, "2100", "ruler", "max210@gmail.com", "pete129@gmail.com", 30.00);	
		C206_CaseStudy.addBid(bidList, "2101", "spoon", "liu3921@gmail.com", "tim213@gmail.com", 50.00);
		assertEquals(2, bidList.size());

	
	}
}