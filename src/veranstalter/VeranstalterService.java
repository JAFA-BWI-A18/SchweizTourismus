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

	public Veranstalter veranstalterErfassen(String veranstalterStr, String beschreibung) {
		Veranstalter tmp = new Veranstalter(veranstalterStr, beschreibung);
		veranstalter.add(tmp);
		return tmp;
	}

	public void veranstalterLoeschen(Veranstalter v) {
		veranstalter.remove(v);
	}

	public Aktivitaet aktivitaetErfassen(Veranstalter v, String art, String ort, int plz) {
		Aktivitaet tmp = new Aktivitaet(art, ort, plz, v);
		v.aktivitaetHinzufügen(tmp);
		aktivitaeten.add(tmp);
		return tmp;
	}

	public Veranstaltung veranstaltungErfassen(Aktivitaet a, LocalDateTime datum, double preis, int freiePlaetze,
			int totalPlaetze, boolean offline) {
		Veranstaltung tmp = new Veranstaltung(a, datum, preis, freiePlaetze, totalPlaetze, offline);
		a.veranstaltungHinzufügen(tmp);
		veranstaltungen.add(tmp);
		return tmp;
	}
	
	public String bewertungHinzufügen(Aktivitaet a, String text, int stern) {
		Bewertung tmp = new Bewertung(text, stern);
		a.bewertungHinzugügen(tmp);
		if(tmp.getBewertungText() != null && !tmp.getBewertungText().isBlank()) {
			return "couponCode";	
		}
		return null;

	}

}
