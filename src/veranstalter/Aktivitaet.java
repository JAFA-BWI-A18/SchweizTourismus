package veranstalter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aktivitaet {

	private String beschrieb;
	private String art; // Indoor Outdoor
	private String ort;
	private int plz;
	private boolean markierungDeleted;
	private Veranstalter veranstalter;
	private ArrayList<Veranstaltung> veranstaltung;
	private ArrayList<Bewertung> bewertungen;
	
	public Aktivitaet(String art, String ort, int plz, Veranstalter veranstalter, String beschrieb) {
		super();
		this.art = art;
		this.ort = ort;
		this.plz = plz;
		this.beschrieb = beschrieb;
		this.markierungDeleted = false;
		this.veranstalter = veranstalter;
		this.veranstaltung = new ArrayList<>();
		this.bewertungen = new ArrayList<>();
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

	public Veranstalter getVeranstalter() {
		return veranstalter;
	}
	
	public void bewertungHinzugügen(Bewertung b) {
		bewertungen.add(b);
	}

	public void veranstaltungHinzufügen(Veranstaltung v) {
		veranstaltung.add(v);
	}
	
	public List<Veranstaltung> getVeranstaltungen() {
		return veranstaltung;
	}

	public List<String> getBewertungText() {
		return bewertungen.stream().map(b -> b.getBewertungText()).collect(Collectors.toList());
	}

	public List<Integer> getBewertungStern() {
		return bewertungen.stream().map(b -> b.getBewertungStern()).collect(Collectors.toList());
	}
	
	public double getAnzeigeBewertungStern() {
		List<Integer> sterne =  getBewertungStern();
		if(sterne.size()> 0) {
			return sterne.stream().mapToDouble(Double::valueOf).sum() / (double) sterne.size();
		}
		return -1;
	}


	public String getBeschrieb() {
		return beschrieb;
	}

	public void setBeschrieb(String beschrieb) {
		this.beschrieb = beschrieb;
	}

	@Override
	public String toString() {
		return "Aktivitaet [beschrieb=" + beschrieb + ", art=" + art + ", ort=" + ort + ", plz=" + plz
				+ ", markierungDeleted=" + markierungDeleted + ", veranstalter=" + veranstalter.getVeranstalter() + "]";
	}
	
	
}
