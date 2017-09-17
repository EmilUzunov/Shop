package shop.products;

import java.util.Comparator;

public class CompareClothesByPrice implements Comparator<Clothes> {

	@Override
	public int compare(Clothes o1, Clothes o2) {
		if(o1 instanceof Clothes && o2 instanceof Clothes){
		return (int) ((o1.getPrice() - o2.getPrice())*100);
		}
		return 1;
	}

}
