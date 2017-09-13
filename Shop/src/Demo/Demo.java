package Demo;

import shop.products.Clothes;

import shop.products.Dress;
import shop.products.DressEnum;
import shop.products.Jacket;
import shop.products.JacketEnum;
import shop.products.SwimmingSute;
import shop.products.SwimmingSuteEnum;
import shop.products.Trousers;
import shop.products.TrousersEnum;
import shop.shop.PhisicalShop;

public class Demo {
	public static void main(String[] args) {
		PhisicalShop shop = new PhisicalShop("Sweet tallents");

		System.out.println(Clothes.generateRandomClothes());

	}
}
