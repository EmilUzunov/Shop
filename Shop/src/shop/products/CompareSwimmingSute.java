package shop.products;

import java.util.Comparator;

public class CompareSwimmingSute implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof SwimmingSute && o2 instanceof SwimmingSute) {
			int result = (((SwimmingSute) (o1)).getParts()) - (((SwimmingSute) (o1)).getParts());

			return result;

		} else {
			return 0;
		}
	}

}
