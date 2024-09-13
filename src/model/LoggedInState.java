package model;

import java.util.List;
import utility.MenuHelper;

public class LoggedInState extends MenuState {
	
	protected TransactionSource source = new TextFileTransactionSource();

	public LoggedInState(MenuHelper menuHelper) {
		super(menuHelper);
	}

	@Override
	public void printMenu() {
		System.out.println("1. List Phones");
		System.out.println("2. Transaction History");
		System.out.println("3. Rent a Phone");
		System.out.println("4. Export Transactions to Txt");
		System.out.println("5. Export Transactions to Csv");
		System.out.println("6. Logout");
		System.out.println("7. Exit");
	}
	
	@Override
	public int exitMenu() {
		return 7;
	}

	@Override
	public void chooseMenu(int choice) {
		switch (choice) {
			case 1:
				menuHelper.clearScreen();
				listPhones();
				scanner.nextLine();
				break;
			case 2:
				menuHelper.clearScreen();
				listTransactions();
				break;
			case 3:
				menuHelper.clearScreen();
				rentPhone();
				break;
			case 4:
				menuHelper.clearScreen();
				exportToTxt();
				break;
			case 5:
				menuHelper.clearScreen();
				exportToCsv();
				break;
			case 6:
				menuHelper.clearScreen();
				logout();
				break;
		}
	}
	
	public void listPhones() {
		System.out.println("-----------------------------------------------");
		System.out.println(Phone.header());
		System.out.println("-----------------------------------------------");
		for (int i = 0;i < database.phones.size(); i++) {
			Phone phone = database.phones.get(i);
			System.out.println(phone.toString());
			System.out.println("-----------------------------------------------");
		}
	}
	
	public void listTransactions() {
		List<Transaction> transactionList = database.transactions.stream()
				.filter(transaction -> transaction.customer.Id == menuHelper.user.Id)
				.toList();
		
		System.out.println("---------------------------------------");
		System.out.println(Transaction.header());
		System.out.println("---------------------------------------");
		for (int i = 0;i < transactionList.size(); i++) {
			Transaction transaction = transactionList.get(i);
			System.out.println(transaction.toString());
			System.out.println("---------------------------------------");
		}
		scanner.nextLine();
	}
	
	public void rentPhone() {
		listPhones();
		int choice, duration = 0;
		do {
			System.out.print("Pick Phone : ");
			choice = scanner.nextInt();
		} while (choice <= 0 || choice > database.phones.size());
		System.out.print("How Long do you Want to Rent : ");
		duration = scanner.nextInt();
		
		Phone phone = database.phones.get(choice - 1);
		
		database.transactions.add(new Transaction(database.transactions.size() + 1, menuHelper.user, phone, duration));
		
		System.out.println("Success");
		scanner.nextLine();
	}
	
	public void logout() {
		menuHelper.user = null;
		
		System.out.println("Logged Out!");
		scanner.nextLine();
	}
	
	public void exportToTxt() {
		source.writeData(database.transactions);
		
		System.out.println("Exported Transactions to Txt");
		scanner.nextLine();
	}
	
	public void exportToCsv() {
		source = new CSVDecorator(source);
		source.writeData(database.transactions);
		
		System.out.println("Exported Transactions to Csv");
		scanner.nextLine();
	}

}
