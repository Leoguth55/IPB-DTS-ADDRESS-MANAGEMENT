package pt.ipb.dts;

import java.util.List;

import pt.ipb.dts.entity.Person;
import pt.ipb.dts.importer.CSVImporter;
import pt.ipb.dts.importer.Importer;

public class Main {
	
	public static void main(String[] args) {
		Importer importer = new CSVImporter("C:\\Users\\leogu\\Documents\\IPB\\DTS/addresses.csv");
		List<Person> addressBook = importer.read();

		for(Person person : addressBook) {
			System.out.println(person);
		}
				
	}
	
}
