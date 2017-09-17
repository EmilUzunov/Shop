package shop.products;

public class SwimmingSute extends Clothes {
	
	private int parts;

	public SwimmingSute(SwimmingSuteEnum kind) {
		super();
		this.setType();
		this.setKind(kind);
		setDescription(this.getType() + " : " + this.getKind());
		this.parts = (int)(Math.random()*3)+1;
	}

	@Override
	public String toString() {
		return "Price : " + getPrice() + ", Type : " + getType() + ", Kind : " + getKind() + " Number of parts: " +this.parts;
	}

	public int getParts() {
		return parts;
	}
}
