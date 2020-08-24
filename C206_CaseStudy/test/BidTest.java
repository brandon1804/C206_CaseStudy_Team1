import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BidTest {

	private Bid bid1, bid2;
	
	@Before
	public void setUp() throws Exception {
		bid1 = new Bid("1", "Glass", "Tim Sell@", "Tim Buy@", 200);
		bid2 = new Bid("2", "Sap", "kim Sell@", "kim Buy@", 500);
	}

	@After
	public void tearDown() throws Exception {
		bid1 = null;
		bid2 = null;
		BidDB.getBidList().clear();
	}

	@Test
	public void deleteBidTest() {
		//Test BidList not null
		assertNotNull("Test that bidList is NOT null", BidDB.getBidList());
		
		//Test that the delete based on ID works and that the correct name is deleted
		BidDB.addBid(bid1);
		BidDB.addBid(bid2);
		BidDB.delBid("1");  
		
      //Test that after the delete, the size of the arraylist decreases
      assertEquals("Test that the size of the array decreases",1,BidDB.getBidList().size());    
	}
	
	
	@Test
	public void deleteOtherNumberEnteredBidTest() {
		//Test BidList not null
		assertNotNull("Test that bidList is NOT null", BidDB.getBidList());
		
		//Test That if system will catch if wrong value entered apart for ID
		BidDB.addBid(bid1);  
		BidDB.delBid("a");  
 
  
	}

	
	

}
