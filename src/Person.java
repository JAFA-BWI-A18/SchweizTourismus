import java.io.Serializable;
import java.util.Scanner;

import veranstalter.VeranstalterService;

public class Person implements Serializable {

//	Attribute

	private String benutzername;
	private String passwort;
	private VeranstalterService service;

//	Getters und Setter erstellt

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

//	Konstruktor
	public Person() {
		// TODO Auto-generated constructor stub
	}

//	Methoden Person

	public void suchen() {
		System.out.println("Um einen Veranstalter zu suchen, w�hlen Sie 1.");
		System.out.println("Um eine Aktivit�t zu suchen, w�hlen Sie 2.");
		System.out.println("Um eine Veranstaltung zu suchen, w�hlen Sie 3.");
		Scanner scan = new Scanner(System.in);
		int auswahl1 = scan.nextInt();

		if (auswahl1 == 1) {
			System.out.println("W�hlen Sie einen Veranstalter aus:");
			for (int i = 0; i < service.getVeranstalter().size(); i++) {
				System.out.println(i +". "+service.getVeranstalter().get(i).getVeranstalter());
			}
			
		} else if (auswahl1 == 2) {
			System.out.println(service.getAktivitaet());
			System.out.println("W�hlen Sie eine Aktivit�t aus:");
			
		} else if (auswahl1 == 3) {
			System.out.println(service.getVeranstaltung());
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			
		}
	}

}