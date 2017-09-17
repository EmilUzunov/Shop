package shop.products;

public class Dress extends Clothes {
	
	private boolean hasAZipper = false;

	public Dress(DressEnum kind) {
		super();
		this.setType();
		this.setKind(kind);
		setDescription(this.getType()+" : "+ this.getKind());
		if(Math.random()<0.5f){
			this.hasAZipper = true;
		}
		
	}

	@Override
	public String toString() {
		return "Price : " + getPrice() + ", Type : " + getType() + ", Kind : " + getKind()
				+ " hasAZipper : "+hasAZipper;
	}

	
	
	

}
