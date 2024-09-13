package model;

public class Samsung extends Phone {
	
	public Samsung(Samsung samsung) {
		super(samsung);
	}
	
	public Samsung(int id, int batteryCap, String model, int frontCamera, int backCamera,
			int rentPrice) {
		super(id, batteryCap, model, frontCamera, backCamera, rentPrice);
	}

	@Override
	public Phone clone() {
		return new Samsung(this);
	}

}
