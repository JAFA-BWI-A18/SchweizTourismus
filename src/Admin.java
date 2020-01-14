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

		System.out.println("Bitte gewünschte Aktion wählen: \n1 Neuen Veranstalter erfassen"
				+ "\n2 Bestehenden Veranstalter bearbeiten" + "\n3 Veranstalter löschen"
				+ "\n4 Neue Veranstaltung erfassen" + "\n5 Bestehenden Veranstaltung bearbeiten"
				+ "\n6 Veranstaltung löschen" + "\n7 Neue Aktivität erfassen" + "\n8 Bestehende Aktivität bearbeiten"
				+ "\n9 Aktivität löschen");
		Scanner scan = new Scanner(System.in);
		String zahl = scan.nextLine().trim();

		switch (zahl) {
		case "1":
			veranstalterErfassenInput();
			break;

		case "4":
			aktivitaetErfassenInput();
			break;

		case "7":
			veranstaltungErfassenInput();
			break;

		default:
			System.out.println("Bitte überprüfen Sie Ihre Angaben.");
		}
	}

	// Neuen Veranstalter erfassen Vorführen
	private static void veranstalterErfassenInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Veranstalter-Namen erfassen: ");
		String veranstalterName = scan.nextLine().trim();
		System.out.println("Bitte Veranstalter-Beschrieb erfassen: ");
		String veranstalterBeschrieb = scan.nextLine().trim();

		// Neuen Veranstalter erfassen Code:
		veranstalterErfassen(veranstalterName, veranstalterBeschrieb);
		service.getVeranstalter().stream().forEach(v -> System.out.println(v.toString()));
	}

	// Neue Aktivität erfassen Vorführen
	private static void aktivitaetErfassenInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Veranstalter wählen: ");
		for (int i = 0; i < service.getVeranstalter().size(); i++) {
			System.out.println(i + ". " + service.getVeranstalter().get(i).getVeranstalter());
		}
		int aktVeranstalter = Integer.valueOf(scan.nextLine().trim());
		System.out.println("Bitte Aktivitäts-Beschrieb erfassen: ");
		String aktBeschrieb = scan.nextLine().trim();
		System.out.println("Bitte Aktivitäts-Art erfassen: ");
		String aktArt = scan.nextLine().trim();
		System.out.println("Bitte Aktivitäts-Ort erfassen: ");
		String aktOrt = scan.nextLine().trim();
		System.out.println("Bitte Aktivitäts-PLZ erfassen: ");
		int aktPLZ = Integer.valueOf(scan.nextLine().trim());

		// Neue Aktivtität erfassen Code:
		aktErfassen(service.getVeranstalter().get(aktVeranstalter), aktBeschrieb, aktArt, aktOrt, aktPLZ);
		service.getAktivitaet().stream().forEach(v -> System.out.println(v.toString()));
	}

	// Neuen Veranstaltung erfassen Vorführen
	private static void veranstaltungErfassenInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Aktivität wählen: ");
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
		System.out.println("Bitte Anzahl verfügbare Plätze erfassen: ");
		int veranstaltungsPlaetze = Integer.valueOf(scan.nextLine().trim());

		LocalDateTime datum = LocalDateTime.parse(veranstaltungsDatum + " " + veranstaltungsZeit,
				DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm"));

		// Neuen Veranstaltung erfassen Code:
		veranstaltungErfassen(service.getAktivitaet().get(veranstaltungsAktivitaet), datum, veranstaltungsPreis,
				veranstaltungsPlaetze);
		service.getVeranstaltung().stream().forEach(v -> System.out.println(v.toString()));
	}

	// Weitere Methoden
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

	public void veranstaltungEditieren(Aktivitaet a, LocalDateTime datum, double preis, int totalePlaetze) {
	}

	public void veranstaltungLoeschen() {
	}

	public static void aktErfassen(Veranstalter veranstalter, String beschreibung, String art, String ort, int plz) {
		service.aktivitaetErfassen(veranstalter, art, ort, plz, beschreibung);
	}

	public void aktEditieren(Veranstalter veranstalter, String beschreibung, String art, String ort, int plz) {
	}

	public void aktLoeschen() {
	}
}