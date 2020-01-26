

public class Bewertung {


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


}