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
		List<Kunde> kundelist = new ArrayList<Kunde>();
		// Kunden ausgeben
		List<Kunde> kundelist2 = new ArrayList<Kunde>();

		// Admin erfassen
		List<Admin> adminlist = new ArrayList<Admin>();
		// Admin ausgeben
		List<Admin> adminlist2 = new ArrayList<Admin>();

		// Die Kunden werden instanziert für die Erfassung
		Kunde kunde1 = new Kunde();
		kunde1.setBenutzername("Amina");
		kunde1.setPasswort("ILoveHWZ");

		Kunde kunde2 = new Kunde();
		kunde2.setBenutzername("Josip");
		kunde2.setPasswort("ILoveUML");

		Kunde kunde3 = new Kunde();
		kunde3.setBenutzername("Annika");
		kunde3.setPasswort("ILoveJava");

		// Der Admin wird instanziert für die Erfassung
		Admin admin1 = new Admin();
		admin1.setBenutzername("Schweiz Tourismus");
		admin1.setPasswort("ILoveSwitzerland");

		// Die instanzierte Kunden wird der Liste zugefügt
		kundelist.add(kunde1);
		kundelist.add(kunde1);
		kundelist.add(kunde3);

		// Der instanzierte Admin wird der Liste zugefügt
		adminlist.add(admin1);

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