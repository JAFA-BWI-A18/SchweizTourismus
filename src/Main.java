
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

//		Person eintragen und speicher
		List<Person> personlist = new ArrayList<Person>();
//		Person wiedergeben
		List<Person> personlist2 = new ArrayList<Person>();

//		Person muss jeweils Instanziert werden um sie zu erfassen
		Person person1 = new Person();
		person1.setNachname("Salihovic");
		person1.setVorname("Amina");

		Person person2 = new Person();
		person2.setNachname("Ivankovic");
		person2.setVorname("Josip");

		Person person3 = new Person();
		person3.setNachname("Perrozzi");
		person3.setVorname("Annika");

//		Die Instanzierte Person muss der Liste zugefügt werden
		personlist.add(person1);
		personlist.add(person2);
		personlist.add(person3);

//		Eine Personenfile wird angelegt
		try {
			FileOutputStream fos = new FileOutputStream("PersonObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(personlist);
			System.out.println("Done");
			// closing resources
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		Die Person wird ausgelesen und in der Console wiedergegeben
		try {
			FileInputStream fis = new FileInputStream("PersonObject.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// write object to file
			personlist2 = (List<Person>) ois.readObject();
			System.out.println("Done");
			// closing resources
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

//		Personen werden herausgegeben
		for (Person person : personlist2) {
			System.out.println(person.getVorname() + " " + person.getNachname());
		}
	}
}

