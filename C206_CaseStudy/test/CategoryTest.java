import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	private Category cat1;

	@Before
	public void setUp() throws Exception {
		cat1 = new Category("Books");
	}
	

	@After
	public void tearDown() throws Exception {
		cat1 = null;
		CategoryDB.catList.clear();
	}

	@Test
	public void addCategoryTest() {
		
		//Test that catList is NOT null
		assertNotNull("Test that catList is NOT null", CategoryDB.catList);
		
		//Test that the size of catList is empty before adding any categories 
		assertEquals("Test that the size of catList is empty before adding any categories", 0, CategoryDB.catList.size());
		
		//Test that the size of catList is 1 after adding a category
		CategoryDB.addCategory(cat1);
		assertEquals("Test that the size of catList is 1 after adding a category", 1, CategoryDB.catList.size());
		
		//Test that the first element in catList is the same as what was added
		assertSame("Test that the first element in catList is the same as what was added", cat1, CategoryDB.catList.get(0));
		
	}

}//end of class
