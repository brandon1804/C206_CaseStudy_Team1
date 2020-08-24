import java.util.ArrayList;
//Created by Brandon 24/8/20
public class UserDatabase {

	public static ArrayList<User> userList = new ArrayList<User>();
	
	public static User inputNewUser() {
		String name = Helper.readString("Enter name > ");
		String email = Helper.readString("Enter email > ");
		String role = Helper.readString("Enter role > ");
		String password = Helper.readString("Enter password > ");
		User user = new User(name, email, role, password);
		return user;
	}
	
	
	public static void addUser(User user) {
		userList.add(user);
		System.out.println("User added");
	}
	
	public static String retrieveAllUsers(ArrayList<User> userList) {
		String output = "";
		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%s\n", userList.get(i).toString());
		}
		return output;
	}
	
	public static String viewUsers(ArrayList<User> userList) {
		String output = String.format("%-20s %-20s %-20s %-20s", "NAME", "EMAIL", "ROLE", "PASSWORD");
		output += retrieveAllUsers(userList);	
		return output;
	}
	
	public static void DeleteUser(String email) {		
		 int indexTD = 0;
		 if(userList.size() != 0) {
			 for (int i = 0; i < userList.size(); i++) {
					if(email.equalsIgnoreCase(userList.get(i).getEmail())) {
						indexTD = i;
					}
				}
			 userList.remove(indexTD);
			 System.out.println("User deleted");
		 }
		 else {
			 System.out.println("User Deletion Failed");
		 }
			
				
	}
	
	
	public static void showUserMenu() {
		System.out.println("Option 1: View All Users");
		System.out.println("Option 2: Add a User");
		System.out.println("Option 3: Remove a User");
	}
	

}//end of class
