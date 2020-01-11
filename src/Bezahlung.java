
public class Bezahlung {
	private String zahlungart;
	private long kartenNr;
	private int cvc;
	private String nameInhaber;

	public String getZahlungart() {
		return zahlungart;
	}

	public void setZahlungart(String zahlungart) {
		this.zahlungart = zahlungart;
	}

	public long getKartenNr() {
		return kartenNr;
	}

	public void setKartenNr(long kartenNr) {
		this.kartenNr = kartenNr;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public String getNameInhaber() {
		return nameInhaber;
	}

	public void setNameInhaber(String nameInhaber) {
		this.nameInhaber = nameInhaber;
	}
}
