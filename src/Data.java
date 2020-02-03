import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Diese Klasse dient als unsere Datenbank
public class Data {

// Attribute
	private static Data instance;

	private final List<Veranstalter> veranstalter;
	private final List<Aktivitaet> aktivitaeten;
	private final List<Veranstaltung> veranstaltungen;
	private final List<Admin> admins;
	private final List<Kunde> kunden;

// Konstruktor
	private Data() {
		this.veranstalter = new ArrayList<>();
		this.aktivitaeten = new ArrayList<>();
		this.veranstaltungen = new ArrayList<>();
		this.admins = new ArrayList<>();
		this.kunden = new ArrayList<>();
		this.basisVeranstaltung();
		this.basisKundenDaten();
		this.basisAdminDaten();
	}

// Getters and Setters
	public List<Veranstalter> getVeranstalter() {
		return veranstalter;
	}

	public List<Aktivitaet> getAktivitaet() {
		return aktivitaeten;
	}

	public List<Veranstaltung> getVeranstaltung() {
		return veranstaltungen;
	}

	public List<Kunde> getKundenDaten() {
		return kunden;
	}

	public List<Admin> getAdminDaten() {
		return admins;
	}

// Methoden
	public static Data getInstance() {
		if (instance == null) {
			instance = new Data();
		}
		return instance;
	}

	public Veranstalter veranstalterErfassen(String veranstalterStr, String beschreibung) {
		Veranstalter tmp = new Veranstalter(veranstalterStr, beschreibung);
		veranstalter.add(tmp);
		return tmp;
	}

	public void veranstalterLoeschen(Veranstalter v) {
		veranstalter.remove(v);
	}

	public Aktivitaet aktivitaetErfassen(Veranstalter v, String art, String ort, int plz, String beschrieb) {
		Aktivitaet tmp = new Aktivitaet(art, ort, plz, v, beschrieb);
		v.aktivitaetHinzufügen(tmp);
		aktivitaeten.add(tmp);
		return tmp;
	}

	public Veranstaltung veranstaltungErfassen(Aktivitaet a, LocalDateTime datum, double preis, int totalPlaetze) {
		Veranstaltung tmp = new Veranstaltung(a, datum, preis, totalPlaetze);
		a.veranstaltungHinzufugen(tmp);
		veranstaltungen.add(tmp);
		return tmp;
	}

	public String bewertungHinzufuegen(Aktivitaet a, String text, int stern) {
		Bewertung tmp = new Bewertung(text, stern);
		a.bewertungHinzuguegen(tmp);
		if (tmp.getBewertungText() != null && !tmp.getBewertungText().isBlank()) {
			// Gutscheincode A wird ausgegeben
			return "A";
		}
		// Gutscheincode B wird ausgegeben
		return "B";
	}

	public void kundenHinzufuegen(Kunde kunde) {
		this.kunden.add(kunde);
	}

	// Kunden instanzieren
	private void basisKundenDaten() {

		Kunde kunde1 = new Kunde();
		kunde1.setBenutzername("Amina");
		kunde1.setPasswort("ILoveHWZ");

		kunden.add(kunde1);

		Kunde kunde2 = new Kunde();
		kunde2.setBenutzername("Josip");
		kunde2.setPasswort("ILoveUML");

		kunden.add(kunde2);

		Kunde kunde3 = new Kunde();
		kunde3.setBenutzername("Annika");
		kunde3.setPasswort("ILoveJava");

		kunden.add(kunde3);
	}

	// Admin instanzieren
	private void basisAdminDaten() {
		Admin admin1 = new Admin();
		admin1.setBenutzername("SchweizTourismus");
		admin1.setPasswort("ILoveSwitzerland");

		admins.add(admin1);
	}

