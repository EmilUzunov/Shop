package shop.clients;

import java.util.LinkedList;
import java.util.List;

import shop.products.Clothes;
import shop.shop.OnlineShop;
import shop.shop.Order;
import shop.shop.Shop;

public class LoyalClient extends Client implements IBuyFromOnlineShop,IBuyFromPhisicalShop, ITipGivable {

	private static final double TIP_PERCENTAGE = 0.05;
	private static final int DELIVERY_PRICE = 5;
	private static final int DISCOUNT_AFTER_50 = 15;
	private static final int DISCOUNT_UNDER_50 = 10;

	public LoyalClient(String name) {
		super(name);
	}

	@Override
	public void buy(Shop sh) {
		List<Clothes> orderedClothes = new LinkedList<Clothes>();
		int randomNumberOfClothes = (int)((Math.random()*3)+4);
		for (int i = 0; i < randomNumberOfClothes; i++) {
			orderedClothes.add(Clothes.generateRandomClothes());
		}
		
		Order order = new Order(this, orderedClothes);
		double check = order.calculatePrice();;
		
		double discount;
		if(order.getPrice()>50f){
			
			discount = DISCOUNT_AFTER_50*0.01;
		}else{
			discount = DISCOUNT_UNDER_50*0.01;
		}

		check -= check*discount;
		
		if(sh instanceof OnlineShop){
			check -= DELIVERY_PRICE;
		}
		
		order.setPrice(check);
		this.orders.add(order);
		sh.sell(this, order);
	}

	@Override
	public double giveTip(Order o) {
		return o.getPrice()*TIP_PERCENTAGE;
	}

}
