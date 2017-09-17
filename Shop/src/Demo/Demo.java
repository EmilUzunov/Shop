package Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

import shop.clients.Client;
import shop.clients.LoyalClient;
import shop.clients.OnlineClient;
import shop.clients.RandomClient;
import shop.shop.PhisicalShop;
import shop.staff.Provider;
import shop.staff.Seller;

public class Demo {
	public static void main(String[] args) {
		PhisicalShop shop = new PhisicalShop("Sweet tallents");
		System.out.println("Befor ordering:");
		// shop.addClothes();
		shop.addSeller(new Seller("Hasan"));
		shop.addSeller(new Seller("Maria"));
		shop.addSeller(new Seller("Ivan"));
		shop.addSeller(new Seller("Penka"));
		shop.addSeller(new Seller("Stamat"));
		shop.getOnlineShop().addProviders(new Provider("Ivo"));
		shop.getOnlineShop().addProviders(new Provider("Irina"));
		shop.getOnlineShop().addProviders(new Provider("Dido"));
		shop.getOnlineShop().addProviders(new Provider("Kiril"));
		shop.getOnlineShop().addProviders(new Provider("Metodi"));
		
		shop.printCatalog();
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.addAll(Arrays.asList(new OnlineClient("o1"), new OnlineClient("o2"), new OnlineClient("o3"),
				new OnlineClient("o4"), new OnlineClient("o5"), new RandomClient("r1"), new RandomClient("r2"),
				new RandomClient("r3"), new RandomClient("r4"), new RandomClient("r5"), new LoyalClient("l1"),
				new LoyalClient("l2"), new LoyalClient("l3"), new LoyalClient("l4"), new LoyalClient("l5")));
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).buy(shop);
		}
//		o1.buy(shop.getOnlineShop());
//		o2.buy(shop.getOnlineShop());
//		o3.buy(shop.getOnlineShop());
//		o4.buy(shop.getOnlineShop());
//		o5.buy(shop.getOnlineShop());
//		p1.buy(shop);
//		p2.buy(shop);
//		p3.buy(shop);
//		p4.buy(shop);
//		p5.buy(shop);
//		l1.buy(shop);
//		l2.buy(shop.getOnlineShop());
//		l3.buy(shop);
//		l4.buy(shop);
//		l5.buy(shop.getOnlineShop());
		System.out.println("After ordering:");
		shop.printCatalog();
		System.out.println("Total income:");
		System.out.println(shop.total());

		TreeSet<Provider> temp = (shop.getOnlineShop().orderingProviders());
		// for(Provider s : temp){
		// System.out.println(1234);
		// System.out.println(s);
		// }
		for (Iterator it = temp.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}
}
