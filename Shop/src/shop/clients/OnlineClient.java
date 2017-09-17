package shop.clients;

import java.util.LinkedList;
import java.util.List;

import shop.products.Clothes;
import shop.shop.Order;
import shop.shop.Shop;

public class OnlineClient extends Client implements IBuyFromOnlineShop, ITipGivable {

	private static final double TIP_PERCENTAGE = 0.02;

	public OnlineClient(String name) {
		super(name);
	}

	@Override
	public void buy(Shop sh) {
		double promoDiscount = 0.01 * generatePromoCode();
		List<Clothes> orderedClothes = new LinkedList<Clothes>();
		int randomNumberOfClothes = (int) ((Math.random() * 3) + 3);
		for (int i = 0; i < randomNumberOfClothes; i++) {
			orderedClothes.add(Clothes.generateRandomClothes());
			
		}
		

		Order order = new Order(this, orderedClothes);
		double check = order.calculatePrice();
		check -= check * promoDiscount;
		order.setPrice(check);

		sh.sell(this, order);

	}

	public static int generatePromoCode() {
		return (int) ((Math.random()) * 5) + 5;
	}

	@Override
	public double giveTip(Order o) {
		return o.getPrice() * TIP_PERCENTAGE;
	}

}
