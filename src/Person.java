import java.io.Serializable;

public class Person implements Serializable {
//das ist ein Test-Kommentar von Annika
	private String vorname;
	private String nachname;

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

}