package shop.staff;

public class Manager extends Seller {

	
	
	private static final double MANAGER_PERCENTAGE_OF_TURNOVER = 0.05;

	public Manager(String name) {
		super(name);
	}

	@Override
	public void updateSallary(double turnover) {
		this.sallary += turnover*MANAGER_PERCENTAGE_OF_TURNOVER;
	}

}
