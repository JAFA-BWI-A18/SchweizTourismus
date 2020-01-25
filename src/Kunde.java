import java.time.LocalDate;
import java.util.Scanner;

import veranstalter.Aktivitaet;
import veranstalter.Bewertung;
import veranstalter.Veranstalter;
import veranstalter.VeranstalterService;
import veranstalter.Veranstaltung;

public class Kunde extends Person {

	private static VeranstalterService service = new VeranstalterService();
	static {
		Data.basisVeranstaltung(service);
	}

//	Attribute
	private String name;
	private String vorname;
	private String adresse;
	private String hausNr;
	private int plz;
	private String ort;
	private String mail;
	private int tel;
	private boolean agb;
	private LocalDate geburtstag;
	private boolean erwachsen = true;
	private boolean exit;

//	Getters und Setters erstellt
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getHausNr() {
		return hausNr;
	}

	public void setHausNr(String hausNr) {
		this.hausNr = hausNr;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public boolean isAgb() {
		return agb;
	}

	public void setAgb(boolean agb) {
		this.agb = agb;
	}

	public LocalDate getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(LocalDate geburtstag) {
		this.geburtstag = geburtstag;

	}

	public boolean isErwachsen() {
		return erwachsen;
	}

	public void setErwachsen(boolean erwachsen) {
		this.erwachsen = erwachsen;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

//	Methoden

	// Das Alter des Kundens wird überprüft, um festzustellen ob dieser Erwachsen
	// oder ein Kind ist
	public void pruefungAlter(LocalDate geburtstag) {
		// Heutiges Datum wird abgefragt
		LocalDate datumHeute = LocalDate.now();
		// Geburtstag des Kunden wird eingelesen
		geburtstag = this.geburtstag;
		if (geburtstag.plusYears(16).isBefore(datumHeute)) {
			this.erwachsen = true;
		} else {
			this.erwachsen = false;
		}
	}

	// Alter wird überprüft und allenfalls von einem Kind zum Erwachsenen
	// umgewandelt
	public void umwandeln(LocalDate geburtstag) {
		// Wenn der Kunde noch ein Kind ist, wird sein Alter überprüft
		if (erwachsen == false) {
			geburtstag = this.geburtstag;
			LocalDate datumHeute = LocalDate.now();
			// Falls dieser älter ist als 16, wird das Attribut erwachsen auf true gesetzt
			if (geburtstag.plusYears(16).isBefore(datumHeute)) {
				this.erwachsen = true;
				System.out
						.println("Sie sind jetzt erwachsen und können Buchungen, Zahlungen und Bewertungen vornehmen.");
			}
			// Falls dieser jünger ist als 16, bleibt dieser ein Kind
			else {
				this.erwachsen = false;
			}
		}
		// Ist der Kunde bereits erwachsen bei der Registrierung, wird nicht passieren
		else {
			// mach nix
		}
	}

	public void buchen(Veranstaltung VeranstaltungsAuswahl) {
		veranstaltung = VeranstaltungsAuswahl;
		Kunde kunde = new Kunde();
		Person person = new Person();
		Scanner scan = new Scanner(System.in);

		// Anzahl an gewünschten Teilnehmenden wird angegeben und überprüft ob genug
		// Plätze vorhanden sind
		System.out.println("Für wie viele Personen wollen Sie reservieren?");
		int auswahlAnzahlPlaetze = scan.nextInt();
		// Wenn genug Plätze vorhanden sind wird der IF-Block ausgeführt
		if (auswahlAnzahlPlaetze <= veranstaltung.getTotalPlaetze()) {
			System.out.println(
					"Es sind genug Plätze verfügbar. \nWollen Sie die Auswahl bezahlen, wählen Sie 1. \nWollen Sie eine andere Anzahl an Personen wählen, wählen Sie 2. \nWollen Sie eine neue Suche starten, wählen Sie 3. \nWollen Sie sich ausloggen, wählen Sie 4.");
			int auswahl = scan.nextInt();
			switch (auswahl) {
			// Die Methode Zahlen wird ausgeführt
			case 1:
				veranstaltung.setTotalPlaetze(veranstaltung.getTotalPlaetze() - auswahlAnzahlPlaetze);
				kunde.zahlen(veranstaltung, auswahlAnzahlPlaetze);
				break;
			// Die gewünschte Personenanzahl kann angepasst werden
			case 2:
				kunde.buchen(this.veranstaltung);
				break;
			// Die Methode Suchen in Klasse Person wird ausgeführt
			case 3:
				person.suchen();
				break;
			// Die Methode Logout in der Klasse Kunde wird ausgeführt
			case 4:
				kunde.logout();
				setExit(true);
				break;
			default:
				System.out.println("Ihre Auswahl ist ungültig");
			}
		}
		// Wenn nicht genug Plätze vorhanden sind, wird er Else-Block ausgeführt
		else {
			System.out.println(
					"Es sind nicht genügend Plätze verfügbar. \nUm die Personenanzhal anzupassen, wählen Sie 1. \nUm eine neue Suche zu starten, wählen Sie 2. \nUm sich auszuloggen, wählen Sie 3.");
			int auswahl1 = scan.nextInt();
			switch (auswahl1) {
			// Die Personenanzahl wird angepasst
			case 1:
				kunde.buchen(this.veranstaltung);
				break;
			// Es wird eine neue Suche gestartet
			case 2:
				person.suchen();
				break;
			case 3:
				kunde.logout();
				setExit(true);
			default:
				System.out.println("Ihre auswahl ist ungültig.");
			}
		}
	}

	public void zahlen(Veranstaltung VeranstaltungsAuswahl, int anzahlPlaetze) {
		Kunde kunde = new Kunde();
		Person person = new Person();
		veranstaltung = VeranstaltungsAuswahl;
		double totalPreis = (veranstaltung.getPreis() * anzahlPlaetze);

		// Der Gesamtpreis wird angegeben
		Scanner scan = new Scanner(System.in);
		System.out.println("Der Preis beträgt: " + totalPreis + " CHF. \nBesitzen Sie einen Gutschein?");
		String eingabeGutscheinVorhanden = scan.next();
		// Falls man einen Gutschein besitz, kann man nun den Code eingeben.
		switch (eingabeGutscheinVorhanden) {
		case "ja":
			System.out.println("Bitte geben Sie den Code ein:");
			String eingabeCode = scan.next();
			switch (eingabeCode) {
			// wenn der Code für einen 10% Gutschein angegeben wird
			case "A":
				totalPreis = totalPreis * 0.9;
				System.out.println("Der neue Preis beträgt: " + totalPreis + " CHF.");
				break;
			// wenn der Code für einen 5% Gutschein angegeben wird
			case "B":
				totalPreis = totalPreis * 0.95;
				System.out.println("Der neue Preis beträgt: " + totalPreis + " CHF.");
				break;
			default:
				System.out.println("Der Code ist falsch. Der Preis beträgt: " + totalPreis + " CHF.");
			}
			break;
		// Falls nein angegeben wird, wird nichts ausgeführt, sprich direkt zu den
		// Zahlungsdaten gegangen.
		default:
		}
		// Zahlungsdaten des Kunden werden angegeben
		System.out.println("Bitte wählen Sie eine Zahlungsmethode aus:");
		String eingabeZahlungsmethode = scan.next();
		System.out.println("Bitte geben Sie den Karteninhaber ein:");
		String eingabeKartenInhaber = scan.next();
		System.out.println("Bitte geben Sie ihre Kartennummer ein:");
		long eingabeKartennummer = scan.nextLong();
		System.out.println("Bitte geben Sie das Verfallsdatum der Karte ein:");
		String eingabeVerfallsdatum = scan.next();
		System.out.println("Bitte geben Sie den CVC-Code ein:");
		int eingabeCVCCode = scan.nextInt();
		// Zahlungsdaten werden bestätigt
		System.out.println("Sind die folgenden Daten korrekt?" + "\nZahlungsmethode: " + eingabeZahlungsmethode
				+ "\nKarteninhaber:" + eingabeKartenInhaber + "\nKartennummer: " + eingabeKartennummer
				+ "\nVerfallsdatum: " + eingabeVerfallsdatum + "\nCVC Code: " + eingabeCVCCode);
		String bestaetigung = scan.next();
		switch (bestaetigung) {
		case "ja":
			System.out.println("Bezahlung erfolgreich.");
			kunde.bewerten(VeranstaltungsAuswahl);
			break;
		case "nein":
			System.out.println(
					"Zahlvorgang wurde abgebrochen.\nWollen Sie eine neue Suche starten, wählen Sie 1. \nWollen Sie sich ausloggen, wählen Sie 2.");
			int eingabe = scan.nextInt();
			switch (eingabe) {
			case 1:
				person.suchen();
				break;
			case 2:
				kunde.logout();
				setExit(true);
				break;
			default:
				System.out.println("Ihre Auswahl ist ungültig.");
			}
		default:
			System.out.println("Ihre Auswahl ist ungültig.");
		}
	}

	public void bewerten(Veranstaltung VeranstaltungsAuswahl) {
		Kunde kunde = new Kunde();
		Bewertung bewertung = new Bewertung();
		veranstaltung = VeranstaltungsAuswahl;
		System.out.println("Folgende Aktivitäten steht zur Bewertung zur Verfügung: "
				+ this.veranstaltung.getAktivitaet().getBeschrieb()
				+ ". \nFalls Sie eine Bewertung abgeben wollen, wählen Sie 1. \nFalls Sie keine Bewertung abgeben wollen, wählen Sie 2.");
		Scanner scan = new Scanner(System.in);
		int auswahl = scan.nextInt();
		switch (auswahl) {
		case 1:
			System.out.println("Geben Sie die Anzahl Sterne an:");
			int bewertungStern = scan.nextInt();
			System.out.println("Möchten Sie auch einen Bewertungs Text abgeben?");
			String antwort = scan.next();
			switch (antwort) {
			// Falls ein Bewertungstext abgegeben wird, wird am Ende ein 10% Gutschein
			// erstellt
			case "ja":
				System.out.println("Geben Sie ihren Text ein:");
				String bewertungText = scan.next();
				Bewertung.bewertungHinzufuegen(this.veranstaltung.getAktivitaet(), bewertungText, bewertungStern);
				System.out.println("Danke für Ihre bewertung.");
				bewertung.gutscheinErstellen10();
				break;
			// Falls kein Bewertungstext abgegeben wird, wird am Ende ein 5% Gutschein
			// erstellt
			default:
				System.out.println("Danke für Ihre bewertung.");
				bewertung.gutscheinErstellen5();
			}
			break;
		case 2:
			System.out.println("Sie haben keine Bewertung abgegeben.");
			break;
		default:
			System.out.println("Ihre auswahl steht nicht zur Verfügung. Bitte wählen Sie eine gültige Auswahl aus.");
			kunde.bewerten(VeranstaltungsAuswahl);
		}
	}
}