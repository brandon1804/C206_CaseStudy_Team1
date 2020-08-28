// created by Yuhan at 24/8/2020
// updated by Yuhan at 27/8/2020 for Sprint 2

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	private Category cat1;
	private Category cat2;
	private Category cat3;
	
	private ArrayList<Category> catList;
	
	public CategoryTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		cat1 = new Category("CD");
		cat2 = new Category("Books");
		cat3 = new Category("Electronic accessories");
		
		catList = new ArrayList<Category>();
	}
	
	@After
	public void tearDown() throws Exception {
		cat1 = null;
		cat2 = null;
		cat3 = null;
		CategoryDB.catList.clear();
	}

	@Test
	public void addCategoryTest() {
		
		// Test that catList is NOT null
		assertNotNull("Test that catList is NOT null", CategoryDB.catList);
		
		// Test that the size of catList is empty before adding any categories 
		assertEquals("Test that the size of catList is empty before adding any categories", 0, CategoryDB.catList.size());
		
		// Test that the size of catList is 1 after adding a category
		CategoryDB.addCategory(cat1);
		assertEquals("Test that the size of catList is 1 after adding a category", 1, CategoryDB.catList.size());
		
		// Test that the first element in catList is the same as what was added
		assertSame("Test that the first element in catList is the same as what was added", cat1, CategoryDB.catList.get(0));
		
	}
	
	@Test
	public void viewCategoriesTest() {
		
		// Test that catList is NOT null
		assertNotNull("Test that catList is NOT null", CategoryDB.catList);
		
		// Test that the size of catList is empty before adding any categories 
		assertEquals("Test that the size of catList is empty before adding any categories", 0, CategoryDB.catList.size());
		
		// Test that the size of catList is 1 after adding a category
		CategoryDB.addCategory(cat1);
		assertEquals("Test that the size of catList is 1 after adding a category", 1, CategoryDB.catList.size());
		
		// Test that the first element in catList is the same as what was added
		assertSame("Test that the first element in catList is the same as what was added", cat1, CategoryDB.catList.get(0));		
		
	}
	
	@Test
	public void deleteCategory() {
		
		// Test that catList is NOT null
		assertNotNull("Test that catList is NOT null", CategoryDB.catList);
		
		// updated by Yuhan at 27/8/2020 for Sprint 2
		// Test that size of catList is empty before deleting
		assertEquals("Test that size of catList is empty before deleting", 0, CategoryDB.catList.size());
		
		// Test that category is deleted based on the name
		CategoryDB.addCategory(cat1);
		CategoryDB.deleteCategory("cat1");
		assertEquals("Test that category is deleted based on the name", 1, CategoryDB.catList.size());

	}
	
	// updated by Yuhan at 27/8/2020 for Sprint 2
	@Test
	public void updateCategory() {
		
		// Test that catList is NOT null
		assertNotNull("Test that catList is NOT null", CategoryDB.catList);
		
		// Test that size of catList is not empty before updating category
		CategoryDB.addCategory(cat1);
		CategoryDB.updateCategory("cat1");
		assertTrue("Test that size of catList is not empty before updating category", CategoryDB.catList.isEmpty() == false);
	}
	
	// updated by Yuhan at 27/8/2020 for Sprint 2
	@Test
	public void checkCategory() {
		
		// Test that catList is NOT null
		assertNotNull("Test that catList is NOT null", CategoryDB.catList);

		// Test that the size of catList is 1 to show the number of items
		CategoryDB.addCategory(cat1);
		assertEquals("Test that the size of catList is 1 to show the number of items", 1, CategoryDB.catList.size());
	}

	@Test
	public void showCategoryMenu() {
		
		// Test that catList is NOT null
		assertNotNull("Test that catList is NOT null", CategoryDB.catList);
		
		// Test that catList is empty, if empty, system should not display anything
		CategoryDB.showCategoryMenu();
		assertEquals("Test that catList is empty, if empty, system should not display anything", 0, CategoryDB.catList.size());
	}

}//end of class
