package pt.ipb.dts.importer;

import java.util.List;

import pt.ipb.dts.entity.Person;

public interface Importer {

	List<Person> read();
}
