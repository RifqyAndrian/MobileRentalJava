package model;

public class Iphone extends Phone {
	
	public Iphone(Iphone iphone) {
		super(iphone);
	}
	
	public Iphone(int id, int batteryCap, String model, int frontCamera, int backCamera,
			int rentPrice) {
		super(id, batteryCap, model, frontCamera, backCamera, rentPrice);
	}

	@Override
	public Phone clone() {
		return new Iphone(this);
	}

}
