// created by Yuhan at 24/8/2020
// updated by Yuhan at 27/8/2020 for Sprint 2

import java.util.ArrayList;

public class CategoryDB {

	public static ArrayList<Category> catList = new ArrayList<Category>();
	
	public static Category inputCategory() {
		showCategoryMenu();
		String catName = Helper.readString("Enter category name: ");
		System.out.println(catName + " category added!");
		Category cat = new Category(catName);
		return cat;
	}
	
	public static void addCategory(Category cat) {
		catList.add(cat);
		System.out.println("Category added");
	}
	
	public static void viewCategories() {
		String allCat = String.format("%-5s %-25s\n", "ID no", "CATEGORY NAME");
		
		for (int i = 0; i < catList.size(); i++) {
			allCat += String.format("%-5s %-25s\n", (i + 1) ,catList.get(i).toString());
		}
		System.out.println(allCat);
	}
	
	public static void deleteCategory(String name) {
		String catName = Helper.readString("Enter category name: ");
		if (CategoryDB.catList.contains(catName)) {
			if (!(CategoryDB.catList.isEmpty())) {
				System.out.println("There are items in the category.");
			}
			else {
				CategoryDB.deleteCategory(catName);
			}
		}
	}
	
	// updated by Yuhan at 28/8/2020 for Sprint 2
	public static void updateCategory(String name) {
		boolean present = false;
		Category cat = null;
		
		for (int i = 0; i < catList.size(); i++) {
			if (catList.get(i).getName().equalsIgnoreCase(name));
			present = true;
			cat = catList.get(i);
		}
		if (present == true) {
			String newCatName = Helper.readString("Enter new category name: ");
			cat.setName(newCatName);
			System.out.println(newCatName + " updated!");
		} else {
			System.out.println("You have entered an invalid category name.");
		}
	}
	
	// updated by Yuhan at 28/8/2020 for Sprint 2
	public static void checkCategory() {
		
	}
	
	
	
	public static void showCategoryMenu() {
		System.out.println("1. View all Categories");
		System.out.println("2. Add category");
		System.out.println("3. Delete category");
		// updated by Yuhan at 27/8/2020 for Sprint 2
		System.out.println("4. Update category");
		System.out.println("5. Quit");
	}
	

}//end of class
