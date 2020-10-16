package pt.ipb.dts.entity;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	String name;
	
	List<Address> addresses = new ArrayList<>();

	public Person(String name, Address... addresses) {
		super();
		this.name = name;
		for(Address a : addresses) {
			this.addresses.add(a);
			a.getPeople().add(this);
		}
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person add(Address a) {
		this.addresses.add(a);
		a.getPeople().add(this);
		return this;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(Address address : getAddresses()) {
			str.append(getName()+"; "+address.getStreet()+" - "+address.getCity()+"\n");
		}
		return str.toString();
	}
	
	

}
