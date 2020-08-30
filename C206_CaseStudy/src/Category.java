// created by Yuhan at 24/8/2020


public class Category {

	private String name;

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		String output = String.format("%-25s\n",  "CATEGORY NAME");
		return output;
	}
	
	

}//end of class
