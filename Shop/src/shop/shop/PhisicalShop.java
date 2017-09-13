package shop.shop;

import java.util.Set;
import java.util.TreeSet;

import shop.clients.Client;
import shop.clients.IBuyFromOnlineShop;
import shop.clients.IBuyFromPhisicalShop;
import shop.staff.Seller;

public class PhisicalShop extends Shop {
	Set<Seller> sellers; 
	OnlineShop onlineShop;
	
	
	public PhisicalShop(String name) {
		super(name);
		this.sellers = new TreeSet<Seller>();
		this.onlineShop = new OnlineShop("Online Tallent shop", this.clothes);
	}
	
	public OnlineShop getOnlineShop() {
		return onlineShop;
	}

	public void addSeller(Seller s){
		this.sellers.add(s);
	}

	@Override
	public void sell(Client c, Order o) {
		if(c instanceof IBuyFromPhisicalShop){
			
		}
		System.out.println("You are not allowed here!");
	}


}
