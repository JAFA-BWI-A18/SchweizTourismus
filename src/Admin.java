import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import veranstalter.Aktivitaet;
import veranstalter.Veranstalter;
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
		veranstalterErfassen(veranstalterName, veranstalterBeschrieb);
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
		int aktPLZ = Integer.valueOf(scan.nextLine().trim());
		aktErfassen(veranstalter, aktBeschrieb, aktArt, aktOrt, aktPLZ);
	}
//TODO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Veranstalter erfassen analog aktivit�t unten

	// Neuen Veranstaltung erfassen Vorf�hren
	private static void veranstaltungErfassenInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Aktivit�t w�hlen: ");
		for (int i = 0; i < service.getAktivitaet().size(); i++) {
			System.out.println(i + ". " + service.getAktivitaet().get(i).getVeranstalter().getVeranstalter() + " - "
					+ service.getAktivitaet().get(i).getBeschrieb());
		}
		int veranstaltungsAktivitaet = Integer.valueOf(scan.nextLine().trim());
		System.out.println("Bitte Veranstaltungs-Datum erfassen (Format: DD.MM.YYYY): ");
		String veranstaltungsDatum = scan.nextLine().trim();
		System.out.println("Bitte Veranstaltungs-Zeit erfassen (Format; HH:MM): ");
		String veranstaltungsZeit = scan.nextLine().trim();
		System.out.println("Bitte Veranstaltungs-Preis erfassen: ");
		double veranstaltungsPreis = Double.valueOf(scan.nextLine().trim());
		System.out.println("Bitte Anzahl verf�gbare Pl�tze erfassen: ");
		int veranstaltungsPlaetze = Integer.valueOf(scan.nextLine().trim());

		LocalDateTime datum = LocalDateTime.parse(veranstaltungsDatum + " " + veranstaltungsZeit,
				DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm"));

		// Neuen Veranstaltung erfassen Code:
		veranstaltungErfassen(service.getAktivitaet().get(veranstaltungsAktivitaet), datum, veranstaltungsPreis,
				veranstaltungsPlaetze);
//TODO>>>>>>>>>>>>analog f�r Veranstalter
		service.getVeranstaltung().stream().forEach(v -> System.out.println(v.toString()));

	}

	public static void veranstalterErfassen(String veranstalter, String beschreibung) {
		service.veranstalterErfassen(veranstalter, beschreibung);
	}

	public void veranstalterEditieren(String veranstalter, String beschreibung) {
	}

	public void veranstalterLoeschen() {
	}

	public static void veranstaltungErfassen(Aktivitaet a, LocalDateTime datum, double preis, int totalePlaetze) {
		service.veranstaltungErfassen(a, datum, preis, totalePlaetze);
	}

	//TODO:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kontrolle Paraamter
	public void veranstaltungEditieren(String veranstalter, String beschreibung) {
	}

	public void veranstaltungLoeschen() {
	}

//TODO: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kontrolle Paraamter
	public static void aktErfassen(Veranstalter veranstalter, String beschrieb, String art, String ort, int plz) {
		service.aktivitaetErfassen(veranstalter, art, ort, plz, beschrieb);
	}

//>TODO: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kontrolle Paraamte
	public void aktEditieren(String veranstalter, String beschreibung, String art, String ort, int plz) {
	}

	public void aktLoeschen() {
	}

}