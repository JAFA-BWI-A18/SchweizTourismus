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

//	Mit der folgenden Methode können Veranstalter, Aktivitäten und Veranstaltungen gesucht und angezeigt werden.
	public void suchen() {
		// Es werden optionen zur Suche vorgestellt
		System.out.println("Um einen Veranstalter zu suchen, wählen Sie 1.");
		System.out.println("Um eine Aktivität zu suchen, wählen Sie 2.");
		System.out.println("Um eine Veranstaltung zu suchen, wählen Sie 3.");
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
			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl:" + "\n" + veranstalter + "\n" + aktivitaet + "\n" + veranstaltung);
			
			
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

			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, Veranstalter: " + aktivitaet.getVeranstalter() + "/nAktivität: "
					+ aktivitaet + "/Veranstaltung: " + veranstaltung);

		} else if (auswahl1 == 3) {
			// Alle Veranstaltungen werden angezeigt
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < service.getVeranstaltung().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstaltung().get(i).getDatum());
			}
			// Die gewünschte Veranstaltung wird ausgesucht und mit einer Zahl angegeben
			int auswahlVeranstaltung = scan.nextInt();

			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, Veranstalter: " + veranstaltung.getAktivitaet().getVeranstalter()
					+ "/nAktivität: " + veranstaltung.getAktivitaet() + "/Veranstaltung: " + veranstaltung);
		}
		scan.close();
	}

	
	public void logout() {
		
	}
}