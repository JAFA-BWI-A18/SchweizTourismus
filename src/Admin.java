import java.time.LocalDateTime;
import java.util.Scanner;

import veranstalter.VeranstalterService;

public class Admin extends Person {

	private static VeranstalterService service = new VeranstalterService();
	static {
		Data.basisVeranstaltung(service);
	}

	public static void main(String[] args) {

		System.out.println("Bitte gew�nschte Aktion w�hlen: \n1 Neuen Veranstalter erfassen"
				+ "\n2 Bestehenden Veranstalter bearbeiten" + "\n3 Veranstalter l�schen"
				+ "\n4 Neue Veranstaltung erfassen" + "\n5 Bestehenden Veranstaltung bearbeiten"
				+ "\n6 Veranstaltung l�schen" + "\n7 Neue Aktivit�t erfassen" + "\n8 Bestehende Aktivit�t bearbeiten"
				+ "\n9 Aktivit�t l�schen");
		Scanner scan = new Scanner(System.in);
		String zahl = scan.nextLine().trim();

		switch (zahl) {
		case "1":
			veranstalterErfassenInput();
			break;

		case "4":
			aktErfassenInput();
			break;

		case "7":
			veranstaltungErfassenInput();
			break;

		default:
			System.out.println("Bitte �berpr�fen Sie Ihre Angaben.");
		}
	}

//Neuen Veranstalter erfassen
	private static void veranstalterErfassenInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Veranstalter-Namen erfassen: ");
		String veranstalterName = scan.nextLine().trim();
		System.out.println("Bitte Veranstalter-Beschrieb erfassen: ");
		String veranstalterBeschrieb = scan.nextLine().trim();
		service.veranstalterErfassen(veranstalterStr, beschreibung) ;
	}

	// Neue Aktivit�t erfassen
	private static void aktErfassenInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Veranstalter w�hlen: ");
		for (int i = 0; i < service.getVeranstalter().size(); i++) {
			System.out.println(i + ". " + service.getVeranstalter().get(i).getVeranstalter());
		}
		String aktVeranstalter = scan.nextLine().trim();
		System.out.println("Bitte Aktivit�ts-Beschrieb erfassen: ");
		String aktBeschrieb = scan.nextLine().trim();
		System.out.println("Bitte Aktivit�ts-Art erfassen: ");
		String aktArt = scan.nextLine().trim();
		System.out.println("Bitte Aktivit�ts-Ort erfassen: ");
		String aktOrt = scan.nextLine().trim();
		System.out.println("Bitte Aktivit�ts-PLZ erfassen: ");
		String aktPLZ = scan.nextLine().trim();
	}

	// Neuen Veranstaltung erfassen Vorf�hren
	private static void veranstaltungErfassenInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Aktivit�t w�hlen: ");
		for (int i = 0; i < service.getAktivitaet().size(); i++) {
			System.out.println(i + ". " + service.getAktivitaet().get(i).getBeschrieb());
		}
		int veranstaltungsAktivitaet = scan.nextInt();
		System.out.println("Bitte Veranstaltungs-Datum erfassen: ");
		String veranstaltungsDatum = scan.nextLine().trim();
		System.out.println("Bitte Veranstaltungs-Zeit erfassen: ");
		String veranstaltungsZeit = scan.nextLine().trim();
		System.out.println("Bitte Veranstaltungs-Preis erfassen: ");
		String veranstaltungsPreis = scan.nextLine().trim();
		System.out.println("Bitte Anzahl verf�gbare Pl�tze erfassen: ");
		String veranstaltungsPlaetze = scan.nextLine().trim();
		
		// Neuen Veranstaltung erfassen Code:
		service.veranstaltungErfassen(service.getAktivitaet().get(veranstaltungsAktivitaet), service.getveraveranstaltungsDatum 12.12.2020, 100, 100, offline);

	}

}

//
//	public void veranstalterErfassen(String veranstalter, String beschreibung) {
//		service.veranstalterErfassen(veranstalter, beschreibung);
//	}
//
//	public void veranstalterEditieren(String veranstalter, String beschreibung) {
//	}
//
//	public void veranstalterLoeschen() {
//	}
//
//	public void veranstaltungErfassen(String veranstalter, String beschreibung, String art, String ort, int plz,
//			LocalDateTime datum, double preis, int freiePlaetze, int totalePlaetze) {
//		service.veranstaltungErfassen(veranstalter, beschreibung, art, ort, plz, datum, preis, freiePlaetze,
//				totalePlaetze);
//	}
//
//	public void veranstaltungEditieren(String veranstalter, String beschreibung) {
//	}
//
//	public void veranstaltungLoeschen() {
//	}
//
//	public void aktErfassen(String veranstalter, String beschreibung, String art, String ort, int plz) {
//		service.aktErfassen(veranstalter, beschreibung, art, ort, plz);
//	}
//
//	public void aktEditieren(String veranstalter, String beschreibung, String art, String ort, int plz) {
//	}
//
//	public void aktLoeschen() {
//	}