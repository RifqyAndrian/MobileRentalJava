package utility;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Iphone;
import model.Phone;
import model.Samsung;
import model.Transaction;

public final class Database {

	private static Database instance;
	
	public List<Phone> phones = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(new Iphone(1, 2000, "Iphone 7", 8, 12, 50000));
			add(new Samsung(2, 4000, "Samsung A51", 16, 24, 40000));
			add(new Iphone(3, 2400, "Iphone 8", 8, 12, 60000));
			add(new Samsung(4, 4600, "Samsung Galaxy", 24, 36, 65000));
		}
	};
	
	public List<Customer> customers = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(new Customer(1, "Test", "08xxxxxxxxx", "33750xxxxxxxxxx", "Jl Xxxxx No xx", "Test"));
		}
	};
	
	public List<Transaction> transactions = new ArrayList<>();
	
    public String value;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    
    public Customer login(String username, String password) {
    	for (int i = 0;i < customers.size(); i++) {
    		if (customers.get(i).getName().equals(username) && customers.get(i).getPassword().equals(password)) {
    			return customers.get(i);
    		}
    	}
    	
    	return null;
    }

}
