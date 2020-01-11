package veranstalter;

public class Bewertung {

	private String bewertungText;
	private int bewertungStern;

	public Bewertung(String bewertungText, int bewertungStern) {
		this.bewertungText = bewertungText;
		this.bewertungStern = bewertungStern;
	}

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