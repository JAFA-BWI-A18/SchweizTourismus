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
		Aktivitaet eintritt = service.aktivitaetErfassen(oaf, "Outdoor", "Frauenfeld", 8500);

		// Veranstaltung Tag 1 für Eintritt am OAF
		service.veranstaltungErfassen(eintritt, LocalDateTime.of(2020, 07, 9, 14, 00), 100, 50, false);
		// Bewertung der Veranstaltung Eintritt
		service.bewertungHinzufügen(eintritt, "Geil", 5);
		service.bewertungHinzufügen(eintritt, "Hammer", 5);
		service.bewertungHinzufügen(eintritt, "Nice", 4);
		// Veranstaltung Tag 2 für Eintritt am OAF
		service.veranstaltungErfassen(eintritt, LocalDateTime.of(2020, 07, 10, 14, 00), 200, 30, false);
		// Bewertung der Veranstaltung Eintritt
		service.bewertungHinzufügen(eintritt, "Jedes Jahr wieder", 5);
		service.bewertungHinzufügen(eintritt, "Danke, mega toll", 5);
		service.bewertungHinzufügen(eintritt, "Schlimm", 1);

		// Aktivität Übernachtung für OAF
		Aktivitaet uebernachtung = service.aktivitaetErfassen(oaf, "Outdoor", "Frauenfeld", 8500);

		// Veranstaltung Nacht 1 für Übernachtung am OAF
		service.veranstaltungErfassen(uebernachtung, LocalDateTime.of(2020, 7, 9, 14, 00), 100, 100, false);
		// Bewertung der Veranstaltung Übernachtung Nacht1
		service.bewertungHinzufügen(uebernachtung, "Mega bequem", 5);
		service.bewertungHinzufügen(uebernachtung, "Schmutzig", 2);

		// Veranstaltung Nacht 2 für Übernachtung am OAF
		service.veranstaltungErfassen(uebernachtung, LocalDateTime.of(2020, 7, 10, 14, 00), 50, 50, false);
		// Bewertung der Veranstaltung Übernachtung Nacht2
		service.bewertungHinzufügen(uebernachtung, "Toll", 5);
		service.bewertungHinzufügen(uebernachtung, "Nie wider", 1);
		service.bewertungHinzufügen(uebernachtung, "Schlimm", 1);

		// Veranstaltung Alpamare
		Veranstalter alpamare = service.veranstalterErfassen("Alpamare", "bla bla");
		Aktivitaet wellness = service.aktivitaetErfassen(alpamare, "Indoor", "Freienbach", 8807);

		service.veranstaltungErfassen(wellness, LocalDateTime.of(20202, 8, 13, 14, 00), 20, 15, false);
		service.bewertungHinzufügen(wellness, "Toll, aber..", 4);
		service.veranstaltungErfassen(wellness, LocalDateTime.of(2020, 7, 10, 14, 00), 20, 20, false);
		service.bewertungHinzufügen(wellness, "Super", 5);

		Aktivitaet rutschbahnen = service.aktivitaetErfassen(alpamare, "Indoor", "Freienbach", 8807);
		service.veranstaltungErfassen(rutschbahnen, LocalDateTime.of(2020, 7, 22, 10, 00), 15, 20, false);
		service.bewertungHinzufügen(rutschbahnen, "Sensationell", 5);
		service.bewertungHinzufügen(rutschbahnen, "Schlecht", 1);
		service.veranstaltungErfassen(rutschbahnen, LocalDateTime.of(2020, 10, 28, 10, 00), 17, 15, false);
		service.bewertungHinzufügen(rutschbahnen, "ok", 3);
		service.bewertungHinzufügen(rutschbahnen, "Nice", 5);
	}

}