package shop.shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import shop.abstractClasses.AbstractWithNameAndPhone;
import shop.clients.Client;
import shop.products.Clothes;
import shop.products.CompareClothesByPrice;
import shop.products.CompareSwimmingSute;
import shop.products.CompareTrousers;
import shop.products.Dress;
import shop.products.Jacket;
import shop.products.SwimmingSute;
import shop.products.Trousers;

public abstract class Shop extends AbstractWithNameAndPhone {
	Map<String, HashMap<Enum, LinkedList<Clothes>>> clothes;
	Map<String, HashMap<Enum, TreeSet<Clothes>>> catalog;
	private double money;
	private Map<String, Integer> soldClothesTypes;

	public Shop(String name) {
		super(name);
		catalog = new LinkedHashMap<String, HashMap<Enum, TreeSet<Clothes>>>();
		clothes = new HashMap<String, HashMap<Enum, LinkedList<Clothes>>>();
		soldClothesTypes = new HashMap<String, Integer>();
		soldClothesTypes.put("class shop.products.Dress", 0);
		soldClothesTypes.put("class shop.products.Jacket", 0);
		soldClothesTypes.put("class shop.products.Trousers", 0);
		soldClothesTypes.put("class shop.products.SwimmingSute", 0);

		this.money = 0;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public abstract void sell(Client c, Order o);

	public void addClothes(Clothes c) {
		if ((this.clothes.containsKey(c.getType().toString()))) {
			if ((this.clothes.get(c.getType().toString()).containsKey(c.getKind()))) {
				this.clothes.get(c.getType().toString()).get(c.getKind()).add(c);
			} else {

				this.clothes.get(c.getType().toString()).put(c.getKind(), new LinkedList<Clothes>());

			}
		} else {
			this.clothes.put(c.getType().toString(), new HashMap<Enum, LinkedList<Clothes>>());
			addClothes(c);
		}

	}

	public Map<String, HashMap<Enum, TreeSet<Clothes>>> ReCalcCatalog() {
		catalog.clear();
		catalog.put("class shop.products.Dress", new HashMap<Enum, TreeSet<Clothes>>());
		catalog.put("class shop.products.Jacket", new HashMap<Enum, TreeSet<Clothes>>());
		catalog.put("class shop.products.Trousers", new HashMap<Enum, TreeSet<Clothes>>());
		catalog.put("class shop.products.SwimmingSute", new HashMap<Enum, TreeSet<Clothes>>());
		for (String s : clothes.keySet()) {
			catalog.put(s, new HashMap<Enum, TreeSet<Clothes>>());
			for (Enum e : clothes.get(s).keySet()) {
				for (int i = 0; i < clothes.get(s).get(e).size(); i++) {
					Clothes c = clothes.get(s).get(e).get(i);
					if (c instanceof Dress || c instanceof Jacket) {
						this.catalog.get(c.getType()).put(c.getKind(),
								new TreeSet<Clothes>(new CompareClothesByPrice()));
					}
					if (c instanceof Trousers) {
						this.catalog.get(c.getType()).put(c.getKind(), new TreeSet<Clothes>(new CompareTrousers()));
					}
					if (c instanceof SwimmingSute) {
						this.catalog.get(c.getType()).put(c.getKind(), new TreeSet<Clothes>(new CompareSwimmingSute()));
					}
				}
				for (int i = 0; i < clothes.get(s).get(e).size(); i++) {
					catalog.get(s).get(e).add(clothes.get(s).get(e).get(i));
				}
			}
		}
		return catalog;
	}

	public void addTosoldClothesTypes(Order o) {
		for (Clothes c : o.orderedClothes) {
			String type = c.getType();
			int newValue = (this.soldClothesTypes.get(type).intValue() + 1);
			this.soldClothesTypes.put(c.getClass().toString(), newValue);
		}
	}

	public void printAllClothes() {
		for (Entry<String, HashMap<Enum, LinkedList<Clothes>>> e : this.clothes.entrySet()) {
			System.out.println(e.toString());
		}

	}

	public void printCatalog() {
		ReCalcCatalog();
		for (Entry<String, HashMap<Enum, TreeSet<Clothes>>> e : this.catalog.entrySet()) {
			System.out.println(e.toString());
		}
	}
	
	public void printTheMostSoldProduct(){
		TreeSet<Integer> temp = new TreeSet<Integer>();
		
		for(Entry<String,Integer> e:this.soldClothesTypes.entrySet()){
		temp.add(e.getValue());
		}
		for(Entry<String,Integer> e:this.soldClothesTypes.entrySet()){
			if(temp.last() == e.getValue()){
				System.out.println(e);
			}
		}
		
	}

}
