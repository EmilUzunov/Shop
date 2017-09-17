package shop.staff;

import java.util.LinkedList;
import java.util.List;

import shop.abstractClasses.AbstractWithTurnover;
import shop.products.Clothes;
import shop.shop.Order;

public class Seller extends AbstractWithTurnover implements Comparable {

	private static final int SALLARI_MINIMUM = 700;
	private static final int SALARY_RANGE = 200;
	private static final double PERCENTAGE_OF_GETTING_MANAGER = 0.2;
	private static final double INITIAL_PERCENTAGE_OF_TURNOVER = 0.03;
	protected double sallary;
	List<Clothes> clothesSold;

	public Seller(String name) {
		super(name);
		clothesSold = new LinkedList<Clothes>();
		this.sallary = ((double) (Math.random() * SALARY_RANGE) + SALLARI_MINIMUM);
	}

	@Override
	public String toString() {
		return "Seller [sallary=" + sallary + ", getName()=" + getName() + "]";
	}

	public void updateSallary() {

		this.sallary += this.getTurnover() * INITIAL_PERCENTAGE_OF_TURNOVER;

	}
	
	



	@Override
	public int compareTo(Object o) {
		if (o instanceof Seller) {
			return (int) ((this.sallary - ((Seller) (o)).sallary)*10);
		}
		else{
			return 0;
		}
	}

	static Seller generateSeller(String name) {
		double chanceOfManager = Math.random();
		if (chanceOfManager < PERCENTAGE_OF_GETTING_MANAGER) {
			return new Manager(name);
		}
		return new Seller(name);
	}
	
	public void executeOrder(Order o){
		this.clothesSold.addAll(o.getOrderedClothes());
		this.setTurnover(o.getPrice());
	}

}
