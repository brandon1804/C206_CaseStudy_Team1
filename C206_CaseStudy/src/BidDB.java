import java.util.ArrayList;

public class BidDB {
	public static void main(String[] args) {

		int option = 0;

		while (option != 4) {
			BidDB.showBidMenu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				// View all items
				BidDB.viewAllBid();
			} else if (option == 2) {
				int count = 0;
				String a = Helper.readString("Enter A Bid ID > ");

				if (getBidList().size() == 0) {
					ques(a);
				} else {
					for (int i = 0; i < getBidList().size(); i++) {
						if (a.equals(getBidList().get(i).getBidID()) == true) {
							System.out.println("Bid ID already exist please key in a unique ID\n");
							count = count + 1;
						}
					}
					if (count == 0) {
						ques(a);
					}
				}
			} else if (option == 3) {
				int count = 0;
				String name = Helper.readString("Enter Your Email > ");
				if (getBidList().size() == 0) {
					System.out.println("The user does not have a existing bid\n");
				} else {
					for (int i = 0; i < getBidList().size(); i++) {

						if (name.equals(getBidList().get(i).getBuyerEmail()) == true) {
							output(i);
							String selc = Helper.readString("Enter Item ID of item you wish to remove > ");
							BidDB.delBid(selc);
							System.out.println("Item removed\n");
							count = count + 1;
						}
					}
					if (count == 0) {
						System.out.println("The user does not have a existing bid\n");
					}
				}
			}

			else if (option == 4) {
				System.out.println("Thank You. GoodBye!");
			} else {
				System.out.println("Invalid Option\n");
			}

		}
	}

	public static void ques(String a) {
		String b = Helper.readString("Enter Item Name > ");
		String c = Helper.readString("Enter Seller Eamil > ");
		String d = Helper.readString("Enter your Email > ");
		int e = Helper.readInt("Enter Your Bid Price > ");

		System.out.println();
		Bid bid1 = new Bid(a, b, c, d, e);
		BidDB.addBid(bid1);
	}

	public static void output(int i) {
		System.out.println(String.format("\nID: %s\nItem Name: %s\nSeller Email: %s\nBuyer Email: %s\nBid Price: %f\n",
				bidList.get(i).getBidID(), bidList.get(i).getItemName(), bidList.get(i).getSellerEmal(),
				bidList.get(i).getBuyerEmail(), bidList.get(i).getBidPrice()));
	}

	private static ArrayList<Bid> bidList = new ArrayList<Bid>();

	public static void showBidMenu() {
		System.out.println("1: View All Bid");
		System.out.println("2: Add Bid");
		System.out.println("3: Remove Bid");
		System.out.println("4: Quit");
	}

	public static void addBid(Bid bid) {
		getBidList().add(bid);
	}

	public static void viewAllBid() {

		if (getBidList().size() == 0) {
			System.out.println("There is no Bid Currently\n");
		} else {
			for (int i = 0; i < getBidList().size(); i++) {

				output(i);
			}
		}
	}

	public static void delBid(String a) {
		int c = Integer.parseInt(a);
		c = c - 1;
		getBidList().remove(c);

	}

	public static ArrayList<Bid> getBidList() {
		return bidList;
	}

	public static void setBidList(ArrayList<Bid> bidList) {
		BidDB.bidList = bidList;
	}
}
