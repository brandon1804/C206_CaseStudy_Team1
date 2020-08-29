import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//Created by Brandon 24/8/20
public class UserTest {
	
	private User user1;
	private ArrayList<User> userList;


	@Before
	public void setUp() throws Exception {
		user1 = new User("Elijah", "elijah@myrp.edu.sg", "buyer", "123");
		
	}

	@After
	public void tearDown() throws Exception {
		user1 = null;
		UserDatabase.userList.clear();
	}

	@Test
	public void addUserTest() {
				//Test that userList is NOT null - Boundary
				assertNotNull("Test that userList is NOT null", UserDatabase.userList);
				
				//Test that the size of userList is empty before adding any users - Boundary
				assertEquals("Test that the size of userList is empty before adding any users", 0, UserDatabase.userList.size());
				
				//Test that the size of userList is 1 after adding a user - Normal
				UserDatabase.addUser(user1);
				assertEquals("Test that the size of userList is 1 after adding a user", 1, UserDatabase.userList.size());
				
				//Test that the first element in userList is the same as what was added - Normal
				assertSame("Test that the first element in userList is the same as what was added", user1, UserDatabase.userList.get(0));
		
	}
	
	@Test
	public void viewUsersTest() {
				// Test if user list is not null but empty - Boundary
				assertNotNull("Test if there is a valid userList to retrieve users from", UserDatabase.userList);
				
				//Test if the list of users retrieved from the UserDatabase is empty - Boundary
				String allUsers = UserDatabase.retrieveAllUsers(UserDatabase.userList);
				String testOutput = "";
				assertEquals("Test that the retrieved userList is empty", testOutput, allUsers);
				
				//Given an empty list, after adding 1 item, test if the size of the list is 1 - Normal
				UserDatabase.addUser(user1);	
				assertEquals("Test that userList's size is 1", 1, UserDatabase.userList.size());
				
				//Test if the expected output is the same as the list of users retrieved from the UserDatabase	- Normal
				allUsers = UserDatabase.retrieveAllUsers(UserDatabase.userList);
				testOutput = String.format("%-20s %-20s %-20s %-20s\n","Elijah", "elijah@myrp.edu.sg","buyer","123");
				assertEquals("Test if the expected output is the same as the list of users retrieved from the UserDatabase",testOutput, allUsers);
	}
	
	@Test
	public void deleteUserTest() {
				// Test if user list is not null but empty - Boundary
				assertNotNull("Test if there is a valid userList to retrieve users from", UserDatabase.userList);
				
				//Test if the list of users retrieved from the UserDatabase is empty - Boundary
				String allUsers = UserDatabase.retrieveAllUsers(UserDatabase.userList);
				String testOutput = "";
				assertEquals("Test that the retrieved userList is empty", testOutput, allUsers);
				
				//Given an empty list, after adding 1 item, test if the size of the list is 1 - Normal
				UserDatabase.addUser(user1);	
				assertEquals("Test that userList's size is 1", 1, UserDatabase.userList.size());
				
				//Test if the size of the list is 0 after user deletion - Normal
				UserDatabase.userList.remove(user1);	
				assertEquals("Test that userList's size is 0", 0, UserDatabase.userList.size());
				
	}
	
	//Created by Brandon on 27/8/20	For Sprint 2 
	@Test
	public void searchUserTest() {
				// Test if there is a valid user list - Boundary
				assertNotNull("Test if there is a valid userList to retrieve users from", UserDatabase.userList);
				UserDatabase.addUser(user1);
				
				
				//Test if the expected output retrieves and displays the correct output	- Normal
				String email = "elijah@myrp.edu.sg";
				String testOutput = "User account found";
				assertEquals("Test if the expected output retrieves and displays the correct output", testOutput, UserDatabase.searchUser(UserDatabase.userList, email));
				
				//Test if the system displays the correct output when the user enters an invalid email - Error
				email = "e@myrp.edu.sg";
				testOutput = "User account does not exist";
				assertEquals("Test if the expected output retrieves and displays the correct output", testOutput, UserDatabase.searchUser(UserDatabase.userList, email));
				
	}
	
	//Created by Brandon on 28/8/20	For Sprint 2 
	@Test
	public void doUpdateUserAccountTest() {
				// Test if there is a valid user list - Boundary
			    assertNotNull("Test if there is a valid userList to retrieve users from", UserDatabase.userList);
			    UserDatabase.addUser(user1);	
			    
			    // Test if the system updates the user's information - Normal
			    String uname = "Elijah";
			    String name = "E";
				String password = "1";
				Boolean update = UserDatabase.doUpdateUserAccount(UserDatabase.userList, uname, name, password);
				String testOutput = String.format("%-20s %-20s %-20s %-20s\n","E", "elijah@myrp.edu.sg","buyer","1");
				String userInfo = UserDatabase.retrieveAllUsers(UserDatabase.userList);
				assertEquals("Test if the system updates the user's information", testOutput, userInfo);
				
				// Test if the system disallows updates if the user is not found - Error
				uname = "A";
				name = "E";
				password = "1";
				update = UserDatabase.doUpdateUserAccount(UserDatabase.userList, uname, name, password);
				assertFalse("Test if the system disallows updates if the user is not found", update);	
						
	}
	
		
		
	//Created by Brandon on 28/8/20	For Sprint 2 
	@Test
	public void doUserLoginTest() {
				// Test if there is a valid user list  - Boundary
				assertNotNull("Test if there is a valid userList to retrieve users from", UserDatabase.userList);
				UserDatabase.addUser(user1);	
					
				// Test if the system recognises the user - Normal
				String name = "Elijah";
				String password = "123";
				Boolean found = UserDatabase.doUserLogin(UserDatabase.userList, name, password);
				assertTrue("Test if the system recognises the user", found);
				
				// Test if the system rejects unauthorised user - Error
				name = "E";
			    password = "1";
				found = UserDatabase.doUserLogin(UserDatabase.userList, name, password);
				assertFalse("Test if the system rejects unauthorised users", found);
	}
		
		
	
	
	


}//end of class
