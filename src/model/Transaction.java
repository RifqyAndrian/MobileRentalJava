package model;

public class Transaction {
	
	protected int Id;
	
	protected Customer customer;
	
	protected Phone phone;
	
	protected int rentDuration;

	public Transaction() {
		
	}

	public Transaction(int id, Customer customer, Phone phone, int rentDuration) {
		super();
		Id = id;
		this.customer = customer;
		this.phone = phone;
		this.rentDuration = rentDuration;
	}
	
	public static String header() {
		return String.format("|%-15s|%-8s|%-12s|", "Phone Model", "Duration", "Price");
	}
	
	@Override
	public String toString() {
		return String.format("|%-15s|%-8s|%-12s|", this.phone.model, this.rentDuration, (this.phone.rentPrice * this.rentDuration));
	}
	
	public static String exportHeader(String separator) {
		return "ID"
				+ separator
				+ "Customer Name"
				+ separator
				+ "Phone Model"
				+ separator
				+ "Rent Duration"
				+ separator
				+ "Total Price";
	}
	
	public String exportFormat(String separator) {
		
		String str = this.Id 
				+ separator 
				+ this.customer.name 
				+ separator 
				+ this.phone.model 
				+ separator 
				+ this.rentDuration 
				+ separator
				+ (this.rentDuration * this.phone.rentPrice);
		
		return str;
	}


}
