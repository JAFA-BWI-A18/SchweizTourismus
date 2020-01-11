package veranstalter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Veranstaltung {

	private int id;
	private LocalDate zeit;
	private LocalDate datum;
	private double preis;
	private int freiePlaetze;
	private int totalPlaetze;
	private boolean offline;
	private Integer aktivitaetId;
	
	
	public LocalDate getZeit() {
		return zeit;
	}
	public void setZeit(LocalDate zeit) {
		this.zeit = zeit;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
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
	
	public Integer getAktivitaetId() {
		return aktivitaetId;
	}
		
	public void setAktivitaet(Aktivitaet aktivitaet) {
		this.aktivitaetId = aktivitaet.getId();
	}

}
