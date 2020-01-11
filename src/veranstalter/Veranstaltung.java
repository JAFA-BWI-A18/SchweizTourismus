package veranstalter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Veranstaltung {

	private LocalDateTime datum;
	private double preis;
	private int freiePlaetze;
	private int totalPlaetze;
	private boolean offline;
	private Aktivitaet aktivitaet;

	public Veranstaltung(Aktivitaet aktivitaet, LocalDateTime datum, double preis, int freiePlaetze, int totalPlaetze,
			boolean offline) {
		this.datum = datum;
		this.preis = preis;
		this.freiePlaetze = freiePlaetze;
		this.totalPlaetze = totalPlaetze;
		this.offline = offline;
		this.aktivitaet = aktivitaet;
	}

	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getFreiePlaetze() {
		return freiePlaetze;
	}

	public void setFreiePlaetze(int freiePlaetze) {
		this.freiePlaetze = freiePlaetze;
	}

	public int getTotalPlaetze() {
		return totalPlaetze;
	}

	public void setTotalPlaetze(int totalPlaetze) {
		this.totalPlaetze = totalPlaetze;
	}

	public boolean isOffline() {
		return offline;
	}

	public void setOffline(boolean offline) {
		this.offline = offline;
	}

	public Aktivitaet getAktivitaet() {
		return aktivitaet;
	}

}
