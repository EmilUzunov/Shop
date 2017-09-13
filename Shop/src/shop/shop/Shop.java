package shop.shop;
import java.util.AbstractSequentialList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import shop.abstractClasses.AbstractWithNameAndPhone;
import shop.clients.Client;
import shop.products.Clothes;

public abstract class Shop extends AbstractWithNameAndPhone {
	Map<String, HashMap<Enum, LinkedList<Clothes>>> clothes;

	public Shop(String name) {
		super(name);
		clothes = new HashMap<String, HashMap<Enum, LinkedList<Clothes>>>();
	}
	
	public abstract void sell(Client c, Order o);
	
	public void addClothes(Clothes c){
		if((this.clothes.containsKey(c.getType()))){
			if((this.clothes.get(c.getType()).containsKey(c.getKind()))){
				this.clothes.get(c.getType()).get(c.getKind()).add(c);
			}else{
				this.clothes.get(c.getType()).put(c.getKind(),new LinkedList<Clothes>());
			}
		}else{
			this.clothes.put(c.getType(), new HashMap<Enum,  LinkedList<Clothes>>());
			addClothes(c);
		}
		
	}
	
	public void printAllClothes(){
		for(Entry<String, HashMap<Enum, LinkedList<Clothes>>> e : this.clothes.entrySet()){
			System.out.println(e.toString());
		}
	}
	

}
