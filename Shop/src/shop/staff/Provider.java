package shop.staff;

import java.util.LinkedList;
import java.util.List;

import shop.abstractClasses.AbstractWithTurnover;
import shop.products.Clothes;

public class Provider extends AbstractWithTurnover implements Comparable {
	
	List<Clothes> orderedClothes;

	public Provider(String name) {
		super(name);
		this.orderedClothes = new LinkedList<Clothes>();
	}

	@Override
	public int compareTo(Object o) {
		return this.orderedClothes.size() - ((Provider)(o)).orderedClothes.size();
	}

}
