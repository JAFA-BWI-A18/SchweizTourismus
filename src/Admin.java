import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Admin extends Person {

	public void inputStart() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte gew�nschte Aktion w�hlen: \n1 Neuen Veranstalter erfassen"
				+ "\n2 Bestehenden Veranstalter bearbeiten" + "\n3 Veranstalter l�schen"
				+ "\n4 Neue Aktivit�t erfassen" + "\n5 Bestehenden Aktivit�t bearbeiten"
				+ "\n6 Aktivit�t l�schen" + "\n7 Neue Veranstaltung erfassen" + "\n8 Bestehende Veranstaltung bearbeiten"
				+ "\n9 Veranstaltung l�schen");
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
			System.out.println("Bitte �berpr�fen Sie Ihre Angaben.");
		}

	}

	// Neuen Veranstalter erfassen Vorf�hren
	private void veranstalterErfassenInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Veranstalter-Namen erfassen: ");
		String veranstalterName = scan.nextLine().trim();
		System.out.println("Bitte Veranstalter-Beschrieb erfassen: ");
		String veranstalterBeschrieb = scan.nextLine().trim();
			// Neuen Veranstalter erfassen Code:
		veranstalterErfassen(veranstalterName, veranstalterBeschrieb);
		System.out.println("Veranstalter erfasst.");
		//Data.getInstance().getVeranstalter().stream().forEach(v -> System.out.println(v.toString()));
	}

	// Neue Aktivit�t erfassen Vorf�hren
	private void aktivitaetErfassenInput() {
		Scanner scan = new Scanner(System.in);
		Data data = Data.getInstance();
		System.out.println("Bitte Veranstalter w�hlen: ");
		for (int i = 0; i < data.getVeranstalter().size(); i++) {
			System.out.println(i + ". " + data.getVeranstalter().get(i).getVeranstalter());
		}
		int aktVeranstalter = Integer.valueOf(scan.nextLine().trim());
		System.out.println("Bitte Aktivit�ts-Beschrieb erfassen: ");
		String aktBeschrieb = scan.nextLine().trim();
		System.out.println("Bitte Aktivit�ts-Art erfassen: ");
		String aktArt = scan.nextLine().trim();
		System.out.println("Bitte Aktivit�ts-Ort erfassen: ");
		String aktOrt = scan.nextLine().trim();
		System.out.println("Bitte Aktivit�ts-PLZ erfassen: ");
		int aktPLZ = Integer.valueOf(scan.nextLine().trim());
		// Neue Aktivtit�t erfassen Code:
		aktErfassen(data.getVeranstalter().get(aktVeranstalter), aktBeschrieb, aktArt, aktOrt, aktPLZ);
		System.out.println("Aktivit�t erfasst.");
		//data.getAktivitaet().stream().forEach(v -> System.out.println(v.toString()));
	}

	// Neuen Veranstaltung erfassen Vorf�hren
	private void veranstaltungErfassenInput() {
		Scanner scan = new Scanner(System.in);
		Data data = Data.getInstance();
		System.out.println("Bitte Aktivit�t w�hlen: ");
		for (int i = 0; i < data.getAktivitaet().size(); i++) {
			System.out.println(i + ". " + data.getAktivitaet().get(i).getVeranstalter().getVeranstalter() + " - "
					+ data.getAktivitaet().get(i).getBeschrieb());
		}
		int veranstaltungsAktivitaet = Integer.valueOf(scan.nextLine().trim());
		System.out.println("Bitte Veranstaltungs-Datum erfassen (Format: DD.MM.YYYY): ");
		String veranstaltungsDatum = scan.nextLine().trim();
		System.out.println("Bitte Veranstaltungs-Zeit erfassen (Format: HH:MM): ");
		String veranstaltungsZeit = scan.nextLine().trim();
		System.out.println("Bitte Veranstaltungs-Preis erfassen: ");
		double veranstaltungsPreis = Double.valueOf(scan.nextLine().trim());
		System.out.println("Bitte Anzahl verf�gbare Pl�tze erfassen: ");
		int veranstaltungsPlaetze = Integer.valueOf(scan.nextLine().trim());

		LocalDateTime datum = LocalDateTime.parse(veranstaltungsDatum + " " + veranstaltungsZeit,
				DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

		// Neuen Veranstaltung erfassen Code:
		veranstaltungErfassen(data.getAktivitaet().get(veranstaltungsAktivitaet), datum, veranstaltungsPreis,
				veranstaltungsPlaetze);
		System.out.println("Veranstaltung erfasst.");
		//data.getVeranstaltung().stream().forEach(v -> System.out.println(v.toString()));
	}

	// Weitere Methoden
	public void veranstalterErfassen(String veranstalter, String beschreibung) {
		Data.getInstance().veranstalterErfassen(veranstalter, beschreibung);
	}

	public void veranstalterEditieren(String veranstalter, String beschreibung) {
	}

	public void veranstalterLoeschen() {
	}

	public static void veranstaltungErfassen(Aktivitaet a, LocalDateTime datum, double preis, int totalePlaetze) {
		Data.getInstance().veranstaltungErfassen(a, datum, preis, totalePlaetze);
	}

	public void veranstaltungEditieren(Aktivitaet a, LocalDateTime datum, double preis, int totalePlaetze) {
	}

	public void veranstaltungLoeschen() {
	}

	public static void aktErfassen(Veranstalter veranstalter, String beschreibung, String art, String ort, int plz) {
		Data.getInstance().aktivitaetErfassen(veranstalter, art, ort, plz, beschreibung);
	}

	public void aktEditieren(Veranstalter veranstalter, String beschreibung, String art, String ort, int plz) {
	}

	public void aktLoeschen() {
	}
}