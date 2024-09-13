package utility;

import model.Customer;

public class MenuHelper {
	
	public Customer user = null;

	public MenuHelper() {
		
	}
	
	public void clearScreen() {
		for (int x=0;x<30;x++) {
			System.out.println("");
		}
	}
	
	public boolean loggedIn() {
		return user != null;
	}

}
