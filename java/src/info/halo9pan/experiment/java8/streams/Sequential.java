package info.halo9pan.experiment.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import info.halo9pan.experiment.java8.Person;

public class Sequential {

	public static void main(String[] args) {
//		List<Person> persons = Person.asList(new Person("Joe"), new Person("Jim"), new Person("John"));
		List<String> personNames = Arrays.asList("Joe", "Jim", "John");
		List<Person> persons = personNames.stream().map(name -> new Person(name)).collect(Collectors.toList());
		List<Person> list = persons.stream().collect(Collectors.toList());
		list.forEach(System.out::println);
		List<Person> filterList = persons.stream().filter(p -> p.name == "Jim").collect(Collectors.toList());
		filterList.forEach((p) -> System.out.print(p + " "));
	}

}
