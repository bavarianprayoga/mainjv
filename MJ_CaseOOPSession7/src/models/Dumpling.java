package models;

// Abstract Class -> Tidak bisa di-instantiate, hanya untuk menjadi superclass
public abstract class Dumpling {
	
	private String ingredients;
	private int price;

	public Dumpling(String ingredients, int price) {
		this.ingredients = ingredients;
		this.price = price;
	}

	// Abstract Method -> Method yang perlu di-implement pada subclass (children) dari class ini
	public abstract void make();

	public String getIngredients() {
		return ingredients;
	}

	public int getPrice() {
		return price;
	}
}
