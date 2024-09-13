package model;

import utility.MenuHelper;

public class LoggedOutState extends MenuState {

	public LoggedOutState(MenuHelper menuHelper) {
		super(menuHelper);
	}

	@Override
	public void printMenu() {
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
	}

	@Override
	public int exitMenu() {
		return 3;
	}

	@Override
	public void chooseMenu(int choice) {
		switch (choice) {
			case 1 :
				menuHelper.clearScreen();
				login();
				break;
			case 2:
				menuHelper.clearScreen();
				register();
				break;
		}
	}
	
	public void login() {
		String username, password = "";
		menuHelper.clearScreen();
		System.out.print("Name : ");
		username = scanner.nextLine();
		System.out.print("Password : ");
		password = scanner.nextLine();
		
		menuHelper.user = database.login(username, password);
		
		if (!menuHelper.loggedIn()) {
			System.out.println("User Not Found...");
			scanner.nextLine();
		}
	}
	
	public void register() {
		String name, phone, idNumber, address, password = "";
		do {
			System.out.print("Name : ");
			name = scanner.nextLine();
		} while (name.equals(""));
		do {
			System.out.print("Phone : ");
			phone = scanner.nextLine();
		} while (phone.equals(""));
		do {
			System.out.print("ID Number : ");
			idNumber = scanner.nextLine();
		} while (idNumber.equals(""));
		do {
			System.out.print("Address : ");
			address = scanner.nextLine();
		} while (address.equals(""));
		do {
			System.out.print("Password : ");
			password = scanner.nextLine();
		} while (password.equals(""));
		
		database.customers.add(new Customer(database.customers.size() + 1, name, phone, idNumber, address, password));
		
		System.out.println("Registered!");
		scanner.nextLine();
	}
	

}
