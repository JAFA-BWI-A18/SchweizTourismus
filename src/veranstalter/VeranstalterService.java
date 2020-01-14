package veranstalter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class VeranstalterService {

	private List<Veranstalter> veranstalter;
	private List<Aktivitaet> aktivitaeten;
	private List<Veranstaltung> veranstaltungen;

	public VeranstalterService() {
		this.veranstalter = new ArrayList<>();
		this.aktivitaeten = new ArrayList<>();
		this.veranstaltungen = new ArrayList<>();
	}

	public List<Veranstalter> getVeranstalter(){
		return veranstalter;
	}
	public List<Aktivitaet> getAktivitaet(){
		return aktivitaeten;
	}
	public List<Veranstaltung> getVeranstaltung (){
		return veranstaltungen;
	}
	
	public Veranstalter veranstalterErfassen(String veranstalterStr, String beschreibung) {
		Veranstalter tmp = new Veranstalter(veranstalterStr, beschreibung);
		veranstalter.add(tmp);
		return tmp;
	}

	public void veranstalterLoeschen(Veranstalter v) {
		veranstalter.remove(v);
	}

	public Aktivitaet aktivitaetErfassen(Veranstalter v, String art, String ort, int plz, String beschrieb) {
		Aktivitaet tmp = new Aktivitaet(art, ort, plz, v, beschrieb);
		v.aktivitaetHinzufügen(tmp);
		aktivitaeten.add(tmp);
		return tmp;
	}

	public Veranstaltung veranstaltungErfassen(Aktivitaet a, LocalDateTime datum, double preis,
			int totalPlaetze) {
		Veranstaltung tmp = new Veranstaltung(a, datum, preis, totalPlaetze);
		a.veranstaltungHinzufügen(tmp);
		veranstaltungen.add(tmp);
		return tmp;
	}
	
	public String bewertungHinzufuegen(Aktivitaet a, String text, int stern) {
		Bewertung tmp = new Bewertung(text, stern);
		a.bewertungHinzugügen(tmp);
		if(tmp.getBewertungText() != null && !tmp.getBewertungText().isBlank()) {
			return "couponCode";	
		}
		return null;

	}
}