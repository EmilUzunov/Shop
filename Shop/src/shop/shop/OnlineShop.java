package shop.shop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import shop.products.Clothes;
import shop.staff.Provider;

public class OnlineShop extends Shop {
	
	Set<Provider> providers; 

	public OnlineShop(String name, Map<String, HashMap<String, LinkedList<Clothes>>> clothes) {
		super(name);
		this.providers = new TreeSet<Provider>();
		this.clothes = clothes;
	}

}
