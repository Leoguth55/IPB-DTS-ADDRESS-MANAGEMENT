package pt.ipb.dts.importer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pt.ipb.dts.entity.Address;
import pt.ipb.dts.entity.Person;

public class CSVImporter implements Importer {
	
	String fileName;
	
	public CSVImporter(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<Person> read() {
		List<Person> l = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			String line = null;
			while((line = reader.readLine())!=null) {
				String[] sections = line.split(",");
				Person p = new Person(sections[0]);
				if(l.contains(p)) {
					p = l.get(l.indexOf(p));
				} else {
					l.add(p);
				}
				Address a = new Address(sections[1], sections[2]);
				p.getAddresses().add(a);
				a.getPeople().add(p);
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return l;
	}

}
