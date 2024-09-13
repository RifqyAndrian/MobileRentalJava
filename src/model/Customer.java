package model;

public class Customer {
	
	protected int Id;
	
	protected String name;
	
	protected String phone;
	
	protected String idNumber;
	
	protected String address;
	
	protected String password;

	public Customer() {
		
	}

	public Customer(int id, String name, String phone, String idNumber, String address, String password) {
		super();
		Id = id;
		this.name = name;
		this.phone = phone;
		this.idNumber = idNumber;
		this.address = address;
		this.password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
