
public class Bid {

	private String bidID, itemName, sellerEmal, buyerEmail;
	private double bidPrice;
	
	public Bid(String bidID, String itemName, String sellerEmal, String buyerEmail, double bidPrice) {
		super();
		this.bidID = bidID;
		this.itemName = itemName;
		this.sellerEmal = sellerEmal;
		this.buyerEmail = buyerEmail;
		this.bidPrice = bidPrice;
	}

	public String getBidID() {
		return bidID;
	}

	public void setBidID(String bidID) {
		this.bidID = bidID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSellerEmal() {
		return sellerEmal;
	}

	public void setSellerEmal(String sellerEmal) {
		this.sellerEmal = sellerEmal;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	
	@Override
	public String toString() {
		return "Bid [bidID=" + bidID + ", itemName=" + itemName + ", sellerEmal=" + sellerEmal + ", buyerEmail="
				+ buyerEmail + ", bidPrice=" + bidPrice + "]";
	}
	
	
	
	
	
}
