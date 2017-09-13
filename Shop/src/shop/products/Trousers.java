package shop.products;

public class Trousers extends Clothes {

	public Trousers(TrousersEnum kind) {
		super();
		this.setType();
		this.setKind(kind);
		setDescription(this.getType() + " : " + this.getKind());

	}

	@Override
	public String toString() {
		return "Price : " + getPrice() + ", Type : " + getType() + ", Kind : " + getKind() + " " + super.toString();
	}

}
