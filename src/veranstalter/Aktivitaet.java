package veranstalter;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Aktivitaet {

	private int id;
	private String art; // Indoor Outdoor
	private String ort;
	private int plz;
	private boolean markierungDeleted;
	private Integer veranstalterId;
	private ArrayList<Veranstaltung> veranstaltung;
	private ArrayList<Bewertung> bewertungen;
	
	public int getId() {
		return id;
	}
	
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
	
	public Integer getVeranstalterId() {
		return veranstalterId;
	}
	
	public void bewertungHinzugügen(Bewertung bewertung) {
		bewertungen.add(bewertung);
	}
}
