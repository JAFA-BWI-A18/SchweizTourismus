import java.util.ArrayList;

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
}