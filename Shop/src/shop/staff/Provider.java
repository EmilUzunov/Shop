package shop.staff;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import shop.abstractClasses.AbstractWithTurnover;
import shop.products.Clothes;
import shop.shop.Order;

public class Provider extends AbstractWithTurnover implements Comparable {
	
	private List<Clothes> orderedClothes;
	private double tip;

	public Provider(String name) {
		super(name);
		this.orderedClothes = new LinkedList<Clothes>();
	}

	public double getTip() {
		return tip;
	}

	public void setTip(double tip) {
		this.tip = tip;
	}


	@Override
	public int compareTo(Object o) {
		return (this.orderedClothes.size() - ((Provider)(o)).orderedClothes.size())*10;
	}
	
	public void executeOrder(Order o){
		this.orderedClothes.addAll(o.getOrderedClothes());
		this.setTurnover(o.getPrice());
		
	}
	
	
	
	@Override
	public String toString() {
		return "Number of ordered clothes = " + orderedClothes.size() + ", tip = " + tip + "";
	}

}
