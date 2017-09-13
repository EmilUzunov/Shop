package shop.clients;

import java.util.LinkedList;
import java.util.List;

import shop.products.Clothes;
import shop.shop.Order;
import shop.shop.Shop;

public class RandomClient extends Client implements IBuyFromPhisicalShop{

	public RandomClient(String name) {
		super(name);
	}

	@Override
	void buy(Shop sh) {
		List<Clothes> orderedClothes = new LinkedList<Clothes>();
		int randomNumberOfClothes = (int)((Math.random()*3)+1);
		for (int i = 0; i < randomNumberOfClothes; i++) {
			orderedClothes.add(Clothes.generateRandomClothes());
		}
		
		Order order = new Order(this, orderedClothes);
		double check = 0;
		order.calculatePrice();
		if(order.getPrice()>50f){
			//dostavka
			check = order.getPrice()-5f;
		}else{
			check = order.getPrice();
		}
		order.setPrice(check);
		
		sh.sell(this, order);
		
	}

}
