package shop.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import shop.clients.Client;
import shop.clients.IBuyFromOnlineShop;
import shop.products.Clothes;
import shop.staff.Provider;

public class OnlineShop extends Shop {
	
	List<Provider> providers; 

	public OnlineShop(String name, Map<String, HashMap<Enum, LinkedList<Clothes>>> clothes) {
		super(name);
		this.providers = new ArrayList<Provider>();
		this.clothes = clothes;
	}
	
	@Override
	public void sell(Client c, Order o) {
		if(c instanceof IBuyFromOnlineShop){
			Provider provider = providers.get((int)(Math.random()*providers.size()));
			
			
		}
		System.out.println("You are not allowed here!");
	}

}
