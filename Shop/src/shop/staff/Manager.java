package shop.staff;

public class Manager extends Seller {

	
	
	private static final double MANAGER_PERCENTAGE_OF_TURNOVER = 0.05;

	public Manager(String name) {
		super(name);
	}

	@Override
	public void updateSallary() {
		this.sallary += this.getTurnover()*MANAGER_PERCENTAGE_OF_TURNOVER;
	}

}
