package main;

import java.util.*;

import models.BeefDumpling;
import models.ChickenDumpling;
import models.Dumpling;

public class Main {
	
	ArrayList<Dumpling> dumplingList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	public Main() {
		String input;
		do {
			System.out.println("DUMPLING RESTO");
			System.out.println("==============");
			System.out.println("1. Create Dumpling");
			System.out.println("2. View Dumpling");
			System.out.println("3. Exit");
			System.out.print(">> ");
			input = scanner.nextLine();
			if (input.equals("1")) {
				menuCreateDumpling();
			} else if (input.equals("2")) {
				menuViewDumpling();
			} else if (input.equals("3")) {
				return;
			}
		} while (!input.equals("3"));
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void menuCreateDumpling() {
		String ingredients;
		do {
			System.out.print("Input ingredients [cannot be empty]: ");
			ingredients = scanner.nextLine();
		} while (ingredients.isEmpty());
		
		int price;
		do {
			System.out.print("Input price [must be > 0]: ");
			price = Integer.valueOf(scanner.nextLine());
		} while (price <= 0);
		
		String type;
		do {
			System.out.print("Input type [chicken | beef]: ");
			type = scanner.nextLine();
		} while (!type.equalsIgnoreCase("chicken") && !type.equalsIgnoreCase("beef"));
		
		Dumpling dumpling = null;
		if (type.equalsIgnoreCase("chicken")) {
			String chickenType;
			do {
				System.out.print("Input chicken type [negeri | kampung]: ");
				chickenType = scanner.nextLine();
			} while (!chickenType.equals("negeri") && !chickenType.equals("kampung"));
			dumpling = new ChickenDumpling(ingredients, price, chickenType);
		} else if (type.equalsIgnoreCase("beef")) {
			String beefDoneness;
			do {
				System.out.print("Input beef doneness [medium | well done]: ");
				beefDoneness = scanner.nextLine();
			} while (!beefDoneness.equalsIgnoreCase("medium") && !beefDoneness.equalsIgnoreCase("well done"));
			dumpling = new BeefDumpling(ingredients, price, beefDoneness);
		}
		
		if (dumpling != null) {
			dumplingList.add(dumpling);
			System.out.println("Successfully created dumpling.");
		}
	}
	
	public void menuViewDumpling() {
		if (dumplingList.isEmpty()) {
			System.out.println("No dumplings :(");
			return;
		}
		System.out.println();
		System.out.println("=======================");
		System.out.println("DUMPLINGS");
		System.out.println("=======================");
		for (int i = 0; i < dumplingList.size(); i++) {
			Dumpling dumpling = dumplingList.get(i);
			if (dumpling instanceof ChickenDumpling) {
				System.out.println((i + 1) + ". Chicken Dumpling");
				System.out.println("Ingredients: " + dumpling.getIngredients());
				System.out.println("Price: " + dumpling.getPrice());
				
				// Typecast dari Dumpling ke ChickenDumpling untuk print chickenType
				System.out.println("Chicken type: " + ((ChickenDumpling) dumpling).getChickenType());
			} else if (dumpling instanceof BeefDumpling) {
				System.out.println((i + 1) + ". Beef Dumpling");
				System.out.println("Ingredients: " + dumpling.getIngredients());
				System.out.println("Price: " + dumpling.getPrice());
				
				// Typecast dari Dumpling ke BeefDumpling untuk print beefDoneness
				System.out.println("Beef doneness: " + ((BeefDumpling) dumpling).getBeefDoneness());
			}
			System.out.println();
		}
	}
	
}
