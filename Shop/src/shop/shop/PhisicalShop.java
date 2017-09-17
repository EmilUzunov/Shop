package shop.shop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import shop.clients.Client;
import shop.clients.IBuyFromPhisicalShop;
import shop.products.Clothes;
import shop.staff.Manager;
import shop.staff.Seller;

public class PhisicalShop extends Shop {
	private static final int INITIAL_NUMBER_OF_CLOTHES = 100;
	private List<Seller> sellers;
	private OnlineShop onlineShop;
	
	// private double money;

	public PhisicalShop(String name) {
		super(name);
		this.sellers = new ArrayList<Seller>();
		for (int i = 0; i < INITIAL_NUMBER_OF_CLOTHES; i++) {
			this.addClothes(((Clothes.generateRandomClothes())));	
		}
		//System.out.println(this.clothes);
		this.onlineShop = new OnlineShop("Online Tallent shop", this.clothes);
		this.onlineShop.setPhisicalShop(this);

	}

	public OnlineShop getOnlineShop() {
		return onlineShop;

	}

	public void addSeller(Seller s) {
		this.sellers.add(s);
	}

	public double total() {
		this.setMoney();
		this.onlineShop.setMoney();
		this.setMoney(this.getMoney() + this.onlineShop.getMoney());
		return this.getMoney();
	}

	public void setMoney() {
		for (int i = 0; i < sellers.size(); i++) {
			this.setMoney(this.getMoney()+this.sellers.get(i).getTurnover());
		}

	}

	@Override
	public void sell(Client c, Order o) {
		if (c instanceof IBuyFromPhisicalShop) {
			for (Clothes clo : o.orderedClothes) {
				if (this.clothes.containsKey(clo.getType())
						&& this.clothes.get(clo.getType()).containsKey(clo.getKind())) {
					this.clothes.get(clo.getType()).get(clo.getKind()).remove(clo);
				} else {
					o.orderedClothes.remove(o);
				}
			}

			Seller seller = this.sellers.get((int) (Math.random() * sellers.size()));
			if (seller instanceof Manager) {
				int discount = (int) (Math.random() * 10) + 1;
				o.setPrice(o.getPrice() - (o.getPrice() * 0.01 * discount));
			}

			seller.setTurnover(seller.getTurnover() + o.getPrice());
			seller.executeOrder(o);
			this.addTosoldClothesTypes(o);

		} else {
			System.out.println("You are now beeng transfered to the online shop. Have a nice day!");
			this.onlineShop.sell(c, o);

		}
	}
	
	public void printSellers(){
		 Set<Seller> temp = new TreeSet<Seller>();
		 for(Seller s : sellers){
			 temp.add(s);
		 }
		 for(Seller s: temp){
			 s.updateSallary();
		 }
		 for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
			 System.out.println(iterator.next().toString());
		}
	}
}
