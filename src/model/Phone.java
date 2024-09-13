package model;

public abstract class Phone {
	
	protected int Id;
	
	protected int batteryCap;
	
	protected String model;
	
	protected int frontCamera;
	
	protected int backCamera;
	
	protected int rentPrice;
	
	public Phone(Phone source) {
	    this.Id = source.Id;
	    this.batteryCap = source.batteryCap;
	    this.model = source.model;
	    this.frontCamera = source.frontCamera;
	    this.backCamera = source.backCamera;
	    this.rentPrice = source.rentPrice;
	}
	
	public Phone(int id, int batteryCap, String model, int frontCamera, int backCamera,
			int rentPrice) {
		this.Id = id;
		this.batteryCap = batteryCap;
		this.model = model;
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;
		this.rentPrice = rentPrice;
	}
	
	public abstract Phone clone();
	
	public static String header() {
		return String.format("|%-2s|%-7s|%-15s|%-3s|%-3s|%-10s|", "Id", "Battery", "Model", "FMP", "BMP", "Price");
	}
	
	@Override
	public String toString() {
		return String.format("|%-2s|%-7s|%-15s|%-3s|%-3s|%-10s|", this.Id, this.batteryCap, this.model, this.frontCamera, this.backCamera, this.rentPrice);
	}
}
