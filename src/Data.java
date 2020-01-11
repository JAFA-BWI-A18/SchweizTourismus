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

	// Basis Veranstalter / Aktivitäten / Veranstaltungen erfassen
	public static void basisVeranstaltung(VeranstalterService service) {
		Veranstalter oaf = service.veranstalterErfassen("Open Air Frauenfeld", "bla bla");
		Aktivitaet eintritt = service.aktivitaetErfassen(oaf, "Outdoor", "Frauenfeld", 8500);
		Veranstaltung tag1 = service.veranstaltungErfassen(eintritt, LocalDateTime.of(2020, 07, 9, 14, 00), 100, 50, 50,
				false);
		Veranstaltung tag2 = service.veranstaltungErfassen(eintritt, LocalDateTime.of(2020, 07, 10, 14, 00), 200, 30,
				30, false);

		Aktivitaet uebernachtung = service.aktivitaetErfassen(oaf, "Outdoor", "Frauenfeld", 8500);
		Veranstaltung nacht1 = service.veranstaltungErfassen(uebernachtung, LocalDateTime.of(2020, 7, 9, 14, 00), 50,
				100, 100, false);
		Veranstaltung nacht2 = service.veranstaltungErfassen(uebernachtung, LocalDateTime.of(2020, 7, 10, 14, 00), 50,
				50, 50, false);

		Veranstalter alpamare = service.veranstalterErfassen("Alpamare", "bla bla");
		Aktivitaet wellness = service.aktivitaetErfassen(alpamare, "Indoor", "Freienbach", 8807);
		Veranstaltung event1 = service.veranstaltungErfassen(wellness, LocalDateTime.of(20202, 8, 13, 14, 00), 20, 15,
				15, false);
		Veranstaltung event2 = service.veranstaltungErfassen(wellness, LocalDateTime.of(2020, 7, 10, 14, 00), 20, 20,
				20, false);

		Aktivitaet rutschbahnen = service.aktivitaetErfassen(alpamare, "Indoor", "Freienbach", 8807);
		Veranstaltung fun1 = service.veranstaltungErfassen(rutschbahnen, LocalDateTime.of(2020, 7, 22, 10, 00), 15, 20,
				20, false);
		Veranstaltung fun2 = service.veranstaltungErfassen(rutschbahnen, LocalDateTime.of(2020, 10, 28, 10, 00), 17, 15,
				15, false);
	}

}