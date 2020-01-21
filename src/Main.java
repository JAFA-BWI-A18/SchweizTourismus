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

	public static void main(String[] args) {
		Kunde kunde = new Kunde();
		// Use Case "Aktivität verwalten" aus Admin-Sicht
		Admin admin = new Admin();
		admin.main(args);
		admin.main(args);
		admin.main(args);

		// Kunden erfassen
		List<Kunde> kundelist = Data.getKundenDaten(); // Kundenausgeben
		List<Kunde> kundelist2 = new ArrayList<Kunde>();

		// Admin erfassen
		List<Admin> adminlist = new ArrayList<Admin>(); // Admin ausgeben
		List<Admin> adminlist2 = new ArrayList<Admin>();

		// Ein Kundenfile wird angelegt
		try {
			FileOutputStream fos = new FileOutputStream("KundeObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos); // write object to file
			oos.writeObject(kundelist);
			System.out.println("Done"); // closing resources
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Die Kunden werden ausgelesen und in der Console ausgegeben
		try {
			FileInputStream fis = new FileInputStream("KundeObject.ser");
			ObjectInputStream ois = new ObjectInputStream(fis); // write object to file
			kundelist2 = (List<Kunde>) ois.readObject();
			System.out.println("Done"); // closing resources
			ois.close();
			fis.close();
		} catch (IOException |

				ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Die Kunden werden ausgegeben for (Kunde kunde : kundelist2) {
		System.out.println("Benutzername: " + kunde.getBenutzername() + " Passwort: " + kunde.getPasswort());
	}

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
		boolean kundeVorhanden = false;
		boolean passwortVorhanden = false;
		// Jeder Kunde in der Liste wird überprüft.
		for (int i = 0; i < availbaleClients.size(); i++) {
			kundeVorhanden = availbaleClients.get(i).getBenutzername().equals(eingabeBenutzername);
			// Falls der Kunde vorhanden ist wird der If Block ausgeführt und das Passwort
			// überprüft
			if (kundeVorhanden) {
				passwortVorhanden = availbaleClients.get(i).getPasswort().equals(eingabePasswort);
				break;
			}
		}
		if (kundeVorhanden == true) {
			if (passwortVorhanden == true) {
				System.out.println("Sie sind nun eingeloggt.");
			} else {
				System.out.println("Ihr Passwort ist falsch. Bitte versuchen Sie es erneut.");
				login();
			}
		}
		// Falls die EinloggDaten nicht vorhanden sind, wird man gebeten, sich zu
		// registrtieren.
		else {
			System.out.println("Sie sind bei uns noch nicht regististriert. Bitte registrieren Sie sich zuerst.");
			kontoErstellen();
		}
		scan.close();
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
			// TODO passiert irgendwas, wenn man nein zu den ABGs sagt?
			kunde.setAgb(false);
			break;
		default:
			System.out.println("Ihre Angabe ist ungültig.");
		}
		// Das Alter wird überprüft, ob der neu registrierte Kunde erwachsen oder noch
		// ein Kind ist
		kunde.pruefungAlter(geburtstag);

		// TODO der neu erfasste Kunde wird der KundenArray hinzugefügt

		// Anschliessend kann man sich einloggen
		System.out.println("Sie können sich jetzt einloggen.");
		login();
		scan.close();
	}
}