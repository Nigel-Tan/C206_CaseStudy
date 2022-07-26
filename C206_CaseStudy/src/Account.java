
public class Account {
	private String name;
	private String role;
	private String email;
	private String password;
	private String status;
	public Account(String name, String role, String email, String password) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		status = "Active";
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public String getStatus() {
		return status;
	}
	public String display() {
		String output = String.format("%-20s %-10s %-30s %-20s %-10s",name,role,email,password,status);
		return output;
	}
	

	
	

}
