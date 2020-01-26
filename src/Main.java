import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

	// Hier findet der ganze Ablauf statt.
	public static void main(String[] args) {
		Main main = new Main();
		Person user = main.login();
		// Login wurde abgebrochen, beende Programm
		if (user == null) {
			System.exit(0);
		}
		Scanner scan = new Scanner(System.in);
		// Wenn man sich als Kunde einloggt, wird der If-Block ausgeführt
		if (user instanceof Kunde) {
			// Man kann eine Suche starten. Dabei wird automatisch danach die Methoden
			Kunde kunde = (Kunde) user;
			// Buchen, Zahlen und bewerten aufgerufen
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"Wie wollen Sie weiterfahren? \nWählen Sie 1, um eine Suche zu starten. \nWählen Sie 2, um sich auszuloggen.");
				int eingabe = Integer.valueOf(scan.nextLine().trim());
				switch (eingabe) {
				case 1:
					Veranstaltung veranstaltung = kunde.suchen();
					if (veranstaltung != null) {
						if (kunde.isErwachsen()) {
							// Wie soll mit den Angaben aus der Suche weitergefahren werden
							System.out.println(
									"Wie wollen Sie weiterfahren: \n1 ist Auswahl buchen \n2 ist zurück zum Hauptmenu");
							int auswahl2 = Integer.valueOf(scan.nextLine().trim());
							switch (auswahl2) {
							// Falls 1 ausgewählt wird, wird die Methode Buchen aus der Klasse Kunde
							// eingeleitet
							case 1:
								kunde.buchen(veranstaltung);
								break;
							// Falls 2 ausgewählt wird, wird eine neue Suche eingeleitet
							case 2:
								break;
							default:
								System.out.println("Ihre Auswahl ist ungültig.");
							}
						}
					}
					break;
				case 2:
					exit = true;
					kunde.logout();
					break;
				default:
					System.out.println("Ihre Auswahl ist ungültig.");
				}

			}
		}
		// Wenn man sich als Admin einloggt, wird der ElseIf-Block ausgeführt
		else if (user instanceof Admin) {
			Admin admin = (Admin) user;
			// Man wird vor die Wahl gestellt, was man als nächstes machen will.
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"Wie wollen Sie weiterfahren? \nWählen Sie 1, um die Daten zu verwalten. \nWählen Sie 2, um sich eine Veranstaltung zu suchen.\nWählen Sie 3, um sich auszuloggen.");
				int eingabe = Integer.valueOf(scan.nextLine().trim());
				switch (eingabe) {
				case 1:
					admin.inputStart();
					break;
				case 2:
					admin.suchen();
					break;
				case 3:
					admin.logout();
					exit = true;
					break;
				default:
					System.out.println("Ihre Auswahl ist ungültig.");
				}
			}
		}
	}

	// Methoden
	public Person login() {
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		Data data = Data.getInstance();
		while (!exit) {
			// Benutzername und Passwort werden eingegeben
			System.out.println("Geben Sie ihren Benutzernamen ein:");
			String eingabeBenutzername = scan.nextLine().trim();
			System.out.println("Geben Sie ihr Passwort ein:");
			String eingabePasswort = scan.nextLine().trim();

			// Benutzername und Passwort werden überprüft. Falls diese übereinstimmen, wird
			// man eingeloggt
			List<Kunde> kunden = data.getKundenDaten();
			List<Admin> admins = data.getAdminDaten();

			// Jeder Kunde in der Liste wird überprüft.
			for (Kunde kunde : kunden) {
				if (kunde.getBenutzername().equals(eingabeBenutzername)
						&& kunde.getPasswort().equals(eingabePasswort)) {
					System.out.println("Sie sind nun eingeloggt.");
					kunde.umwandeln();
					return kunde;
				}

			}
			// Falls die Eingabe nicht zu einem Kunden gehört, wird sie mit der Adminliste
			// verglichen
			for (Admin admin : admins) {
				if (admin.getBenutzername().equals(eingabeBenutzername)
						&& admin.getPasswort().equals(eingabePasswort)) {
					System.out.println("Sie sind als Admin eingeloggt.");
					return admin;
				}
			}
			System.out.println("Ihr Benutzername oder Passwort ist falsch.\n"
					+ "Wie wollen Sie weiterfahren? \nWählen Sie 1, um es nochmals zu versuchen. \nWählen Sie 2, um einen neuen Benutzer anzulegen. \nWählen Sie 3, um den Vorgang abzubrechen.");
			int auswahl1 = Integer.valueOf(scan.nextLine().trim());
			switch (auswahl1) {
			// nochmals probieren
			case 1:
				break;
			// neues Konto erstellen
			case 2:
				exit = !kontoErstellen();
				break;
			// Abbrechen
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Ihre Auswahl ist ungültig. Das Login wird erneut gestartet.");
			}
		}
		return null;
	}

	public boolean kontoErstellen() {
		Scanner scan = new Scanner(System.in);
		Data data = Data.getInstance();
		// Daten werden abgefragt und eingegeben
		System.out.println("Bitte geben Sie ihren Vornamen ein:");
		String eingabeVornamen = scan.nextLine().trim();
		System.out.println("Bitte geben Sie ihren Nachnamen ein:");
		String eingabeNachname = scan.nextLine().trim();
		System.out.println("Bitte geben Sie ihre Adresse ein (ohne Hausnummer):");
		String eingabeAdresse = scan.nextLine().trim();
		System.out.println("Bitte geben Sie ihre Hausnummer ein:");
		String eingabeHausnummer = scan.nextLine().trim();
		System.out.println("Bitte geben Sie ihre Postleitzahl (PLZ) ein:");
		int eingabePLZ = Integer.valueOf(scan.nextLine().trim());
		System.out.println("Bitte geben Sie den Ort ein:");
		String eingabeOrt = scan.nextLine().trim();
		System.out.println("Bitte geben Sie ihre E-Mail Adresse ein:");
		String eingabeMail = scan.nextLine().trim();
		System.out.println("Bitte geben Sie eine Telefonnummer ein:");
		String eingabeTelNr = scan.nextLine().trim();
		System.out.println("Bitte geben Sie ihren Geburtstag ein, im Format dd.mm.yyyy");
		String eingabeGeburtstag = scan.nextLine();
		LocalDate geburtstag = LocalDate.parse(eingabeGeburtstag, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		System.out.println("Bitte geben Sie einen Benutzernamen ein:");
		String eingabeBenutzername = scan.nextLine().trim();
		System.out.println("Bitte geben Sie ein Passwort ein:");
		String eingabePasswort = scan.nextLine().trim();
		boolean agb = false;
		while (!agb) {
			System.out.println(
					"Sind sie mit den AGBs einverstanden? (ja/nein) Falls Sie die AGB ablehnen, wird die Konto erstellung abgebrochen");
			String eingabeAGB = scan.nextLine().trim();
			switch (eingabeAGB) {
			case "ja":
				agb = true;
				break;
			case "nein":
				return false;
			default:
				System.out.println("Bitte stimmen Sie den AGBs zu.\n");
				System.out.println("Ihre Angabe ist ungültig.");
			}
		}
		// Eingaben werden erfasst und gespeichert als neuer Kunde
		Kunde neuerKunde = new Kunde();
		neuerKunde.setBenutzername(eingabeBenutzername);
		neuerKunde.setPasswort(eingabePasswort);
		neuerKunde.setVorname(eingabeVornamen);
		neuerKunde.setName(eingabeNachname);
		neuerKunde.setAdresse(eingabeAdresse);
		neuerKunde.setHausNr(eingabeHausnummer);
		neuerKunde.setMail(eingabeMail);
		neuerKunde.setPlz(eingabePLZ);
		neuerKunde.setOrt(eingabeOrt);
		neuerKunde.setTel(eingabeTelNr);
		neuerKunde.setGeburtstag(geburtstag);
		neuerKunde.setAgb(agb);
		// Das Alter wird überprüft, ob der neu registrierte Kunde erwachsen oder noch
		// ein Kind ist
		neuerKunde.pruefungAlter();
		data.kundenHinzufuegen(neuerKunde);
		System.out.println("Sie können sich jetzt einloggen.");
		return true;
	}

	public void anmeldungBestaetingung() {

	}

	public void erinnerungBestaetigung() {

	}
}