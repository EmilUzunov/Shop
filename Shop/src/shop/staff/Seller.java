package shop.staff;

import java.util.LinkedList;
import java.util.List;

import shop.abstractClasses.AbstractWithTurnover;
import shop.products.Clothes;

public class Seller extends AbstractWithTurnover implements Comparable {

	private static final double INITIAL_PERCENTAGE_OF_TURNOVER = 0.03;
	protected double sallary;
	List<Clothes> clothesSold;
	
	public Seller(String name) {
		super(name);
		clothesSold = new LinkedList<Clothes>();
		this.sallary = ((double)(Math.random()*200)+700);
	}


	public void updateSallary(double turnover){
		this.sallary += turnover*INITIAL_PERCENTAGE_OF_TURNOVER;
	}
	
	@Override
	public int compareTo(Object o) {

		return (int) (this.sallary - ((Seller)(o)).sallary);
	}

}
