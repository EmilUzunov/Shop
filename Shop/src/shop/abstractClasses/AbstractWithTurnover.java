package shop.abstractClasses;

public abstract class AbstractWithTurnover extends AbstractWithNameAndPhone{
	private double turnover;

	public AbstractWithTurnover(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}
	
	

}
