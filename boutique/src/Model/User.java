package Model;

public class User {
	private int id; 
	private String email; 
	private String name;
	private String lastname;
	private String username ; 
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int id, String email, String name, String lastname, String username, String password) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}
	public User(int id, String email, String name, String lastname, String username) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.lastname = lastname;
		this.username = username;
	}
	public User() {
		super();
	
	}
}
