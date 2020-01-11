import java.io.Serializable;
import java.util.Scanner;

import veranstalter.Aktivitaet;
import veranstalter.Veranstalter;
import veranstalter.VeranstalterService;
import veranstalter.Veranstaltung;

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
		System.out.println("Um einen Veranstalter zu suchen, wählen Sie 1.");
		System.out.println("Um eine Aktivität zu suchen, wählen Sie 2.");
		System.out.println("Um eine Veranstaltung zu suchen, wählen Sie 3.");
		Scanner scan = new Scanner(System.in);
		int auswahl1 = scan.nextInt();
		scan.close();

		if (auswahl1 == 1) {
			// Alle Veranstalter werden angegeben
			System.out.println("Wählen Sie einen Veranstalter aus:");
			for (int i = 0; i < service.getVeranstalter().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstalter().get(i).getVeranstalter());
			}
			// Der gewünschte Veranstalter wird angegeben
			Scanner scan2 = new Scanner(System.in);
			int auswahlVeranstalter = scan.nextInt();
			scan2.close();
			// Alle Aktivitäten des oben gewünschten Veranstalters werden angegeben
			Veranstalter veranstalter = service.getVeranstalter().get(auswahlVeranstalter);
			System.out.println("Wählen Sie eine Aktivität aus:");
			for (int i = 0; i < veranstalter.getAktivitaeten().size(); i++) {
				System.out.println(i + " ist " + veranstalter.getAktivitaeten().get(i).getBeschrieb());
			}
			// Die gewünschte Aktivität wird angegeben
			Scanner scan3 = new Scanner(System.in);
			int auswahlAktivitaet = scan.nextInt();
			scan3.close();
			// Alle Veranstaltungen der oben gewünschten Aktivität werden angegeben
			Aktivitaet aktivitaet = service.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gewünschte Veranstaltung wird angegeben
			Scanner scan4 = new Scanner(System.in);
			int auswahlVeranstaltung = scan.nextInt();
			scan4.close();
			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gewählten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, Veranstalter: " + veranstalter + "/nAktivität: " + aktivitaet
					+ "/Veranstaltung: " + veranstaltung);

		} else if (auswahl1 == 2) {
			// Alle Aktivitäten werden ausgegeben
			System.out.println("Wählen Sie eine Aktivität aus:");
			for (int i = 0; i < service.getAktivitaet().size(); i++) {
				System.out.println(i + " ist " + service.getAktivitaet().get(i).getBeschrieb());
			}
			// Die gewünschte Aktivität kann gewählt werden
			Scanner scan5 = new Scanner(System.in);
			int auswahlAktivitaet = scan.nextInt();
			scan5.close();
			// Alle Veranstaltungen werden angegeben von der obigen Aktivität
			Aktivitaet aktivitaet = service.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			Scanner scan6 = new Scanner(System.in);
			int auswahlVeranstaltung = scan.nextInt();
			scan6.close();
			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			System.out.println("Ihre Auswahl, Veranstalter: " + aktivitaet.getVeranstalter() + "/nAktivität: "
					+ aktivitaet + "/Veranstaltung: " + veranstaltung);

		} else if (auswahl1 == 3) {
			System.out.println("Wählen Sie eine Veranstaltung aus:");
			for (int i = 0; i < service.getVeranstaltung().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstaltung().get(i).getDatum());
			}
			Scanner scan7 = new Scanner(System.in);
			int auswahlVeranstaltung = scan.nextInt();
			scan7.close();
			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			System.out.println("Ihre Auswahl, Veranstalter: " + veranstaltung.getAktivitaet().getVeranstalter()
					+ "/nAktivität: " + veranstaltung.getAktivitaet() + "/Veranstaltung: " + veranstaltung);
		}
	}

}