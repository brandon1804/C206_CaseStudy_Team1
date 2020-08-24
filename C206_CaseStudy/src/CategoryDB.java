// created by Yuhan at 24/8/2020

import java.util.ArrayList;

public class CategoryDB {

	public static ArrayList<Category> catList = new ArrayList<Category>();

	
	public static Category inputCategory() {
		showCategoryMenu();
		String catName = Helper.readString("Enter category name: ");

		Category cat = new Category(catName);
		return cat;
	}
	
	public static void addCategory(Category cat) {
		catList.add(cat);
		System.out.println("Category added");
	}
	
	public static void viewCategories() {
		String allCat = String.format("%-25s\n", "CATEGORY NAME");
		
		for (int i = 0; i < catList.size(); i++) {
			allCat += String.format("%-25s\n", catList.get(i).toString());
		}
		System.out.println(allCat);
	}
	
	public static void deleteCategory(String name) {
		catList.remove(name);
	}
	
	public static void showCategoryMenu() {
		System.out.println("1. View all Categories");
		System.out.println("2. Add category");
		System.out.println("3. Delete category");
	}
	

}//end of class
