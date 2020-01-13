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
	private int tel;
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

//	Methoden Kunde

	public static void main(String[] args) {
		Kunde kunde = new Kunde();
		kunde.zahlen();
	}

	// Das Alter des Kundens wird überprüft, um festzustellen ob dieser Erwachsen
	// oder ein Kind ist
	public void pruefungAlter(LocalDate datumHeute, LocalDate geburtstag) {
		// Heutiges Datum wird abgefragt
		datumHeute = LocalDate.now();
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
	public void umwandeln() {
		// Wenn der Kunde noch ein Kind ist, wird sein Alter überprüft
		if (erwachsen == false) {
			geburtstag = this.geburtstag;
			LocalDate datumHeute = LocalDate.now();
			// Falls dieser älter ist als 16, wird das Attribut erwachsen auf true gesetzt
			if (geburtstag.plusYears(16).isBefore(datumHeute)) {
				this.erwachsen = true;
				System.out.println("Sie sind jetzt erwachsen und können Buchungen und Bewertungen vornehmen.");
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

	public void buchen() {

	}

	public void zahlen() {
		// Zahlungsdaten werden erfasst
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte wählen Sie eine Zahlungsmethode aus:");
		String eingabeZahlungsmethode = scan.nextLine();
		System.out.println("Bitte geben Sie den Karteninhaber ein:");
		String eingabeKartenInhaber = scan.nextLine();
		System.out.println("Bitte geben Sie ihre Kartennummer ein:");
		String eingabeKartennummer = scan.nextLine();
		System.out.println("Bitte geben Sie das Verfallsdatum der Karte ein:");
		String eingabeVerfallsdatum = scan.nextLine();
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
			break;
		case "nein":
			System.out.println("Zahlvorgang abgebrochen.");
		default:
		}
		scan.close();
	}

	public void bewerten() {

	}

}