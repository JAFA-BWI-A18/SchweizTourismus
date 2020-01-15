package veranstalter;

public class Bewertung {

	private static VeranstalterService service = new VeranstalterService();
	static {
//		Data.basisVeranstaltung(service);
	}

//	Attribute
	private String bewertungText;
	private int bewertungStern;

//	Konstruktor
	public Bewertung(String bewertungText, int bewertungStern) {
		this.bewertungText = bewertungText;
		this.bewertungStern = bewertungStern;
	}

//	Getters und Setters für definierte Attribute
	public String getBewertungText() {
		return bewertungText;
	}

	public void setBewertungText(String bewertungText) {
		this.bewertungText = bewertungText;
	}

	public int getBewertungStern() {
		return bewertungStern;
	}

	public void setBewertungStern(int bewertungStern) {
		this.bewertungStern = bewertungStern;
	}

//	Methoden
	public static void bewertungHinzufuegen(Aktivitaet aktivitaet, String bewertungText, int bewertungStern) {
		service.bewertungHinzufuegen(aktivitaet, bewertungText, bewertungStern);
	}
	
	//TODO Wenn eine Bewertung abgegeben wurde, wird ein Gutschein erstellt und verschickt.
	//allenfalls einfacher, wenn wir einen konstanten Gutschein Code verwenden?!
	public void gutscheinErstellen() {
		
	}
}