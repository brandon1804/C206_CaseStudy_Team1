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
	
	public static void deleteUser(String email) {		
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
	
	//Created by Brandon on 27/8/20	For Sprint 2 
		public static String inputUserEmail() {
			String email = Helper.readString("Enter email > ");
			return email;
		}//end of inputUserEmail method
	
	
	//Created by Brandon on 27/8/20	For Sprint 2 
	public static String searchUser(ArrayList<User> userList, String email) {
		boolean isFound = false;
		String message = "";
		if(userList.size() != 0) {
			 for (int i = 0; i < userList.size(); i++) {
					if(email.equalsIgnoreCase(userList.get(i).getEmail())) {
						isFound = true;
					}
				}	
		 }//end of if
		
		if(isFound == true) {
			message = "User account found"; 
		 }
		else {
			 message = "User account does not exist";
		 }
		System.out.println(message);
		return message;
		
		
	}//end of searchUser method
	
	//Created by Brandon on 28/8/20	For Sprint 2 
		public static boolean doUpdateUserAccount(ArrayList<User> userList, String uname, String name, String password) {
			boolean isUpdated = false;	
			if(userList.size() != 0) {
				 for (int i = 0; i < userList.size(); i++) {
						if(uname.equalsIgnoreCase(userList.get(i).getName())) {
							userList.get(i).setName(name);
							userList.get(i).setPassword(password);
							isUpdated = true;
						}
					}
			 }//end of if
			return isUpdated;
		}//end of doUpdateUserAccount method
		
		
		//Created by Brandon on 28/8/20	For Sprint 2 
			public static void updateUserAccount(ArrayList<User> userList) {
				String uname = Helper.readString("Enter name to update > ");
				String name = Helper.readString("Enter new name > ");
				String password = Helper.readString("Enter new password > ");
				boolean isUpdated = doUpdateUserAccount(userList, uname, name, password);
				if(isUpdated == true) {
					 Helper.line(80, "-");
					 System.out.println("Update Successful"); 
				 }
				 else {
					 System.out.println("Update Failed. User does not exist. Please try again.");
					 Helper.line(80, "-");
					 UserDatabase.updateUserAccount(userList);
				 }
						
			}//end of updateUserAccount method
	
	//Created by Brandon on 27/8/20	For Sprint 2 
	public static void userLogin(ArrayList<User> userList){
		Helper.line(80, "-");
		System.out.println("User Login");
		Helper.line(80, "-");
		String name = Helper.readString("Enter name > ");
		String password = Helper.readString("Enter password > ");
		Boolean isFound = doUserLogin(userList, name, password);
		
		if(isFound == true) {
			 System.out.println("Login Successful"); 
			 Helper.line(80, "-");
		 }
		 else {
			 System.out.println("Login Failed. Please try again.");
			 UserDatabase.userLogin(userList);
		 }
	}//end of userLogin method
	
	
	public static boolean doUserLogin(ArrayList<User> userList, String name, String password){
		boolean isFound = false;
		if(userList.size() != 0) {
			 for (int i = 0; i < userList.size(); i++) {
					if(name.equalsIgnoreCase(userList.get(i).getName()) && password.equalsIgnoreCase(userList.get(i).getPassword())) {
						isFound = true;
					}
				}	
		 }//end of if	
		return isFound;
	}

		
	public static void showUserMenu() {
		System.out.println("Option 1: View All Users");
		System.out.println("Option 2: Add a User");
		System.out.println("Option 3: Remove a User");
	}
	

}//end of class
