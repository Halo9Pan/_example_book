package info.halo9pan.experiment.java8;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	public String name;

	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public static List<Person> asList(Person... people){
		List<Person> list = new ArrayList<Person>();
		for(int i = 0; i < people.length; i++){
			list.add(people[i]);
		}
		return list;
	}

}
