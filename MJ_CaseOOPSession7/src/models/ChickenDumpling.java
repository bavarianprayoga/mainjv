package models;

// ChickenDumpling merupakan subclass dari Dumpling
public class ChickenDumpling extends Dumpling {

	private String chickenType;
	
	public ChickenDumpling(String ingredients, int price, String chickenType) {
		super(ingredients, price);
		this.chickenType = chickenType;
	}

	// Implementasi abstract method make() dari class Dumpling
	@Override
	public void make() {
		System.out.println("Grilling chicken...");
		System.out.println("Wrapping into dumpling...");
		System.out.println("Chicken dumpling is ready!");
	}

	public String getChickenType() {
		return chickenType;
	}

}
