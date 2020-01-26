import java.time.LocalDate;
import java.util.Scanner;

public class Kunde extends Person {

//	Attribute
	private String name;
	private String vorname;
	private String adresse;
	private String hausNr;
	private int plz;
	private String ort;
	private String mail;
	private String tel;
	private boolean agb;
	private LocalDate geburtstag;
	private boolean erwachsen = true;

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
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

//	Methoden

	// Das Alter des Kundens wird �berpr�ft, um festzustellen ob dieser Erwachsen
	// oder ein Kind ist
	public void pruefungAlter() {
		// Heutiges Datum wird abgefragt
		LocalDate datumHeute = LocalDate.now();
		// Falls die Person �lter als 16 ist, wird der Status auf Erwachen gesetzt
		if (this.geburtstag.plusYears(16).isBefore(datumHeute)) {
			this.erwachsen = true;
		}
		// Ansonsten bleibt die Person ein Kind
		else {
			this.erwachsen = false;
		}
	}

	// Alter wird �berpr�ft und allenfalls von einem Kind zum Erwachsenen
	// umgewandelt
	public void umwandeln() {
		// Wenn der Kunde noch ein Kind ist, wird sein Alter �berpr�ft
		if (this.erwachsen == false) {
			pruefungAlter();
			if (this.erwachsen) {
				System.out
						.println("Sie sind jetzt erwachsen und k�nnen Buchungen, Zahlungen und Bewertungen vornehmen.");
			}
		}
		// Ist der Kunde bereits erwachsen bei der Registrierung, wird nicht passieren
		else {
			// mach nix
		}
	}

