package veranstalter;
import java.util.ArrayList;
import java.util.List;

public class Veranstalter {

	private int id;
	private String veranstalter;
	private String beschreibung;
	
	private ArrayList<Aktivitaet> aktivitaeten;
	
	public Veranstalter(int id, String veranstalter, String beschreibung) {
		this.id = id;
		this.veranstalter = veranstalter;
		this.beschreibung = beschreibung;
	}
	
	public int getId() {
		return id;
	}
	
	public String getVeranstalter() {
		return veranstalter;
	}
	public void setVeranstalter(String veranstalter) {
		this.veranstalter = veranstalter;
	}
	public ArrayList<String> getAnzeigeBewertungText() {
		return veranstaltungen.stream().flatMap(v.getA)
	}
	public void setAnzeigeBewertungText(String anzeigeBewertungText) {
		this.anzeigeBewertungText = anzeigeBewertungText;
	}
	public List<Double> getAnzeigeBewertungStern() {
		return anzeigeBewertungStern;
	}
	public void setAnzeigeBewertungStern(String anzeigeBewertungStern) {
		this.anzeigeBewertungStern = anzeigeBewertungStern;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public ArrayList<Aktivitaet> getAktivitaeten(){
		return aktivitaeten;
	}
	
	public void aktivitaetHinzufügen(Aktivitaet aktivitaet) {
		
	}
	
}
