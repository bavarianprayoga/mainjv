package models;

public class BeefDumpling extends Dumpling {

	private String beefDoneness;
	
	public BeefDumpling(String ingredients, int price, String beefDoneness) {
		super(ingredients, price);
		this.beefDoneness = beefDoneness;
	}

	@Override
	public void make() {
		System.out.println("Steaming beef...");
		System.out.println("Wrapping into dumpling...");
		System.out.println("Beef dumpling is ready!");
	}

	public String getBeefDoneness() {
		return beefDoneness;
	}
	
}
