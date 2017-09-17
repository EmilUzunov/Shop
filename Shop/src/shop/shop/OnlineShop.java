package shop.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import shop.clients.Client;
import shop.clients.IBuyFromOnlineShop;
import shop.clients.ITipGivable;
import shop.products.Clothes;
import shop.staff.Provider;

public class OnlineShop extends Shop {

	private List<Provider> providers;
	private PhisicalShop phisicalShop;
	

	public OnlineShop(String name, Map<String, HashMap<Enum, LinkedList<Clothes>>> clothes) {
		super(name);
		this.providers = new ArrayList<Provider>();
		//setClothes(phisicalShop.clothes);
		
	}

	
	public void setClothes(Map<String, HashMap<Enum, LinkedList<Clothes>>> clo){
		this.clothes = clo;
	}
	public void addProviders(Provider p) {

		this.providers.add(p);

	}
	
	public TreeSet<Provider> orderingProviders(){
		TreeSet<Provider >orderedProviders = new TreeSet<Provider>();
		
		for (int i = 0; i < this.providers.size(); i++) {
			orderedProviders.add(providers.get(i));
		}
		return orderedProviders;
		
	}
	
	public void setMoney() {
		for (int i = 0; i < providers.size(); i++) {
			this.setMoney(this.getMoney()+this.providers.get(i).getTurnover());
		}
		
	}

	public void setPhisicalShop(PhisicalShop phisicalShop) {
		this.phisicalShop = phisicalShop;
	}

	@Override
	public void sell(Client c, Order o) {
		if (c instanceof IBuyFromOnlineShop) {
			
			for (Clothes clo : o.orderedClothes) {
				if (this.clothes.containsKey(clo.getType())
						&& this.clothes.get(clo.getType()).containsKey(clo.getKind())) {
					this.clothes.get(clo.getType()).get(clo.getKind()).remove(clo);
				} else {
					o.orderedClothes.remove(o);
				}
			}
			Provider provider = providers.get((int) (Math.random() * providers.size()));
			if (c instanceof ITipGivable) {
				provider.setTip(((ITipGivable) (c)).giveTip(o));
				o.setPrice(o.getPrice() - ((ITipGivable) (c)).giveTip(o));
			}
			provider.setTurnover(provider.getTurnover() + o.getPrice());

		} else {
			System.out.println("You are now beeng transfered to the phisical shop. Have a nice day!");
			this.phisicalShop.sell(c, o);
		}
	}

}
