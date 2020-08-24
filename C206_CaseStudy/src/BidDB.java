import java.util.ArrayList;

public class BidDB {
	
	private static ArrayList<Bid> bidList = new ArrayList<Bid>();
	
	public static void addBid(Bid bid) {
		bidList.add(bid);
	}
	
	public static void viewAllBid() {
		for (int i =0; i<bidList.size();i++) {
			System.out.println("Bid " + i + ":");
			System.out.println("ID: " + bidList.get(i).getBidID());
			System.out.println("Item Name: " + bidList.get(i).getItemName());
			System.out.println("Seller Email: " + bidList.get(i).getSellerEmal());
			System.out.println("Buyer Email: " + bidList.get(i).getBuyerEmail());
			System.out.println("Bid Price: " + bidList.get(i).getBidPrice());
			System.out.println();
		}
	}
	
	public static void delBid(String a) {
		int c = Integer.parseInt(a);
		bidList.remove(c-1);
	}
	
	public static void showBidMenu() {
		System.out.println("Option 1: View All Bid");
		System.out.println("Option 2: Add Bid");
		System.out.println("Option 3: Remove Bid");
	}
}
