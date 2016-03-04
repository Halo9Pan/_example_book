package info.halo9pan.experiment.java8.collections;

import java.util.List;

import info.halo9pan.experiment.java8.Person;

public class NewLoop {

	public static void main(String[] args) {
		NewLoop nl = new NewLoop();
		nl.classic();
		nl.future();
	}

	private void classic() {
		List<Person> persons = Person.asList(new Person("Joe"), new Person("Jim"), new Person("John"));
		for (Person person : persons) {
			printName(person);
		}
	}

	private void future() {
		List<Person> persons = Person.asList(new Person("Joe"), new Person("Jim"), new Person("John"));
		persons.forEach(this::printName);
	}
	
	private void printName(Person person){
		System.out.println(person.name);
	}

}
