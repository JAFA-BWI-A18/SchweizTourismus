
import java.time.LocalDateTime;

public class Veranstaltung {

//Attribute
	private LocalDateTime datum;
	private double preis;
	private int totalPlaetze;
	private boolean offline;
	private Aktivitaet aktivitaet;

//Konstruktoren
	public Veranstaltung(Aktivitaet aktivitaet, LocalDateTime datum, double preis, int totalPlaetze) {
		this.datum = datum;
		this.preis = preis;
		this.totalPlaetze = totalPlaetze;
		this.offline = false;
		this.aktivitaet = aktivitaet;
	}

	public Veranstaltung() {
	}

//Getters und Setters erstellt
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

	@Override
	public String toString() {
		return "Veranstaltung [datum=" + datum + ", preis=" + preis + ", totalPlaetze=" + totalPlaetze + ", offline="
				+ offline + ", aktivitaet=" + aktivitaet.getBeschrieb() + "]";
	}
}