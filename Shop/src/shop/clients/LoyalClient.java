package shop.clients;

import shop.shop.Shop;

public class LoyalClient extends Client implements IBuyFromOnlineShop,IBuyFromPhisicalShop {

	public LoyalClient(String name) {
		super(name);
	}

	@Override
	void buy(Shop sh) {
		// TODO Auto-generated method stub
		
	}

}
