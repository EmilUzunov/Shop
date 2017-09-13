package shop.abstractClasses;

public abstract class AbstractWithNameAndPhone {
	private String name;
	private String phone;
	public AbstractWithNameAndPhone(String name) {
		super();
		this.name = name;
		setPhone();
	}
	public void setPhone() {
		String randPhone = "088";
				for (int i = 0; i < 7; i++) {
					randPhone += Math.random()*10;
				}
		
		this.phone = randPhone;
	}
	
	

}