	// Basis Veranstalter / Aktivitäten / Veranstaltungen instanzieren
	private void basisVeranstaltung() {
		// Veranstalter OAF
		Veranstalter oaf = veranstalterErfassen("Open Air Frauenfeld", "bla bla");

		// Aktivität Tageseintritt für OAF
		Aktivitaet eintritt = aktivitaetErfassen(oaf, "Outdoor", "Frauenfeld", 8500, "Eintritt zum groessten Festival");

		// Veranstaltung Tag 1 für Eintritt am OAF
		veranstaltungErfassen(eintritt, LocalDateTime.of(2020, 07, 9, 14, 00), 100, 50);

		// Bewertung der Veranstaltung Eintritt Tag 1
		bewertungHinzufuegen(eintritt, "Geil", 5);
		bewertungHinzufuegen(eintritt, "Hammer", 5);
		bewertungHinzufuegen(eintritt, "Nice", 4);

		// Veranstaltung Tag 2 für Eintritt am OAF
		veranstaltungErfassen(eintritt, LocalDateTime.of(2020, 07, 10, 14, 00), 200, 30);

		// Bewertung der Veranstaltung Eintritt Tag 2
		bewertungHinzufuegen(eintritt, "Jedes Jahr wieder", 5);
		bewertungHinzufuegen(eintritt, "Danke, mega toll", 5);
		bewertungHinzufuegen(eintritt, "Schlimm", 1);

		// Aktivität Übernachtung für OAF
		Aktivitaet uebernachtung = aktivitaetErfassen(oaf, "Outdoor", "Frauenfeld", 8500, "Camping Upgrade");

		// Veranstaltung Nacht 1 für Übernachtung am OAF
		veranstaltungErfassen(uebernachtung, LocalDateTime.of(2020, 7, 9, 14, 00), 100, 100);

		// Bewertung der Veranstaltung Übernachtung Nacht1
		bewertungHinzufuegen(uebernachtung, "Mega bequem", 5);
		bewertungHinzufuegen(uebernachtung, "Schmutzig", 2);

		// Veranstaltung Nacht 2 für Übernachtung am OAF
		veranstaltungErfassen(uebernachtung, LocalDateTime.of(2020, 7, 10, 14, 00), 50, 50);

		// Bewertung der Veranstaltung Übernachtung Nacht2
		bewertungHinzufuegen(uebernachtung, "Toll", 5);
		bewertungHinzufuegen(uebernachtung, "Nie wider", 1);
		bewertungHinzufuegen(uebernachtung, "Schlimm", 1);

		// Veranstalter Alpamare
		Veranstalter alpamare = veranstalterErfassen("Alpamare", "bla bla");

		// Aktivität Wellness
		Aktivitaet wellness = aktivitaetErfassen(alpamare, "Indoor", "Freienbach", 8807, "Wellnes im Alpamare");

		// Veranstaltung Tag 1 für Wellness im Alpamare
		veranstaltungErfassen(wellness, LocalDateTime.of(2020, 8, 13, 14, 00), 20, 15);

		// Bewertung Tag 1 Wellness im Alpamare
		bewertungHinzufuegen(wellness, "Toll, aber..", 4);

		// Veranstaltung Tag 2 für Wellness im Alpamare
		veranstaltungErfassen(wellness, LocalDateTime.of(2020, 7, 10, 14, 00), 20, 20);

		// Bewertung Tag 2 Wellness im Alpamare
		bewertungHinzufuegen(wellness, "Super", 5);

		// Aktivität Rutschbahnen
		Aktivitaet rutschbahnen = aktivitaetErfassen(alpamare, "Indoor", "Freienbach", 8807, "Tolles Rutscherlebnis");

		// Veranstaltung Tag 1 für Rutschbahnen im Alpamare
		veranstaltungErfassen(rutschbahnen, LocalDateTime.of(2020, 7, 22, 10, 00), 15, 20);

		// Bewertung Tag 1 Rutschbahnen im Alpamare
		bewertungHinzufuegen(rutschbahnen, "Sensationell", 5);
		bewertungHinzufuegen(rutschbahnen, "Schlecht", 1);

		// Veranstaltung Tag 2 für Rutschbahnen im Alpamare
		veranstaltungErfassen(rutschbahnen, LocalDateTime.of(2020, 10, 28, 10, 00), 17, 15);

		// Bewertung Tag 2 Rutschbahnen im Alpamare
		bewertungHinzufuegen(rutschbahnen, "ok", 3);
		bewertungHinzufuegen(rutschbahnen, "Nice", 5);
	}

}