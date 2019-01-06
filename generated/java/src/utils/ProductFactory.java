package utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import vdm.Clothing;
import vdm.Footwear;
import vdm.Furniture;
import vdm.Gear;
import vdm.Product;
import vdm.Toy;

public class ProductFactory {

	public static Product make(String productType, String productState) {
		Object state = getProductState(productState);
		switch (productType) {
		case "Clothing":
			return makeClothing(state);
		case "Footwear":
			return makeFootwear(state);
		case "Furniture":
			return makeFurniture(state);
		case "Gear":
			return makeGear(state);
		case "Toy":
			return makeToy(state);
		default:
			System.err.println("Invalid product type");
			return null;
		}
	}

	private static Object getProductState(String productState) {
		try {
			return Class.forName("vdm.quotes." + productState + "Quote").getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Clothing makeClothing(Object state) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Minimum age: ");
		int minAge = scanner.nextInt();
		System.out.print("Maximum age: ");
		int maxAge = scanner.nextInt();
		System.out.print("Sub category (Jeans, Dresses, Pajamas): ");
		String subCategoryStr = scanner.next();
		Object subCategory = null;
		try {
			subCategory = Class.forName("vdm.quotes." + subCategoryStr + "Quote").getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return new Clothing(state, minAge, maxAge, subCategory);
	}
	
	private static Footwear makeFootwear(Object state) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Size: ");
		int size = scanner.nextInt();
		System.out.print("Sub category (Boots, Party, Sports): ");
		String subCategoryStr = scanner.next();
		Object subCategory = null;
		try {
			subCategory = Class.forName("vdm.quotes." + subCategoryStr + "Quote").getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return new Footwear(state, size, subCategory);
	}
	
	private static Furniture makeFurniture(Object state) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Sub category (Cribs, Beds, ToyBoxes): ");
		String subCategoryStr = scanner.next();
		Object subCategory = null;
		try {
			subCategory = Class.forName("vdm.quotes." + subCategoryStr + "Quote").getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return new Furniture(state, subCategory);
	}
	
	private static Gear makeGear(Object state) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Minimum age: ");
		int minAge = scanner.nextInt();
		System.out.print("Sub category (Swings, Bathtubs, Trolleys): ");
		String subCategoryStr = scanner.next();
		Object subCategory = null;
		try {
			subCategory = Class.forName("vdm.quotes." + subCategoryStr + "Quote").getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return new Gear(state, minAge, subCategory);
	}
	
	private static Toy makeToy(Object state) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Minimum age: ");
		int minAge = scanner.nextInt();
		System.out.print("Sub category (Puzzles, Legos, Cars): ");
		String subCategoryStr = scanner.next();
		Object subCategory = null;
		try {
			subCategory = Class.forName("vdm.quotes." + subCategoryStr + "Quote").getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return new Toy(state, minAge, subCategory);
	}

}
