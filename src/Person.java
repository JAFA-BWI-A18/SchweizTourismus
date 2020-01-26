import java.util.Scanner;

public class Person {

//	Attribute

	private String benutzername;
	private String passwort;
	private boolean exit;

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
	public Veranstaltung suchen() {
		Data data = Data.getInstance();
		Scanner scan = new Scanner(System.in);
		Veranstaltung veranstaltung = null;
		// Es werden optionen zur Suche vorgestellt
		System.out.println(
				"Um einen Veranstalter zu suchen, w�hlen Sie 1. \nUm eine Aktivit�t zu suchen, w�hlen Sie 2. \nUm eine Veranstaltung zu suchen, w�hlen Sie 3.");
		int auswahl1 = Integer.valueOf(scan.next().trim());

		if (auswahl1 == 1) {
			// Alle Veranstalter werden angezeigt
			System.out.println("W�hlen Sie einen Veranstalter aus:");
			for (int i = 0; i < data.getVeranstalter().size(); i++) {
				System.out.println(i + " ist " + data.getVeranstalter().get(i).getVeranstalter());
			}
			// Der gew�nschte Veranstalter wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstalter = Integer.valueOf(scan.next().trim());
			;

			// Alle Aktivit�ten des oben gew�nschten Veranstalters werden angezeigt
			Veranstalter veranstalter = data.getVeranstalter().get(auswahlVeranstalter);
			System.out.println("W�hlen Sie eine Aktivit�t aus:");
			for (int i = 0; i < veranstalter.getAktivitaeten().size(); i++) {
				System.out.println(i + " ist " + veranstalter.getAktivitaeten().get(i).getBeschrieb());
			}
			// Die gew�nschte Aktivit�t wird ausgesucht und mit einer Zahl angegeben
			int auswahlAktivitaet = Integer.valueOf(scan.next().trim());

			// Alle Veranstaltungen der oben gew�nschten Aktivit�t werden angezeigt
			Aktivitaet aktivitaet = veranstalter.getAktivitaeten().get(auswahlAktivitaet);
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gew�nschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = Integer.valueOf(scan.next().trim());
			veranstaltung = aktivitaet.getVeranstaltungen().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl:" + "\nVeranstalter: " + veranstalter.getVeranstalter() + "\nAktivit�t: "
					+ aktivitaet.getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());

		} else if (auswahl1 == 2) {
			// Alle Aktivit�ten werden angezeigt
			System.out.println("W�hlen Sie eine Aktivit�t aus:");
			for (int i = 0; i < data.getAktivitaet().size(); i++) {
				System.out.println(i + " ist " + data.getAktivitaet().get(i).getBeschrieb());
			}
			// Die gew�nschte Aktivit�t wird ausgesucht und mit einer Zahl angegeben
			int auswahlAktivitaet = Integer.valueOf(scan.next().trim());

			// Alle Veranstaltungen werden angegeben von der obigen Aktivit�t
			Aktivitaet aktivitaet = data.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gew�nschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = Integer.valueOf(scan.next().trim());
			veranstaltung = aktivitaet.getVeranstaltungen().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, \nVeranstalter: " + aktivitaet.getVeranstalter().getVeranstalter()
					+ "\nAktivit�t: " + aktivitaet.getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());

		} else if (auswahl1 == 3) {
			// Alle Veranstaltungen werden angezeigt
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < data.getVeranstaltung().size(); i++) {
				System.out.println(i + " ist " + data.getVeranstaltung().get(i).getDatum());
			}
			// Die gew�nschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = Integer.valueOf(scan.next().trim());

			veranstaltung = data.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, \nVeranstalter: "
					+ veranstaltung.getAktivitaet().getVeranstalter().getVeranstalter() + "\nAktivit�t: "
					+ veranstaltung.getAktivitaet().getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());
		} else {
			System.out.println("Ihre Auswahl ist ung�ltig. Die Suche wird erneut gestartet.");
		}
		return veranstaltung;
	}

	public void logout() {
		System.out.println("Sie sind ausgeloggt.");
	}
}