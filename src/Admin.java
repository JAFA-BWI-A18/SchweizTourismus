import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Admin extends Person {

	public void inputStart() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte gewünschte Aktion wählen: \n1 Neuen Veranstalter erfassen"
				+ "\n2 Bestehenden Veranstalter bearbeiten" + "\n3 Veranstalter löschen"
				+ "\n4 Neue Veranstaltung erfassen" + "\n5 Bestehenden Veranstaltung bearbeiten"
				+ "\n6 Veranstaltung löschen" + "\n7 Neue Aktivität erfassen" + "\n8 Bestehende Aktivität bearbeiten"
				+ "\n9 Aktivität löschen");
		String zahl = scan.next().trim();
	
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
	private void veranstalterErfassenInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Veranstalter-Namen erfassen: ");
		String veranstalterName = scan.next().trim();
		System.out.println("Bitte Veranstalter-Beschrieb erfassen: ");
		String veranstalterBeschrieb = scan.next().trim();
			// Neuen Veranstalter erfassen Code:
		veranstalterErfassen(veranstalterName, veranstalterBeschrieb);
		//Data.getInstance().getVeranstalter().stream().forEach(v -> System.out.println(v.toString()));
	}

	// Neue Aktivität erfassen Vorführen
	private void aktivitaetErfassenInput() {
		Scanner scan = new Scanner(System.in);
		Data data = Data.getInstance();
		System.out.println("Bitte Veranstalter wählen: ");
		for (int i = 0; i < data.getVeranstalter().size(); i++) {
			System.out.println(i + ". " + data.getVeranstalter().get(i).getVeranstalter());
		}
		int aktVeranstalter = Integer.valueOf(scan.next().trim());
		System.out.println("Bitte Aktivitäts-Beschrieb erfassen: ");
		String aktBeschrieb = scan.next().trim();
		System.out.println("Bitte Aktivitäts-Art erfassen: ");
		String aktArt = scan.next().trim();
		System.out.println("Bitte Aktivitäts-Ort erfassen: ");
		String aktOrt = scan.next().trim();
		System.out.println("Bitte Aktivitäts-PLZ erfassen: ");
		int aktPLZ = Integer.valueOf(scan.next().trim());
		// Neue Aktivtität erfassen Code:
		aktErfassen(data.getVeranstalter().get(aktVeranstalter), aktBeschrieb, aktArt, aktOrt, aktPLZ);
		//data.getAktivitaet().stream().forEach(v -> System.out.println(v.toString()));
	}

	// Neuen Veranstaltung erfassen Vorführen
	private void veranstaltungErfassenInput() {
		Scanner scan = new Scanner(System.in);
		Data data = Data.getInstance();
		System.out.println("Bitte Aktivität wählen: ");
		for (int i = 0; i < data.getAktivitaet().size(); i++) {
			System.out.println(i + ". " + data.getAktivitaet().get(i).getVeranstalter().getVeranstalter() + " - "
					+ data.getAktivitaet().get(i).getBeschrieb());
		}
		int veranstaltungsAktivitaet = Integer.valueOf(scan.next().trim());
		System.out.println("Bitte Veranstaltungs-Datum erfassen (Format: DD.MM.YYYY): ");
		String veranstaltungsDatum = scan.next().trim();
		System.out.println("Bitte Veranstaltungs-Zeit erfassen (Format: HH:MM): ");
		String veranstaltungsZeit = scan.next().trim();
		System.out.println("Bitte Veranstaltungs-Preis erfassen: ");
		double veranstaltungsPreis = Double.valueOf(scan.next().trim());
		System.out.println("Bitte Anzahl verfügbare Plätze erfassen: ");
		int veranstaltungsPlaetze = Integer.valueOf(scan.next().trim());

		LocalDateTime datum = LocalDateTime.parse(veranstaltungsDatum + " " + veranstaltungsZeit,
				DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

		// Neuen Veranstaltung erfassen Code:
		veranstaltungErfassen(data.getAktivitaet().get(veranstaltungsAktivitaet), datum, veranstaltungsPreis,
				veranstaltungsPlaetze);
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