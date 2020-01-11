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

//	Methoden Person

	public void suchen() {
		System.out.println("Um einen Veranstalter zu suchen, w�hlen Sie 1.");
		System.out.println("Um eine Aktivit�t zu suchen, w�hlen Sie 2.");
		System.out.println("Um eine Veranstaltung zu suchen, w�hlen Sie 3.");
		Scanner scan = new Scanner(System.in);
		int auswahl1 = scan.nextInt();

		if (auswahl1 == 1) {
			// Alle Veranstalter werden angegeben
			System.out.println("W�hlen Sie einen Veranstalter aus:");
			for (int i = 0; i < service.getVeranstalter().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstalter().get(i).getVeranstalter());
			}
			// Der gew�nschte Veranstalter wird angegeben
			Scanner scan1 = new Scanner(System.in);
			int auswahlVeranstalter = scan.nextInt();
			
			// Alle Aktivit�ten des oben gew�nschten Veranstalters werden angegeben
			Veranstalter veranstalter = service.getVeranstalter().get(auswahlVeranstalter);
			System.out.println("W�hlen Sie eine Aktivit�t aus:");
			for (int i = 0; i < veranstalter.getAktivitaeten().size(); i++) {
				System.out.println(i + " ist " + veranstalter.getAktivitaeten().get(i).getBeschrieb());
			}
			// Die gew�nschte Aktivit�t wird angegeben
			Scanner scan3 = new Scanner(System.in);
			int auswahlAktivitaet = scan.nextInt();
			
			// Alle Veranstaltungen der oben gew�nschten Aktivit�t werden angegeben
			Aktivitaet aktivitaet = service.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			// Die gew�nschte Veranstaltung wird angegeben
			Scanner scan4 = new Scanner(System.in);
			int auswahlVeranstaltung = scan.nextInt();
			
			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			// Die gew�hlten Optionen werden ausgegeben
			System.out.println("Ihre Auswahl, Veranstalter: " + veranstalter + "/nAktivit�t: " + aktivitaet
					+ "/Veranstaltung: " + veranstaltung);

		} else if (auswahl1 == 2) {
			// Alle Aktivit�ten werden ausgegeben
			System.out.println("W�hlen Sie eine Aktivit�t aus:");
			for (int i = 0; i < service.getAktivitaet().size(); i++) {
				System.out.println(i + " ist " + service.getAktivitaet().get(i).getBeschrieb());
			}
			// Die gew�nschte Aktivit�t kann gew�hlt werden
			Scanner scan5 = new Scanner(System.in);
			int auswahlAktivitaet = scan.nextInt();
			
			// Alle Veranstaltungen werden angegeben von der obigen Aktivit�t
			Aktivitaet aktivitaet = service.getAktivitaet().get(auswahlAktivitaet);
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < aktivitaet.getVeranstaltungen().size(); i++) {
				System.out.println(i + " ist " + aktivitaet.getVeranstaltungen().get(i).getDatum());
			}
			Scanner scan6 = new Scanner(System.in);
			int auswahlVeranstaltung = scan.nextInt();
			
			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			System.out.println("Ihre Auswahl, Veranstalter: " + aktivitaet.getVeranstalter() + "/nAktivit�t: "
					+ aktivitaet + "/Veranstaltung: " + veranstaltung);

		} else if (auswahl1 == 3) {
			System.out.println("W�hlen Sie eine Veranstaltung aus:");
			for (int i = 0; i < service.getVeranstaltung().size(); i++) {
				System.out.println(i + " ist " + service.getVeranstaltung().get(i).getDatum());
			}
			Scanner scan7 = new Scanner(System.in);
			int auswahlVeranstaltung = scan.nextInt();
			
			Veranstaltung veranstaltung = service.getVeranstaltung().get(auswahlVeranstaltung);

			System.out.println("Ihre Auswahl, Veranstalter: " + veranstaltung.getAktivitaet().getVeranstalter()
					+ "/nAktivit�t: " + veranstaltung.getAktivitaet() + "/Veranstaltung: " + veranstaltung);
		}
	}

}