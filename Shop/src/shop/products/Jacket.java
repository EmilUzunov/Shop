package shop.products;

public class Jacket extends Clothes {

	private boolean hasAHood = false;

	public Jacket(JacketEnum kind) {
		super();
		this.setType();
		this.setKind(kind);
		setDescription(this.getType() + " : " + this.getKind());
		if (Math.random() < 0.5f) {
			this.hasAHood = true;
		}

	}

	@Override
	public String toString() {
		return "Price : " + getPrice() + ", Type : " + getType() + ", Kind : " + getKind() + " Has a hood :"+this.hasAHood ;
	}

}
