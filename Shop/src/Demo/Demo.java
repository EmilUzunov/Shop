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
		shop.getOnlineShop().setClothes();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Befor ordering:");
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
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Cases where the client is shoping where he shouldn't :");
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.addAll(Arrays.asList(new OnlineClient("o1"), new OnlineClient("o2"), new OnlineClient("o3"),
				new OnlineClient("o4"), new OnlineClient("o5"), new RandomClient("r1"), new RandomClient("r2"),
				new RandomClient("r3"), new RandomClient("r4"), new RandomClient("r5"), new LoyalClient("l1"),
				new LoyalClient("l2"), new LoyalClient("l3"), new LoyalClient("l4"), new LoyalClient("l5")));
		for (int i = 0; i < clients.size(); i++) {
			if (Math.random() < 0.5f) {
				clients.get(i).buy(shop);
			} else {
				clients.get(i).buy(shop.getOnlineShop());
			}
		}
		System.out.println("-----------------------------------------------------------------");
		System.out.println("After ordering:");
		shop.printCatalog();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Total income:");
		System.out.println(shop.total());
		TreeSet<Provider> temp = (shop.getOnlineShop().orderingProviders());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Providers ordered(descending) by number of clothes sold:");
		for (Iterator it = temp.descendingIterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		System.out.println("-----------------------------------------------------------------");
		System.out.println("The most sold product is:");

		shop.printTheMostSoldProduct();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Printing sellers:");
		shop.printSellers();
		PrintTheClientWitchSpentTheMost(clients);

	}

	private static void PrintTheClientWitchSpentTheMost(ArrayList<Client> clients) {
		double max = 0;
		int numberOfClothes = 0;
		for (Client t : clients) {
			if(t.ClientAmountofProductsBoth()>numberOfClothes){
				numberOfClothes = t.ClientAmountofProductsBoth();
			}
			if (t.ClientMoneySpent() > max) {
				max = t.ClientMoneySpent();
			}
		}
		for (Client t : clients) {
			if (max == t.ClientMoneySpent()) {
				System.out.println("-----------------------------------------------------------------");
				System.out.println("The client witch spent the most money :");
				System.out.println(t);
			}
			if(numberOfClothes == t.ClientAmountofProductsBoth()){
				System.out.println("-----------------------------------------------------------------");
				System.out.println("The client witch both the biggest amount of products :");
				System.out.println(t);
			}
		}
	}
}
