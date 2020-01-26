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

	// Mit der folgenden Methode können Veranstalter, Aktivitäten und
	// Veranstaltungen gesucht und angezeigt werden.
	public Veranstaltung suchen() {
		Data data = Data.getInstance();
		Scanner scan = new Scanner(System.in);
		Veranstaltung veranstaltung = null;
		// Es werden optionen zur Suche vorgestellt
		System.out.println(
				"Um einen Veranstalter zu suchen, wählen Sie 1. \nUm eine Aktivität zu suchen, wählen Sie 2. \nUm eine Veranstaltung zu suchen, wählen Sie 3.");
		int auswahl1 = Integer.valueOf(scan.next().trim());

		if (auswahl1 == 1) {
			// Alle Veranstalter werden angezeigt
			System.out.println("Wählen Sie einen Veranstalter aus:");
			for (int i = 0; i < data.getVeranstalter().size(); i++) {
				System.out.println(i + " ist " + data.getVeranstalter().get(i).getVeranstalter());
			}
			// Der gewünschte Veranstalter wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstalter = Integer.valueOf(scan.next().trim());
			;

			// Alle Aktivitäten des oben gewünschten Veranstalters werden angezeigt
			Veranstalter veranstalter = data.getVeranstalter().get(auswahlVeranstalter);
			System.out.println("Wählen Sie eine Aktivität aus:");
			for (int i = 0; i < veranstalter.getAktivitaeten().size(); i++) {
				System.out.println(i + " ist " + veranstalter.getAktivitaeten().get(i).getBeschrieb());
			}
			// Die gewünschte Aktivität wird ausgesucht und mit einer Zahl angegeben
			int auswahlAktivitaet = Integer.valueOf(scan.next().trim());

			// Alle Veranstaltungen der oben gewünschten Aktivität werden angezeigt
			Aktivitaet aktivitaet = veranstalter.getAktivitaeten().get(auswahlAktivitaet);
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gewünschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = Integer.valueOf(scan.next().trim());
			veranstaltung = aktivitaet.getVeranstaltungen().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl:" + "\nVeranstalter: " + veranstalter.getVeranstalter() + "\nAktivität: "
					+ aktivitaet.getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());

		} else if (auswahl1 == 2) {
			// Alle Aktivitäten werden angezeigt
			System.out.println("Wählen Sie eine Aktivität aus:");
			for (int i = 0; i < data.getAktivitaet().size(); i++) {
				System.out.println(i + " ist " + data.getAktivitaet().get(i).getBeschrieb());
			}
			// Die gewünschte Aktivität wird ausgesucht und mit einer Zahl angegeben
			int auswahlAktivitaet = Integer.valueOf(scan.next().trim());

			// Alle Veranstaltungen werden angegeben von der obigen Aktivität
			Aktivitaet aktivitaet = data.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gewünschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = Integer.valueOf(scan.next().trim());
			veranstaltung = aktivitaet.getVeranstaltungen().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, \nVeranstalter: " + aktivitaet.getVeranstalter().getVeranstalter()
					+ "\nAktivität: " + aktivitaet.getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());

		} else if (auswahl1 == 3) {
			// Alle Veranstaltungen werden angezeigt
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < data.getVeranstaltung().size(); i++) {
				System.out.println(i + " ist " + data.getVeranstaltung().get(i).getDatum());
			}
			// Die gewünschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = Integer.valueOf(scan.next().trim());

			veranstaltung = data.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, \nVeranstalter: "
					+ veranstaltung.getAktivitaet().getVeranstalter().getVeranstalter() + "\nAktivität: "
					+ veranstaltung.getAktivitaet().getBeschrieb() + "\nVeranstaltung: " + veranstaltung.getDatum());
		} else {
			System.out.println("Ihre Auswahl ist ungültig. Die Suche wird erneut gestartet.");
		}
		return veranstaltung;
	}

	public void logout() {
		System.out.println("Sie sind ausgeloggt.");
	}
}