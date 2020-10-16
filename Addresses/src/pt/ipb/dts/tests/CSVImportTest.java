package pt.ipb.dts.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import pt.ipb.dts.entity.Address;
import pt.ipb.dts.entity.Person;
import pt.ipb.dts.importer.CSVImporter;

public class CSVImportTest {

	public static void main(String[] args) {
		
		List<Person> addressBookList = new ArrayList<>();
		
		Person person1  = new Person("Silva Mendes", new Address("Rua das Flores", "Braganca"), new Address("Rua de Cima", "Mirandela"));
		addressBookList.add(person1);
		
		Person person2  = new Person("Monteiro Rodrigues", new Address("Campo Maritimo", "Lisboa"));
		addressBookList.add(person2);
		
		Person person3  = new Person("Carvalho Silva", new Address("Avenida Fechada", "Porto"), new Address("Avenida Aberta", "Lisboa"), new Address("Somewhere", "citywide"));
		addressBookList.add(person3);
		
		List<Person> imported = new CSVImporter(System.getProperty("user.dir").replace("\\","\\\\") + "\\Addresses\\src\\CSVFiles/addresses.csv").read();

		assertEquals(addressBookList, imported);
		
	}
	
}
