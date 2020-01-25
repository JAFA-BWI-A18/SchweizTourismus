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

	// Mit der folgenden Methode können Veranstalter, Aktivitäten und
	// Veranstaltungen gesucht und angezeigt werden.
	public void suchen() {
		Person person = new Person();
		Kunde kunde = new Kunde();
		// Es werden optionen zur Suche vorgestellt
		System.out.println(
				"Um einen Veranstalter zu suchen, wählen Sie 1. \nUm eine Aktivität zu suchen, wählen Sie 2. \nUm eine Veranstaltung zu suchen, wählen Sie 3.");
		Scanner scan = new Scanner(System.in);
		int auswahl1 = scan.nextInt();

		if (auswahl1 == 1) {
			// Alle Veranstalter werden angezeigt
			System.out.println("Wählen Sie einen Veranstalter aus:");
			for (int i = 0; i < service.getVeranstalter().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstalter().get(i).getVeranstalter());
			}
			// Der gewünschte Veranstalter wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstalter = scan.nextInt();

			// Alle Aktivitäten des oben gewünschten Veranstalters werden angezeigt
			Veranstalter veranstalter = service.getVeranstalter().get(auswahlVeranstalter);
			System.out.println("Wählen Sie eine Aktivität aus:");
			for (int i = 0; i < veranstalter.getAktivitaeten().size(); i++) {
				System.out.println(i + " ist " + veranstalter.getAktivitaeten().get(i).getBeschrieb());
			}
			// Die gewünschte Aktivität wird ausgesucht und mit einer Zahl angegeben
			int auswahlAktivitaet = scan.nextInt();

			// Alle Veranstaltungen der oben gewünschten Aktivität werden angezeigt
			Aktivitaet aktivitaet = service.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gewünschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = scan.nextInt();
			this.veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl:" + "\nVeranstalter: " + veranstalter.getVeranstalter() + "\nAktivität: "
					+ aktivitaet.getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());

		} else if (auswahl1 == 2) {
			// Alle Aktivitäten werden angezeigt
			System.out.println("Wählen Sie eine Aktivität aus:");
			for (int i = 0; i < service.getAktivitaet().size(); i++) {
				System.out.println(i + " ist " + service.getAktivitaet().get(i).getBeschrieb());
			}
			// Die gewünschte Aktivität wird ausgesucht und mit einer Zahl angegeben
			int auswahlAktivitaet = scan.nextInt();

			// Alle Veranstaltungen werden angegeben von der obigen Aktivität
			Aktivitaet aktivitaet = service.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gewünschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = scan.nextInt();

			this.veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, \nVeranstalter: " + aktivitaet.getVeranstalter().getVeranstalter()
					+ "\nAktivität: " + aktivitaet.getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());

		} else if (auswahl1 == 3) {
			// Alle Veranstaltungen werden angezeigt
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < service.getVeranstaltung().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstaltung().get(i).getDatum());
			}
			// Die gewünschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = scan.nextInt();

			this.veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, \nVeranstalter: "
					+ this.veranstaltung.getAktivitaet().getVeranstalter().getVeranstalter() + "\nAktivität: "
					+ this.veranstaltung.getAktivitaet().getBeschrieb() + "\nVeranstaltung: "
					+ this.veranstaltung.getDatum());
		} else {
			System.out.println("Ihre Auswahl ist ungültig. Die Suche wird erneut gestartet.");
			person.suchen();
		}

		// Wie soll mit den Angaben aus der Suche weitergefahren werden
		System.out.println(
				"Wie wollen Sie weiterfahren: \n1 ist Auswahl buchen \n2 ist eine neue Suche starten");
		int auswahl2 = scan.nextInt();
		switch (auswahl2) {
		// Falls 1 ausgewählt wird, wird die Methode Buchen aus der Klasse Kunde
		// eingeleitet
		case 1:
			kunde.buchen(this.veranstaltung);
			break;
		// Falls 2 ausgewählt wird, wird eine neue Suche eingeleitet
		case 2:
			person.suchen();
			break;
		default:
			System.out.println("Ihre Auswahl ist ungültig.");
		}
	}

	public void logout() {
		System.out.println("Sie sind ausgeloggt.");
	}
}