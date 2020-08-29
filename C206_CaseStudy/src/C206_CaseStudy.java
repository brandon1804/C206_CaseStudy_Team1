import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		showCategoryMenu();
		
	}//end of main method
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// updated by Yuhan at 28/8/2020 for Sprint 2
	private static void showCategoryMenu() {
		int option = Helper.readInt("Enter option number: ");
		while (option != 5) {
			if (option == 1) {
				CategoryDB.viewCategories();
			}
			else if (option == 2) {
				CategoryDB.inputCategory();
				CategoryDB.viewCategories();
			}
			else if (option == 3) {
				String catName = Helper.readString("Enter category name: ");
				CategoryDB.deleteCategory(catName);
				CategoryDB.viewCategories();
			}
			else if (option == 4) {
				String update = Helper.readString("Enter new category name: ");
				CategoryDB.updateCategory(update);
				CategoryDB.viewCategories();
			}
			else {
				System.out.println("Goodbye!");
			}
		}
	}
	
	
}//end of class
