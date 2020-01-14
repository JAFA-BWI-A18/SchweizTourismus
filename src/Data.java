import java.time.LocalDateTime;
import java.util.ArrayList;

import veranstalter.Aktivitaet;
import veranstalter.Veranstalter;
import veranstalter.VeranstalterService;
import veranstalter.Veranstaltung;

//Diese Klasse dient als unsere Datenbank
public class Data {

	// Kunden instanzieren
	public static ArrayList<Kunde> getKundenDaten() {
		ArrayList<Kunde> kunden = new ArrayList<>();

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

		return kunden;
	}

	// Admin instanzieren
	public static ArrayList<Admin> getAdminDaten() {
		ArrayList<Admin> admin = new ArrayList<>();

		Admin admin1 = new Admin();
		admin1.setBenutzername("Schweiz Tourismus");
		admin1.setPasswort("ILoveSwitzerland");

		admin.add(admin1);

		return admin;
	}

	// Basis Veranstalter / Aktivitäten / Veranstaltungen instanzieren
	public static void basisVeranstaltung(VeranstalterService service) {
		// Veranstalter OAF
		Veranstalter oaf = service.veranstalterErfassen("Open Air Frauenfeld", "bla bla");

		// Aktivität Tageseintritt für OAF
		Aktivitaet eintritt = service.aktivitaetErfassen(oaf, "Outdoor", "Frauenfeld", 8500,
				"Eintritt zum groessten Festival");

		// Veranstaltung Tag 1 für Eintritt am OAF
		service.veranstaltungErfassen(eintritt, LocalDateTime.of(2020, 07, 9, 14, 00), 100, 50);

		// Bewertung der Veranstaltung Eintritt Tag 1
		service.bewertungHinzufuegen(eintritt, "Geil", 5);
		service.bewertungHinzufuegen(eintritt, "Hammer", 5);
		service.bewertungHinzufuegen(eintritt, "Nice", 4);

		// Veranstaltung Tag 2 für Eintritt am OAF
		service.veranstaltungErfassen(eintritt, LocalDateTime.of(2020, 07, 10, 14, 00), 200, 30);

		// Bewertung der Veranstaltung Eintritt Tag 2
		service.bewertungHinzufuegen(eintritt, "Jedes Jahr wieder", 5);
		service.bewertungHinzufuegen(eintritt, "Danke, mega toll", 5);
		service.bewertungHinzufuegen(eintritt, "Schlimm", 1);

		// Aktivität Übernachtung für OAF
		Aktivitaet uebernachtung = service.aktivitaetErfassen(oaf, "Outdoor", "Frauenfeld", 8500, "Camping Upgrade");

		// Veranstaltung Nacht 1 für Übernachtung am OAF
		service.veranstaltungErfassen(uebernachtung, LocalDateTime.of(2020, 7, 9, 14, 00), 100, 100);

		// Bewertung der Veranstaltung Übernachtung Nacht1
		service.bewertungHinzufuegen(uebernachtung, "Mega bequem", 5);
		service.bewertungHinzufuegen(uebernachtung, "Schmutzig", 2);

		// Veranstaltung Nacht 2 für Übernachtung am OAF
		service.veranstaltungErfassen(uebernachtung, LocalDateTime.of(2020, 7, 10, 14, 00), 50, 50);

		// Bewertung der Veranstaltung Übernachtung Nacht2
		service.bewertungHinzufuegen(uebernachtung, "Toll", 5);
		service.bewertungHinzufuegen(uebernachtung, "Nie wider", 1);
		service.bewertungHinzufuegen(uebernachtung, "Schlimm", 1);

		// Veranstalter Alpamare
		Veranstalter alpamare = service.veranstalterErfassen("Alpamare", "bla bla");

		// Aktivität Wellness
		Aktivitaet wellness = service.aktivitaetErfassen(alpamare, "Indoor", "Freienbach", 8807, "Wellnes im Alpamare");

		// Veranstaltung Tag 1 für Wellness im Alpamare
		service.veranstaltungErfassen(wellness, LocalDateTime.of(2020, 8, 13, 14, 00), 20, 15);

		// Bewertung Tag 1 Wellness im Alpamare
		service.bewertungHinzufuegen(wellness, "Toll, aber..", 4);

		// Veranstaltung Tag 2 für Wellness im Alpamare
		service.veranstaltungErfassen(wellness, LocalDateTime.of(2020, 7, 10, 14, 00), 20, 20);

		// Bewertung Tag 2 Wellness im Alpamare
		service.bewertungHinzufuegen(wellness, "Super", 5);

		// Aktivität Rutschbahnen
		Aktivitaet rutschbahnen = service.aktivitaetErfassen(alpamare, "Indoor", "Freienbach", 8807, "Tolles Rutscherlebnis");

		// Veranstaltung Tag 1 für Rutschbahnen im Alpamare
		service.veranstaltungErfassen(rutschbahnen, LocalDateTime.of(2020, 7, 22, 10, 00), 15, 20);

		// Bewertung Tag 1 Rutschbahnen im Alpamare
		service.bewertungHinzufuegen(rutschbahnen, "Sensationell", 5);
		service.bewertungHinzufuegen(rutschbahnen, "Schlecht", 1);

		// Veranstaltung Tag 2 für Rutschbahnen im Alpamare
		service.veranstaltungErfassen(rutschbahnen, LocalDateTime.of(2020, 10, 28, 10, 00), 17, 15);

		// Bewertung Tag 2 Rutschbahnen im Alpamare
		service.bewertungHinzufuegen(rutschbahnen, "ok", 3);
		service.bewertungHinzufuegen(rutschbahnen, "Nice", 5);
	}

}