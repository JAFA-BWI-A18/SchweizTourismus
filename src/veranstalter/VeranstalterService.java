package veranstalter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VeranstalterService {
	
	
	private HashMap<Integer, Veranstalter> veranstalter;
	private int veranstalterId;
	
	public VeranstalterService() {
		this.veranstalter =  new HashMap<>();
		veranstalterId = 1;
	}	
	
	public Veranstalter veranstalterErfassen(String veranstalterStr, String beschreibung) {
		Veranstalter tmp = new Veranstalter(veranstalterId++, veranstalterStr, beschreibung);
		veranstalter.put(tmp.getId(), tmp);
		return tmp;
	}
	
	
	public void veranstalterLoeschen(Veranstalter v) {
		veranstalter.remove(v.getId());
	}
}
