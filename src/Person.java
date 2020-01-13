import java.io.Serializable;
import java.util.Scanner;

import veranstalter.Aktivitaet;
import veranstalter.Veranstalter;
import veranstalter.VeranstalterService;
import veranstalter.Veranstaltung;

public class Person implements Serializable {

	private static VeranstalterService service = new VeranstalterService();
	static {
		Data.basisVeranstaltung(service);
	}

	public static void main(String[] args) {
		Person person = new Person();
		person.suchen();
	}

//	Attribute

	private String benutzername;
	private String passwort;

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

//	Methoden

//	Mit der folgenden Methode k�nnen Veranstalter, Aktivit�ten und Veranstaltungen gesucht und angezeigt werden.
	public void suchen() {
		// Es werden optionen zur Suche vorgestellt
		System.out.println("Um einen Veranstalter zu suchen, w�hlen Sie 1.");
		System.out.println("Um eine Aktivit�t zu suchen, w�hlen Sie 2.");
		System.out.println("Um eine Veranstaltung zu suchen, w�hlen Sie 3.");
		Scanner scan = new Scanner(System.in);
		int auswahl1 = scan.nextInt();

		if (auswahl1 == 1) {
			// Alle Veranstalter werden angezeigt
			System.out.println("W�hlen Sie einen Veranstalter aus:");
			for (int i = 0; i < service.getVeranstalter().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstalter().get(i).getVeranstalter());
			}
			// Der gew�nschte Veranstalter wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstalter = scan.nextInt();

			// Alle Aktivit�ten des oben gew�nschten Veranstalters werden angezeigt
			Veranstalter veranstalter = service.getVeranstalter().get(auswahlVeranstalter);
			System.out.println("W�hlen Sie eine Aktivit�t aus:");
			for (int i = 0; i < veranstalter.getAktivitaeten().size(); i++) {
				System.out.println(i + " ist " + veranstalter.getAktivitaeten().get(i).getBeschrieb());
			}
			// Die gew�nschte Aktivit�t wird ausgesucht und mit einer Zahl angegeben
			int auswahlAktivitaet = scan.nextInt();

			// Alle Veranstaltungen der oben gew�nschten Aktivit�t werden angezeigt
			Aktivitaet aktivitaet = service.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gew�nschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = scan.nextInt();
			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl:" + "\n" + veranstalter + "\n" + aktivitaet + "\n" + veranstaltung);
			
			
		} else if (auswahl1 == 2) {
			// Alle Aktivit�ten werden angezeigt
			System.out.println("W�hlen Sie eine Aktivit�t aus:");
			for (int i = 0; i < service.getAktivitaet().size(); i++) {
				System.out.println(i + " ist " + service.getAktivitaet().get(i).getBeschrieb());
			}
			// Die gew�nschte Aktivit�t wird ausgesucht und mit einer Zahl angegeben
			int auswahlAktivitaet = scan.nextInt();

			// Alle Veranstaltungen werden angegeben von der obigen Aktivit�t
			Aktivitaet aktivitaet = service.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gew�nschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = scan.nextInt();

			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, Veranstalter: " + aktivitaet.getVeranstalter() + "/nAktivit�t: "
					+ aktivitaet + "/Veranstaltung: " + veranstaltung);

		} else if (auswahl1 == 3) {
			// Alle Veranstaltungen werden angezeigt
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < service.getVeranstaltung().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstaltung().get(i).getDatum());
			}
			// Die gew�nschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = scan.nextInt();

			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, Veranstalter: " + veranstaltung.getAktivitaet().getVeranstalter()
					+ "/nAktivit�t: " + veranstaltung.getAktivitaet() + "/Veranstaltung: " + veranstaltung);
		}
		scan.close();
	}

	
	public void logout() {
		
	}
}