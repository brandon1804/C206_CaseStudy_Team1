// created by Yuhan at 24/8/2020
// updated by Yuhan at 27/8/2020 for Sprint 2

import java.util.ArrayList;

public class CategoryDB {

	public static ArrayList<Category> catList = new ArrayList<Category>();

	public static String viewCategories(ArrayList<Category> catList) {
		String allCat = String.format("%-25s\n", "-- CATEGORY NAME --");
		
		for (int i = 0; i < catList.size(); i++) {
			allCat += String.format("%-25s\n" ,catList.get(i).getName());
		}
		return allCat;
	}
		
	public static void addCategory(String cat) {
		String catName = Helper.readString("Enter new category name: ");
		Category newCat = new Category(catName);
		catList.add(newCat);
		System.out.println(catName + " added!");
	}

	// updated by Yuhan at 28/8/2020 for Sprint 2
	public static void deleteCategory(String catName) {
		boolean present = false;
				
		int i = 0; 
		for (;i < catList.size(); i++) {
			if (catList.get(i).getName().contains(catName)) {
				present = true;
				break;
			}
		}
		
		if (present) {
			catList.remove(i);
			System.out.println(catName + " deleted.");
		}
		else {
			System.out.println("Category not found");
		}
	}
	
	// updated by Yuhan at 28/8/2020 for Sprint 2
	public static void updateCategory(String name) {
		boolean present = false;
		
		int i = 0;
		for (; i < catList.size(); i++) {
			if (catList.get(i).getName().contains(name) == true) {
				present = true;
				break;
			}			
		}
		
		if (present) {
			String newCatName = Helper.readString("Enter new category name: ");
			catList.get(i).setName(newCatName);
			System.out.println(name + " updated to " + newCatName);
		} 
		else {
			System.out.println("You have entered an invalid category name.");
		}
	}
	
	
	
	
	
	public static void showCategoryMenu() {
		C206_CaseStudy.setHeader("CATEGORY MENU");
		System.out.println("1. View all Categories");
		System.out.println("2. Add category");
		System.out.println("3. Delete category");
		// updated by Yuhan at 27/8/2020 for Sprint 2
		System.out.println("4. Update category");
		System.out.println("5. Quit");
		System.out.println("");
	}
	
	public static void categoryMenu() {
		
		catList.add(new Category("CD"));
		catList.add(new Category("Books"));
		catList.add(new Category("Electronic accessories"));
		
		int option = 0;
		while (option != 5) {
			
			CategoryDB.showCategoryMenu();
			option = Helper.readInt("Enter option no: ");
			
			if (option == 1) {
				C206_CaseStudy.setHeader("VIEW CATEGORY");
				System.out.println(CategoryDB.viewCategories(catList));
			}
			else if (option == 2) {
				C206_CaseStudy.setHeader("ADD CATEGORY");
				CategoryDB.addCategory(null);
			}
			else if (option == 3) {
				C206_CaseStudy.setHeader("DELETE CATEGORY");
				String catName = Helper.readString("Enter category name: ");
				CategoryDB.deleteCategory(catName);
			}
			else if (option == 4) {
				C206_CaseStudy.setHeader("UPDATE CATEGORY");
				String update = Helper.readString("Enter category name: ");
				CategoryDB.updateCategory(update);
			}
			else {
				System.out.println("Goodbye!");
			}
		}
	}
	
	

}//end of class
