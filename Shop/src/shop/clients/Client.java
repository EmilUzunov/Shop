package shop.clients;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import shop.abstractClasses.AbstractWithNameAndPhone;
import shop.products.Clothes;
import shop.shop.Order;
import shop.shop.Shop;


public abstract class Client extends AbstractWithNameAndPhone {
	List<Order> orders;

	public Client(String name) {
		super(name);
		orders = new ArrayList<Order>();
		
	}
	public abstract void buy(Shop sh);
	
	public double ClientMoneySpent(){
		double total = 0;
		for(Order o : orders){
			total+=o.getPrice();
		}
		return total;
	}
	public int ClientAmountofProductsBoth(){
		int numberOfClothesOrdered = 0;
		for(Order o : orders){
			numberOfClothesOrdered += o.getOrderedClothes().size();
		}
		 return numberOfClothesOrdered;
	}
	@Override
	public String toString() {
		return "Client [ClientMoneySpent()=" + ClientMoneySpent() + ", ClientAmountofProductsBoth()="
				+ ClientAmountofProductsBoth() + ", getName()=" + getName() + "]";
	}

}
