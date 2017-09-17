package shop.products;

public class Trousers extends Clothes {
	
	private int hight;
	private int width;

	public Trousers(TrousersEnum kind) {
		super();
		this.setType();
		this.setKind(kind);
		setDescription(this.getType() + " : " + this.getKind());
		this.hight = (int)(Math.random()*30)+100;
		this.width = (int)(Math.random()*30)+40;

	}

	@Override
	public String toString() {
		return "Price : " + getPrice() + ", Type : " + getType() + ", Kind : " + getKind() + " Hight :" + this.hight +" Width :"+ this.width;
	}

	public int getHight() {
		return hight;
	}

	public int getWidth() {
		return width;
	}

}
