package model;

import java.util.Scanner;

import utility.Database;
import utility.MenuHelper;

public abstract class MenuState {
	
	protected MenuHelper menuHelper;
	Database database = Database.getInstance();
	Scanner scanner = new Scanner(System.in);

	public MenuState(MenuHelper menuHelper) {
		this.menuHelper = menuHelper;
	}
	
	public abstract void printMenu();
	
	public abstract int exitMenu();
	
	public abstract void chooseMenu(int choice);

}
