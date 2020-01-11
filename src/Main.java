import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		// Kunden erfassen
		List<Kunde> kundelist = Data.getKundenDaten();
		// Kunden ausgeben
		List<Kunde> kundelist2 = new ArrayList<Kunde>();

		// Admin erfassen
		List<Admin> adminlist = new ArrayList<Admin>();
		// Admin ausgeben
		List<Admin> adminlist2 = new ArrayList<Admin>();

		// Ein Kundenfile wird angelegt
		try {
			FileOutputStream fos = new FileOutputStream("KundeObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(kundelist);
			System.out.println("Done");
			// closing resources
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Die Kunden werden ausgelesen und in der Console ausgegeben
		try {
			FileInputStream fis = new FileInputStream("KundeObject.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// write object to file
			kundelist2 = (List<Kunde>) ois.readObject();
			System.out.println("Done");
			// closing resources
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Die Kunden werden ausgegeben
		for (Kunde kunde : kundelist2) {
			System.out.println("Benutzername: " + kunde.getBenutzername() + " Passwort: " + kunde.getPasswort());
		}
	}
}