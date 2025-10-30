package abitur;

public class Person {
	private String name;
	private String nachname;
	private String email;
	
	public Person(String pName, String pNachname, String pEmail) {
		name = pName;
		nachname = pNachname;
		email = pEmail;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public String getEmail() {
		return email;
	}

}
