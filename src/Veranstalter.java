
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Veranstalter {

//Attribute
	private String veranstalter;
	private String beschreibung;

	private ArrayList<Aktivitaet> aktivitaeten;

//Konstruktor
	public Veranstalter(String veranstalter, String beschreibung) {
		this.veranstalter = veranstalter;
		this.beschreibung = beschreibung;
		this.aktivitaeten = new ArrayList<>();
	}

//Getters und Setters
	public String getVeranstalter() {
		return veranstalter;
	}

	public void setVeranstalter(String veranstalter) {
		this.veranstalter = veranstalter;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public ArrayList<Aktivitaet> getAktivitaeten() {
		return aktivitaeten;
	}

	public void aktivitaetHinzufügen(Aktivitaet aktivitaet) {
		this.aktivitaeten.add(aktivitaet);
	}

	@Override
	public String toString() {
		return "Veranstalter [veranstalter=" + veranstalter + ", beschreibung=" + beschreibung + "]";
	}

//Methoden
	public List<String> getAnzeigeBewertungText() {
		return aktivitaeten.stream().flatMap(a -> a.getBewertungText().stream()).collect(Collectors.toList());
	}

	public double getAnzeigeBewertungStern() {
		List<Integer> sterne = aktivitaeten.stream().flatMap(a -> a.getBewertungStern().stream())
				.collect(Collectors.toList());
		if (sterne.size() > 0) {
			return sterne.stream().mapToDouble(Double::valueOf).sum() / (double) sterne.size();
		}
		return -1;
	}
}