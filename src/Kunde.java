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

	// Das Alter des Kundens wird �berpr�ft, um festzustellen ob dieser Erwachsen
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

	// Alter wird �berpr�ft und allenfalls von einem Kind zum Erwachsenen
	// umgewandelt
	public void umwandeln(LocalDate geburtstag) {
		// Wenn der Kunde noch ein Kind ist, wird sein Alter �berpr�ft
		if (erwachsen == false) {
			geburtstag = this.geburtstag;
			LocalDate datumHeute = LocalDate.now();
			// Falls dieser �lter ist als 16, wird das Attribut erwachsen auf true gesetzt
			if (geburtstag.plusYears(16).isBefore(datumHeute)) {
				this.erwachsen = true;
				System.out
						.println("Sie sind jetzt erwachsen und k�nnen Buchungen, Zahlungen und Bewertungen vornehmen.");
			}
			// Falls dieser j�nger ist als 16, bleibt dieser ein Kind
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

		// Anzahl an gew�nschten Teilnehmenden wird angegeben und �berpr�ft ob genug
		// Pl�tze vorhanden sind
		System.out.println("F�r wie viele Personen wollen Sie reservieren?");
		int auswahlAnzahlPlaetze = scan.nextInt();
		// Wenn genug Pl�tze vorhanden sind wird der IF-Block ausgef�hrt
		if (auswahlAnzahlPlaetze <= veranstaltung.getTotalPlaetze()) {
			System.out.println(
					"Es sind genug Pl�tze verf�gbar. \nWollen Sie die Auswahl bezahlen, w�hlen Sie 1. \nWollen Sie eine andere Anzahl an Personen w�hlen, w�hlen Sie 2. \nWollen Sie eine neue Suche starten, w�hlen Sie 3. \nWollen Sie sich ausloggen, w�hlen Sie 4.");
			int auswahl = scan.nextInt();
			switch (auswahl) {
			// Die Methode Zahlen wird ausgef�hrt
			case 1:
				veranstaltung.setTotalPlaetze(veranstaltung.getTotalPlaetze() - auswahlAnzahlPlaetze);
				kunde.zahlen(veranstaltung, auswahlAnzahlPlaetze);
				break;
			// Die gew�nschte Personenanzahl kann angepasst werden
			case 2:
				kunde.buchen(this.veranstaltung);
				break;
			// Die Methode Suchen in Klasse Person wird ausgef�hrt
			case 3:
				person.suchen();
				break;
			// Die Methode Logout in der Klasse Kunde wird ausgef�hrt
			case 4:
				kunde.logout();
				setExit(true);
				break;
			default:
				System.out.println("Ihre Auswahl ist ung�ltig");
			}
		}
		// Wenn nicht genug Pl�tze vorhanden sind, wird er Else-Block ausgef�hrt
		else {
			System.out.println(
					"Es sind nicht gen�gend Pl�tze verf�gbar. \nUm die Personenanzhal anzupassen, w�hlen Sie 1. \nUm eine neue Suche zu starten, w�hlen Sie 2. \nUm sich auszuloggen, w�hlen Sie 3.");
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
				System.out.println("Ihre auswahl ist ung�ltig.");
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
		System.out.println("Der Preis betr�gt: " + totalPreis + " CHF. \nBesitzen Sie einen Gutschein?");
		String eingabeGutscheinVorhanden = scan.next();
		// Falls man einen Gutschein besitz, kann man nun den Code eingeben.
		switch (eingabeGutscheinVorhanden) {
		case "ja":
			System.out.println("Bitte geben Sie den Code ein:");
			String eingabeCode = scan.next();
			switch (eingabeCode) {
			// wenn der Code f�r einen 10% Gutschein angegeben wird
			case "A":
				totalPreis = totalPreis * 0.9;
				System.out.println("Der neue Preis betr�gt: " + totalPreis + " CHF.");
				break;
			// wenn der Code f�r einen 5% Gutschein angegeben wird
			case "B":
				totalPreis = totalPreis * 0.95;
				System.out.println("Der neue Preis betr�gt: " + totalPreis + " CHF.");
				break;
			default:
				System.out.println("Der Code ist falsch. Der Preis betr�gt: " + totalPreis + " CHF.");
			}
			break;
		// Falls nein angegeben wird, wird nichts ausgef�hrt, sprich direkt zu den
		// Zahlungsdaten gegangen.
		default:
		}
		// Zahlungsdaten des Kunden werden angegeben
		System.out.println("Bitte w�hlen Sie eine Zahlungsmethode aus:");
		String eingabeZahlungsmethode = scan.next();
		System.out.println("Bitte geben Sie den Karteninhaber ein:");
		String eingabeKartenInhaber = scan.next();
		System.out.println("Bitte geben Sie ihre Kartennummer ein:");
		long eingabeKartennummer = scan.nextLong();
		System.out.println("Bitte geben Sie das Verfallsdatum der Karte ein:");
		String eingabeVerfallsdatum = scan.next();
		System.out.println("Bitte geben Sie den CVC-Code ein:");
		int eingabeCVCCode = scan.nextInt();
		// Zahlungsdaten werden best�tigt
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
					"Zahlvorgang wurde abgebrochen.\nWollen Sie eine neue Suche starten, w�hlen Sie 1. \nWollen Sie sich ausloggen, w�hlen Sie 2.");
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
				System.out.println("Ihre Auswahl ist ung�ltig.");
			}
		default:
			System.out.println("Ihre Auswahl ist ung�ltig.");
		}
	}

	public void bewerten(Veranstaltung VeranstaltungsAuswahl) {
		Kunde kunde = new Kunde();
		Bewertung bewertung = new Bewertung();
		veranstaltung = VeranstaltungsAuswahl;
		System.out.println("Folgende Aktivit�ten steht zur Bewertung zur Verf�gung: "
				+ this.veranstaltung.getAktivitaet().getBeschrieb()
				+ ". \nFalls Sie eine Bewertung abgeben wollen, w�hlen Sie 1. \nFalls Sie keine Bewertung abgeben wollen, w�hlen Sie 2.");
		Scanner scan = new Scanner(System.in);
		int auswahl = scan.nextInt();
		switch (auswahl) {
		case 1:
			System.out.println("Geben Sie die Anzahl Sterne an:");
			int bewertungStern = scan.nextInt();
			System.out.println("M�chten Sie auch einen Bewertungs Text abgeben?");
			String antwort = scan.next();
			switch (antwort) {
			// Falls ein Bewertungstext abgegeben wird, wird am Ende ein 10% Gutschein
			// erstellt
			case "ja":
				System.out.println("Geben Sie ihren Text ein:");
				String bewertungText = scan.next();
				Bewertung.bewertungHinzufuegen(this.veranstaltung.getAktivitaet(), bewertungText, bewertungStern);
				System.out.println("Danke f�r Ihre bewertung.");
				bewertung.gutscheinErstellen10();
				break;
			// Falls kein Bewertungstext abgegeben wird, wird am Ende ein 5% Gutschein
			// erstellt
			default:
				System.out.println("Danke f�r Ihre bewertung.");
				bewertung.gutscheinErstellen5();
			}
			break;
		case 2:
			System.out.println("Sie haben keine Bewertung abgegeben.");
			break;
		default:
			System.out.println("Ihre auswahl steht nicht zur Verf�gung. Bitte w�hlen Sie eine g�ltige Auswahl aus.");
			kunde.bewerten(VeranstaltungsAuswahl);
		}
	}
}