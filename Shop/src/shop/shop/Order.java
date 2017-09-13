package shop.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import shop.abstractClasses.Pricable;
import shop.clients.Client;
import shop.products.Clothes;

public class Order implements Pricable {
	private Client client;
	private double price;
	private String address;
	List<Clothes> orderedClothes;
	LocalDateTime dateTime;
	
	
	
	public Order(Client client, List<Clothes> orderedClothes) {
		super();
		this.client = client;
		
		this.address = "20A";
		this.orderedClothes = new ArrayList<Clothes>();
		this.orderedClothes.addAll(orderedClothes);
		this.dateTime = LocalDateTime.now();
		
	}


	public void setPrice(double price){
		this.price = price;
	}

	public double calculatePrice() {
		for (int i = 0; i < this.orderedClothes.size(); i++) {
			this.price += this.orderedClothes.get(i).getPrice();
		}
		return this.price;
	}




	@Override
	public double getPrice() {
		return this.price;
	}
	
	public List<Clothes> getOrderedClothes(){
		 List<Clothes> list = new ArrayList<Clothes>();
		 list.addAll(orderedClothes);
		return list;
		
	}



	

}