	public void buchen(Veranstaltung veranstaltung) {
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			// Anzahl an gew�nschten Teilnehmenden wird angegeben und �berpr�ft ob genug
			// Pl�tze vorhanden sind
			System.out.println("F�r wie viele Personen wollen Sie reservieren?");
			int auswahlAnzahlPlaetze = Integer.valueOf(scan.nextLine().trim());
			// Wenn genug Pl�tze vorhanden sind wird der IF-Block ausgef�hrt
			if (auswahlAnzahlPlaetze <= veranstaltung.getTotalPlaetze()) {
				System.out.println(
						"Es sind genug Pl�tze verf�gbar. \nWollen Sie die Auswahl bezahlen, w�hlen Sie 1. \nWollen Sie eine andere Anzahl an Personen w�hlen, w�hlen Sie 2. \nWollen Sie zr�ck zur Hauptauswahl, w�hlen Sie 3.");
				int auswahl = Integer.valueOf(scan.nextLine().trim());
				switch (auswahl) {
				// Die Methode Zahlen wird ausgef�hrt
				case 1:
					veranstaltung.setTotalPlaetze(veranstaltung.getTotalPlaetze() - auswahlAnzahlPlaetze);
					zahlen(veranstaltung, auswahlAnzahlPlaetze);
					exit = true;
					break;
				// Die gew�nschte Personenanzahl kann angepasst werden
				case 2:
					break;
				// Zur�ck zum Menu
				case 3:
					exit = true;
					break;
				default:
					System.out.println("Ihre Auswahl ist ung�ltig");
				}
			}
			// Wenn nicht genug Pl�tze vorhanden sind, wird er Else-Block ausgef�hrt
			else {
				System.out.println(
						"Es sind nicht gen�gend Pl�tze verf�gbar. \nUm die Personenanzahl anzupassen, w�hlen Sie 1. \nWollen Sie zr�ck zur Hauptauswahl, w�hlen Sie 2.");
				int auswahl1 = Integer.valueOf(scan.nextLine().trim());
				switch (auswahl1) {
				// Die Personenanzahl wird angepasst
				case 1:
					break;
				// Zur�ck zum Menu
				case 2:
					exit = true;
					break;
				default:
					System.out.println("Ihre auswahl ist ung�ltig.");
				}
			}
		}
	}

	public void zahlen(Veranstaltung veranstaltung, int anzahlPlaetze) {
		double totalPreis = (veranstaltung.getPreis() * anzahlPlaetze);

		// Der Gesamtpreis wird berechnet und eingef�llt
		Scanner scan = new Scanner(System.in);
		System.out.println("Der Preis betr�gt: " + totalPreis + " CHF. \nBesitzen Sie einen Gutschein? (ja/nein)");
		String eingabeGutscheinVorhanden = scan.nextLine();
		// Falls man einen Gutschein besitz, kann man nun den Code eingeben.
		switch (eingabeGutscheinVorhanden) {
		case "ja":
			System.out.println("Bitte geben Sie den Code ein:");
			String eingabeCode = scan.nextLine();
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
		System.out.println("Bitte geben Sie den Karteninhaber ein:");
		String eingabeKartenInhaber = scan.nextLine().trim();
		System.out.println("Bitte geben Sie ihre Kartennummer ein:");
		String eingabeKartennummer = scan.nextLine().trim();
		System.out.println("Bitte geben Sie das Verfallsdatum der Karte ein:");
		String eingabeVerfallsdatum = scan.nextLine().trim();
		System.out.println("Bitte geben Sie den CVC-Code ein:");
		String eingabeCVCCode = scan.nextLine().trim();
		// Zahlungsdaten werden best�tigt
		System.out.println("Sind die folgenden Daten korrekt? (ja/nein)" + "\nKarteninhaber:" + eingabeKartenInhaber
				+ "\nKartennummer: " + eingabeKartennummer + "\nVerfallsdatum: " + eingabeVerfallsdatum + "\nCVC Code: "
				+ eingabeCVCCode);
		String bestaetigung = scan.nextLine().trim();
		switch (bestaetigung) {
		case "ja":
			System.out.println("Bezahlung erfolgreich.");
			bewerten(veranstaltung);
			break;
		default:
			System.out.println("Zahlvorgang wurde abgebrochen.\n");
			break;
		}
	}

	public void bewerten(Veranstaltung veranstaltung) {
		// Die Aktivit�t welche man gebucht und bezahlt hat, steht zur Bewertung zur
		// Verf�gung
		System.out.println("Folgende Aktivit�ten steht zur Bewertung zur Verf�gung: "
				+ veranstaltung.getAktivitaet().getBeschrieb()
				+ ". \nFalls Sie eine Bewertung abgeben wollen, w�hlen Sie 1. \nFalls Sie keine Bewertung abgeben wollen, w�hlen Sie 2.");
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			int auswahl = Integer.valueOf(scan.nextLine().trim());
			switch (auswahl) {
			// Eine Bewertung kann abgegeben werden
			case 1:
				System.out.println("Geben Sie die Anzahl Sterne an:");
				int bewertungStern = scan.nextInt();
				System.out.println("M�chten Sie auch einen Bewertungs Text abgeben?  (ja/nein)");
				String antwort = scan.nextLine().trim();
				String bewertungText = "";
				switch (antwort) {
				// Falls ein Bewertungstext abgegeben wird, wird am Ende ein 10% Gutschein
				// erstellt
				case "ja":
					System.out.println("Geben Sie ihren Text ein:");
					bewertungText = scan.nextLine().trim();
					break;
				// Falls kein Bewertungstext abgegeben wird, wird am Ende ein 5% Gutschein
				// erstellt
				default:
					break;
				}
				System.out.println("Danke f�r Ihre Bewertung.");
				String gutscheinCode = Data.getInstance().bewertungHinzufuegen(veranstaltung.getAktivitaet(),
						bewertungText, bewertungStern);
				System.out.println("Ihr Gutschein-Code lautet: " + gutscheinCode);
				exit = true;
				break;
			// Man m�chte keine Bewertung abgeben
			case 2:
				System.out.println("Sie haben keine Bewertung abgegeben.");
				exit = true;
				break;
			default:
				System.out
						.println("Ihre auswahl steht nicht zur Verf�gung. Bitte w�hlen Sie eine g�ltige Auswahl aus.");
			}
		}
	}
}