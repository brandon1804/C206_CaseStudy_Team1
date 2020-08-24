import java.util.ArrayList;

 

public class BidDB {
    
    private static ArrayList<Bid> bidList = new ArrayList<Bid>();
    
    public static void addBid(Bid bid) {
        getBidList().add(bid);
    }
    
    public static void viewAllBid() {
        for (int i =0; i<getBidList().size();i++) {
            System.out.println(String.format("ID: %s\nItem Name: %s\nSeller Email: %s\nBuyer Email: %s\nBid Price: %s\n", bidList.get(i).getBidID(), bidList.get(i).getItemName(), bidList.get(i).getSellerEmal(), bidList.get(i).getBuyerEmail(), bidList.get(i).getBidPrice()));             
        }
    }
    
    public static void delBid(String a) {
        int c = Integer.parseInt(a);
        c = c-1;
        getBidList().remove(c);
    }
    
    public static void showBidMenu() {
        System.out.println("Option 1: View All Bid");
        System.out.println("Option 2: Add Bid");
        System.out.println("Option 3: Remove Bid");
    }

 

    
    

    public static ArrayList<Bid> getBidList() {
        return bidList;
    }

 

    public static void setBidList(ArrayList<Bid> bidList) {
        BidDB.bidList = bidList;
    }
}
 