import java.io.Serializable;

public class Person implements Serializable {

	private String benutzername;
	private String passwort;

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

}