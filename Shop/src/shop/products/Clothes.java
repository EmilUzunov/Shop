package shop.products;

import shop.abstractClasses.Pricable;

public abstract class Clothes implements Pricable {
	
	private static final int NUMBER_OF_SWIMMINGSUTES = 3;
	private static final int NUMBER_OF_TROUSERS = 3;
	private static final int NUMBER_OF_JACKETS = 3;
	private static final int NUMBER_OF_DRESSES = 4;
	private static final int NUMBER_OF_TYPES = 4;
	private static final int MAX_SIZE = 8;
	private String name;
	private double price;
	private String description;
	private int size;
	private String type;
	private Enum kind;
	
	
	
	public Clothes() {
		super();
		this.name = "Some name";
		this.price = generateRandomPrice();
		this.size = generateRandomSize();
		
		
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public double getPrice() {
		return this.price;
	}



	

	@Override
	public String toString() {
		return "name=" + name +  ", description=" + description + ", size=" + size ;
	}

	public String getType() {
		return type;
	}



	public void setType() {
		this.type = this.getClass().toString();
		
	}



	public Enum getKind() {
		return this.kind;
	}



	public void setKind(Enum kind) {
		this.kind = kind;
	}


	

	private double generateRandomPrice(){
		return ((Math.random()*20)+10);
	}
	private int generateRandomSize(){
		return ((int)(Math.random()*MAX_SIZE)+1);
	}
	public static Clothes generateRandomClothes(){
		int randomType = (int) (Math.random()*NUMBER_OF_TYPES);
		switch (randomType) {
		case 0:
			int randomKind = (int)(Math.random()*NUMBER_OF_DRESSES);
			switch (randomKind) {
			case 0:
				return new Dress(DressEnum.BEACH);
			case 1:
				return new Dress(DressEnum.BUSINESS);
			case 2:
				return new Dress(DressEnum.EVENING);
			case 3:
				return new Dress(DressEnum.EVERYDAY);
			}
			break;
		case 1:
			randomKind = (int)(Math.random()*NUMBER_OF_JACKETS);
			switch (randomKind) {
			case 0:
				return new Jacket(JacketEnum.DENIM);
			case 1:
				return new Jacket(JacketEnum.LEATHER);
			case 2:
				return new Jacket(JacketEnum.WALLEN);
			
			}
			break;
		case 2:
			randomKind = (int)(Math.random()*NUMBER_OF_TROUSERS);
			switch (randomKind) {
			case 0:
				return new Trousers(TrousersEnum.JEANS);
			case 1:
				return new Trousers(TrousersEnum.RAZKROENI);
			case 2:
				return new Trousers(TrousersEnum.SHORT);
			
			}
			
			break;
		case 3:
			randomKind = (int)(Math.random()*NUMBER_OF_SWIMMINGSUTES);
			switch (randomKind) {
			case 0:
				return new SwimmingSute(SwimmingSuteEnum.BLACK);
			case 1:
				return new SwimmingSute(SwimmingSuteEnum.MULTICOLORED);
			case 2:
				return new SwimmingSute(SwimmingSuteEnum.WHITE);
			
			}
			break;
		
		
		}
		return null;
	}

	
}
