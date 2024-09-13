package main;

import java.util.Scanner;

import model.LoggedInState;
import model.LoggedOutState;
import model.MenuState;
import utility.MenuHelper;

public class Main {
	
	Scanner scanner = new Scanner(System.in);
	
	private MenuHelper menuHelper = new MenuHelper();
	private MenuState loggedOutState = new LoggedOutState(menuHelper);
	private MenuState loggedInState = new LoggedInState(menuHelper);
	private MenuState state = loggedOutState;

	public Main() {
		int choice = 0;
		do {
			state = menuHelper.loggedIn() ? loggedInState : loggedOutState;
			menuHelper.clearScreen();
			state.printMenu();
			choice = scanner.nextInt();
			state.chooseMenu(choice);
		} while (choice != state.exitMenu());
		menuHelper.clearScreen();
		System.out.println("Thank You!");
	}

	public static void main(String[] args) {
		new Main();
	}

}
