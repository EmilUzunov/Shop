package shop.clients;

import java.util.ArrayList;
import java.util.List;

import shop.abstractClasses.AbstractWithNameAndPhone;
import shop.shop.Order;
import shop.shop.Shop;


public abstract class Client extends AbstractWithNameAndPhone {
	List<Order> orders;

	public Client(String name) {
		super(name);
		orders = new ArrayList<Order>();
		
	}
	public abstract void buy(Shop sh);

}
