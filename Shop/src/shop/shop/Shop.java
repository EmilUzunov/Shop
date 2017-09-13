package shop.shop;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import shop.abstractClasses.AbstractWithNameAndPhone;
import shop.products.Clothes;

public abstract class Shop extends AbstractWithNameAndPhone {
	Map<String, HashMap<String, LinkedList<Clothes>>> clothes;

	public Shop(String name) {
		super(name);
		clothes = new HashMap<String, HashMap<String, LinkedList<Clothes>>>();
	}
	
	

}
