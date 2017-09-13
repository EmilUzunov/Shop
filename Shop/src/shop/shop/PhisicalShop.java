package shop.shop;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import shop.staff.Seller;

public class PhisicalShop extends Shop {
	Set<Seller> sellers; 
	OnlineShop onlineShop;
	
	
	public PhisicalShop(String name) {
		super(name);
		this.sellers = new TreeSet<Seller>();
		this.onlineShop = new OnlineShop("Online Tallent shp", this.clothes);
	}
	
	public OnlineShop getOnlineShop() {
		return onlineShop;
	}

	public void addSeller(Seller s){
		this.sellers.add(s);
	}


}
