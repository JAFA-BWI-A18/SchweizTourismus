import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

public class Main {

	// Hier findet der ganze Ablauf statt.
	public static void main(String[] args) {
		Kunde kunde = new Kunde();
		Admin admin = new Admin();
		Person person = new Person();
		Main main = new Main();
		Scanner scan = new Scanner(System.in);

		// Man wird gebeten sich einzuloggen
		main.login();
		// loggt man sich als Kunde ein, wird mit dem If-Block weitergefahren
		boolean angemeldetAlsKunde = true; // TODO überprüfung ob man sich beim Login als Kunde angemeldet hat. Dann = true. Und falls als Admin angemeldet = false. @Nico: Wie machen wir das?
	
		if (angemeldetAlsKunde == true) {
			// Man kann eine Suche starten. Dabei wird automatisch danach die Methoden
			// Buchen, Zahlen und bewerten aufgerufen
			person.suchen();
			// Wenn die Suche, Buchen, Zahlen und Bewerten abgescholssen ist, wird man vor
			// die Wahl gestellt, was man als nächstes machen will.
			boolean exit = false;
			while (exit == false) {
				System.out.println(
						"Wie wollen Sie weiterfahren? \nWählen Sie 1, um eine neue Suche zu starten. \nWählen Sie 2, um sich auszuloggen.");
				int eingabe = scan.nextInt();
				switch (eingabe) {
				case 1:
					person.suchen();
					break;
				case 2:
					exit = true;
					kunde.logout();
					break;
				default:
					System.out.println("Ihre Eingabe ist ungültig.");
				}
			}

		}
		// loggt man sich als Admin ein, wird der Else-Block ausgeführt
		else {
			// Use Case "Aktivität verwalten" aus Admin-Sicht
			admin.main(args);

			// Man wird vor die Wahl gestellt, was man als nächstes machen will.
			boolean exit=false;
			while (exit==false) {
				System.out.println(
						"Wie wollen Sie weiterfahren? \nWählen Sie 1, um die Daten zu verwalten. \nWählen Sie 2, um sich auszuloggen.");
				int eingabe = scan.nextInt();
				switch (eingabe) {
				case 1:
					admin.main(args);
					break;
				case 2:
					exit=true;
					kunde.logout();
					break;
				default:
					System.out.println("Ihre Auswahl ist ungültig.");
				}
			}
		}
	}

//Methoden
	public void login() {
		Scanner scan = new Scanner(System.in);
		Data data = new Data();

		// Benutzername und Passwort werden eingegeben
		System.out.println("Geben Sie ihren Benutzernamen ein:");
		String eingabeBenutzername = scan.next();
		System.out.println("Geben Sie ihr Passwort ein:");
		String eingabePasswort = scan.next();

		// Benutzername und Passwort werden überprüft. Falls diese übereinstimmen, wird
		// man eingeloggt
		ArrayList<Kunde> availbaleClients = data.getKundenDaten();
		ArrayList<Admin> availbaleAdmin = data.getAdminDaten();
		boolean kundeVorhanden = false;
		boolean passwortVorhanden = false;
		boolean adminVorhanden = false;
		boolean adminPasswortVorhanden = false;

		// Jeder Kunde in der Liste wird überprüft.
		for (int i = 0; i < availbaleClients.size(); i++) {
			kundeVorhanden = availbaleClients.get(i).getBenutzername().equals(eingabeBenutzername);
			// Falls der Kunde vorhanden ist wird der If Block ausgeführt und das Passwort
			// überprüft
			if (kundeVorhanden) {
				passwortVorhanden = availbaleClients.get(i).getPasswort().equals(eingabePasswort);
				break;
			}
			// Falls die Eingabe nicht zu einem Kunden gehört, wird sie mit der Adminliste
			// überprüft
			else {
				for (int j = 0; j < availbaleAdmin.size(); j++) {
					adminVorhanden = availbaleAdmin.get(j).getBenutzername().equals(eingabeBenutzername);
					if (adminVorhanden) {
						adminPasswortVorhanden = availbaleAdmin.get(j).getPasswort().equals(eingabePasswort);
						break;
					}
				}
			}
		}
		// Falls der Kunde vorhanden ist und die Eingaben korrekt, wir er eingelogt
		if (kundeVorhanden == true) {
			if (passwortVorhanden == true) {
				System.out.println("Sie sind nun eingeloggt.");
			}
			// Falls Kunde vorhanden ist, aber das Passwort falsch, wird man gebeten es
			// erneut zu versuchen
			else {
				System.out.println("Ihr Passwort ist falsch. Bitte versuchen Sie es erneut.");
				login();
			}
		}
		// Falls es kein Kunde sodern ein Admin ist und die Eingaben korrekt, wird man
		// als Admin eingeloggt
		else if (adminVorhanden == true) {
			if (adminPasswortVorhanden == true) {
				System.out.println("Sie sind als Admin eingeloggt.");
			}
			// Falls Admin vorhanden, aber Passwort falsch, wird man gebeten es erneut zu
			// versuchen
			else {
				System.out.println("Ihr Passwort ist falsch. Bitte versuchen Sie es erneut");
				login();
			}
		}
		// Falls die EinloggDaten nicht vorhanden sind, wird man gebeten, sich zu
		// registrtieren.
		else {
			System.out.println("Sie sind bei uns noch nicht regististriert. Bitte registrieren Sie sich zuerst.");
			kontoErstellen();
		}
	}

