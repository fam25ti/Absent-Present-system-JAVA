
public class User {
	private String name;
	private String family;
	private String username;
	private String password;
	public User(String n, String f, String u, String p) {
		name=n;
		family=f;
		username=u;
		password=p;	}
	public String getName() {
		return name;
	}
	public String getFamily() {
		return family;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

}
