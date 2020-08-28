import java.util.ArrayList;


public class BidDB {
	public static void main(String[] args) {

		int option = 0;

		while (option != 6) {

			BidDB.showBidMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				BidDB.viewAllBid();

			} else if (option == 2) {
				addBid();

			} else if (option == 3) {
				removeBid();
			}

			else if (option == 4) {
				updateBid();
			}

			else if (option == 5) {
				removeBuyerBid();
			}

			// Escape Option
			else if (option == 6) {
				System.out.println("Thank You. GoodBye!");
			} else {
				System.out.println("Invalid Option\n");
			}

		}
	}

	
	
	
	// All Methods Here
	public static void removeBuyerBid() {
		boolean count = false;
		boolean count2 = false;

		String name = Helper.readString("Enter Your Email > ");
		if (getBidList().size() == 0) {
			System.out.println("There is currently no active bid\n");
		} else {
			for (int i = 0; i < getBidList().size(); i++) {

				if (name.equals(getBidList().get(i).getSellerEmal()) == true) {
					output(i);
					count = true;
					count2 = true;
				}
			}

			if (count2 == true) {
				String selc = Helper.readString("Enter Bid ID of buyer bid you wish to remove > ");
				BidDB.delBid(selc);
				System.out.println("Item removed\n");
			}
			if (count == false) {
				System.out.println("This user is not selling any items at the moment\n");
			}
		}
	}

	public static void updateBid() {
		boolean count = false;
		boolean count2 = false;
		boolean count3 = false;
		String name = Helper.readString("Enter Your Email > ");
		if (getBidList().size() == 0) {
			System.out.println("There is currently no active bid\n");
		} else {
			for (int i = 0; i < getBidList().size(); i++) {

				if (name.equals(getBidList().get(i).getBuyerEmail()) == true) {
					output(i);

					count = true;
					count2 = true;
				}
			}
			if (count2 == true) {
				String selc = Helper.readString("Enter Bid ID of item you wish to update bid > ");

				for (int i = 0; i < getBidList().size(); i++) {
					if (selc.equals(getBidList().get(i).getBidID()) == true) {
						String bidSelec = Helper.readString("Enter The updated bid amount > ");
						getBidList().get(i).setBidPrice(Integer.parseInt(bidSelec));
						System.out.println("Bid Updated\n");
						count3 = true;
					}
				}

			}
			if (count3 == false) {
				System.out.println("Invalid Bid ID Keyed\n");
			}

			if (count == false) {
				System.out.println("This user does not have a existing bid\n");
			}
		}
	}

	public static void removeBid() {
		boolean count = false;
		boolean count2 = false;

		String name = Helper.readString("Enter Your Email > ");
		if (getBidList().size() == 0) {
			System.out.println("There is currently no active bid\n");
		} else {
			for (int i = 0; i < getBidList().size(); i++) {

				if (name.equals(getBidList().get(i).getBuyerEmail()) == true) {
					output(i);
					count = true;
					count2 = true;
				}
			}

			if (count2 == true) {
				String selc = Helper.readString("Enter Bid ID of item you wish to remove > ");
				BidDB.delBid(selc);
				System.out.println("Item removed\n");
			}
			if (count == false) {
				System.out.println("This user does not have a existing bid\n");
			}
		}
	}

	public static void addBid() {
		int count2 = 0;
		String buyerEmail = Helper.readString("Enter Your Email Address > ");

		for (int i = 0; i < getBidList().size(); i++) {
			if (buyerEmail.equals(getBidList().get(i).getBuyerEmail()) == true) {
				count2 = count2 + 1;
			}
		}

		if (count2 >= 3) {
			System.out.println("Your email have reached the max amount(3) of bids per time\n");
		}

		else {
			int counter = 1;
			String change;

			for (int i = 0; i < getBidList().size(); i++) {
				counter = counter + 1;

			}
			change = String.valueOf(counter);
			ques(change, buyerEmail);

		}
	}

	public static void ques(String a, String d) {
		String b = Helper.readString("Enter Item Name > ");
		String c = Helper.readString("Enter Seller Eamil > ");
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
		System.out.println("1: View Bid");
		System.out.println("2: Add Bid");
		System.out.println("3: Remove Bid");
		System.out.println("4: Update Bid");
		System.out.println("5: Cancel Buyer Bid (For Seller)");
		System.out.println("6: Quit");
	}

	public static void addBid(Bid bid) {
		getBidList().add(bid);
	}

	public static void viewAllBid() {

		boolean helpMe = false;

		if (getBidList().size() == 0) {
			System.out.println("There is currently no active bid\n");
		} else {
			System.out.println("\n1: View Bid By Item Name");
			System.out.println("2: View Bid By Seller Email");
			System.out.println("3: View Bid By Your Email");
			System.out.println("4: View All Bid\n");
			int getChoice = Helper.readInt("Enter Your Selection > ");

			if (getChoice == 1) {
				String nameItem = Helper.readString("Enter the Item Name > ");

				for (int i = 0; i < getBidList().size(); i++) {
					if (nameItem.equals(getBidList().get(i).getItemName()) == true) {
						output(i);
						helpMe = true;
					}

				} // ForLoopItemName

			} // Option1

			else if (getChoice == 2) {
				String nameItem = Helper.readString("Enter the Seller Email > ");

				for (int i = 0; i < getBidList().size(); i++) {
					if (nameItem.equals(getBidList().get(i).getSellerEmal()) == true) {
						output(i);
						helpMe = true;
					}
				} // ForLoopItemName

			} // Option2

			else if (getChoice == 3) {
				String nameItem = Helper.readString("Enter Your Email> ");

				for (int i = 0; i < getBidList().size(); i++) {
					if (nameItem.equals(getBidList().get(i).getBuyerEmail()) == true) {
						output(i);
						helpMe = true;
					}

				} // ForLoopItemName

			} // Option3

			else if (getChoice == 4) {

				for (int i = 0; i < getBidList().size(); i++) {
					output(i);
					helpMe = true;
				} // Option4

			} else {
				System.out.println("Invalid Option\n");
			}

			if (helpMe == false) {
				System.out.println("There is no bid related to your search\n");
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