	public void kontoErstellen() {
		Scanner scan = new Scanner(System.in);
		Kunde kunde = new Kunde();
		Data data = new Data();
		// Daten werden abgefragt und eingegeben
		System.out.println("Bitte geben Sie ihren Vornamen ein:");
		String eingabeVornamen = scan.next();
		System.out.println("Bitte geben Sie ihren Nachnamen ein:");
		String eingabeNachname = scan.next();
		System.out.println("Bitte geben Sie ihre Adresse ein (ohne Hausnummer):");
		String eingabeAdresse = scan.next();
		System.out.println("Bitte geben Sie ihre Hausnummer ein:");
		String eingabeHausnummer = scan.next();
		System.out.println("Bitte geben Sie ihre Postleitzahl (PLZ) ein:");
		int eingabePLZ = scan.nextInt();
		System.out.println("Bitte geben Sie den Ort ein:");
		String eingabeOrt = scan.next();
		System.out.println("Bitte geben Sie ihre E-Mail Adresse ein:");
		String eingabeMail = scan.next();
		System.out.println("Bitte geben Sie eine Telefonnummer ein:");
		long eingabeTelNr = scan.nextLong();
		System.out.println("Bitte geben Sie ihren Geburtstag ein, im Format dd.mm.yyyy");
		String eingabeGeburtstag = scan.next();
		LocalDate geburtstag = LocalDate.parse(eingabeGeburtstag, DateTimeFormatter.ofPattern("dd.MM.uuuu"));
		System.out.println("Bitte geben Sie einen Benutzernamen ein:");
		String eingabeBenutzername = scan.next();
		System.out.println("Bitte geben Sie ein Passwort ein:");
		String eingabePasswort = scan.next();
		System.out.println("Sind sie mit den AGBs einverstanden? (ja/nein)");
		String eingabeAGB = scan.next();
		switch (eingabeAGB) {
		case "ja":
			kunde.setAgb(true);
			break;
		case "nein":
			System.out.println("Bitte stimmen Sie den AGBs zu.");
			eingabeAGB = scan.next();
			switch (eingabeAGB) {
			case "ja":
				kunde.setAgb(true);
				break;
			default:
				System.out.println("Bitte registrieren Sie sich neu.");
				kontoErstellen();
			}
			break;
		default:
			System.out.println("Ihre Angabe ist ungültig.");
		}
		// TODO ab hier funktioniert es nicht mehr!
		// Das Alter wird überprüft, ob der neu registrierte Kunde erwachsen oder noch
		// ein Kind ist
		kunde.pruefungAlter(geburtstag);

		Kunde neuerKunde = new Kunde();
		neuerKunde.setBenutzername(eingabeBenutzername);
		neuerKunde.setPasswort(eingabePasswort);

		ArrayList<Kunde> Kunde = data.getKundenDaten();
		Kunde.add(neuerKunde);

		// Anschliessend kann man sich einloggen
		System.out.println("Sie können sich jetzt einloggen.");
		login();
	}

	public void anmeldungBestaetingung() {

	}

	public void erinnerungBestaetigung() {

	}
}