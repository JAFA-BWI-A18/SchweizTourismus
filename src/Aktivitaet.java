
public class Aktivitaet {

	private String art; // Indoor Outdoor
	private String ort;
	private int plz;
	private boolean markierungDeleted;
	private String bewertungText;
	private double bewertungStern;
	
	
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public boolean isMarkierungDeleted() {
		return markierungDeleted;
	}
	public void setMarkierungDeleted(boolean markierungDeleted) {
		this.markierungDeleted = markierungDeleted;
	}
	public String getBewertungText() {
		return bewertungText;
	}
	public void setBewertungText(String bewertungText) {
		this.bewertungText = bewertungText;
	}
	public double getBewertungStern() {
		return bewertungStern;
	}
	public void setBewertungStern(double bewertungStern) {
		this.bewertungStern = bewertungStern;
	}
	
	

}
