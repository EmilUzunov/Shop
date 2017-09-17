package shop.products;

import java.util.Comparator;

public class CompareTrousers implements Comparator<Clothes> {

	@Override
	public int compare(Clothes o1, Clothes o2) {
		if (o1 instanceof Trousers && o2 instanceof Trousers) {
			int result = (((Trousers) (o2)).getHight() + ((Trousers) (o2)).getWidth())
					- (((Trousers) (o1)).getHight() + ((Trousers) (o1)).getWidth());
			
			return result;
			

		} else{
			return 1;
		}
	}
}
