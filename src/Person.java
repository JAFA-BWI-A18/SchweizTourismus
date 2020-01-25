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
	private boolean exit;
	public Veranstaltung veranstaltung = new Veranstaltung();

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

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

//	Konstruktor
	public Person() {
	}

//	Methoden

	// Mit der folgenden Methode k�nnen Veranstalter, Aktivit�ten und
	// Veranstaltungen gesucht und angezeigt werden.
	public void suchen() {
		Person person = new Person();
		Kunde kunde = new Kunde();
		// Es werden optionen zur Suche vorgestellt
		System.out.println(
				"Um einen Veranstalter zu suchen, w�hlen Sie 1. \nUm eine Aktivit�t zu suchen, w�hlen Sie 2. \nUm eine Veranstaltung zu suchen, w�hlen Sie 3.");
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
			this.veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl:" + "\nVeranstalter: " + veranstalter.getVeranstalter() + "\nAktivit�t: "
					+ aktivitaet.getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());

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

			this.veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, \nVeranstalter: " + aktivitaet.getVeranstalter().getVeranstalter()
					+ "\nAktivit�t: " + aktivitaet.getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());

		} else if (auswahl1 == 3) {
			// Alle Veranstaltungen werden angezeigt
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < service.getVeranstaltung().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstaltung().get(i).getDatum());
			}
			// Die gew�nschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = scan.nextInt();

			this.veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, \nVeranstalter: "
					+ this.veranstaltung.getAktivitaet().getVeranstalter().getVeranstalter() + "\nAktivit�t: "
					+ this.veranstaltung.getAktivitaet().getBeschrieb() + "\nVeranstaltung: "
					+ this.veranstaltung.getDatum());
		} else {
			System.out.println("Ihre Auswahl ist ung�ltig. Die Suche wird erneut gestartet.");
			person.suchen();
		}

		// Wie soll mit den Angaben aus der Suche weitergefahren werden
		System.out.println(
				"Wie wollen Sie weiterfahren: \n1 ist Auswahl buchen \n2 ist eine neue Suche starten");
		int auswahl2 = scan.nextInt();
		switch (auswahl2) {
		// Falls 1 ausgew�hlt wird, wird die Methode Buchen aus der Klasse Kunde
		// eingeleitet
		case 1:
			kunde.buchen(this.veranstaltung);
			break;
		// Falls 2 ausgew�hlt wird, wird eine neue Suche eingeleitet
		case 2:
			person.suchen();
			break;
		default:
			System.out.println("Ihre Auswahl ist ung�ltig.");
		}
	}

	public void logout() {
		System.out.println("Sie sind ausgeloggt.");
	}
}