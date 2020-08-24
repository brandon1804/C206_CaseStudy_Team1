//Created by Brandon 24/8/20
public class User {
	
	private String name;
	private String email;
	private String role;
	private String password;
	
	public User(String name, String email, String role, String password) {
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		String output = String.format("%-20s %-20s %-20s %-20s", name, email, role, password);
		return output;
	}

	
	
	
	
}//end of class
