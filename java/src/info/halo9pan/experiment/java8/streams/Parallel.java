package info.halo9pan.experiment.java8.streams;

import info.halo9pan.experiment.java8.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Parallel {

	public static void main(String[] args) {
//		List<Person> persons = Person.asList(new Person("Joe"), new Person("Jim"), new Person("John"));
		List<String> personNames = Arrays.asList("Joe", "Jim", "John");
		List<Person> persons = personNames.stream().parallel().map(name -> new Person(name)).collect(Collectors.toList());
		Optional<Integer> personNamesLength = personNames.stream().parallel().map(name -> name.length()).reduce((a, b) -> a+b);
		System.out.println(personNamesLength.get());
		List<Person> list = persons.stream().parallel().collect(Collectors.toList());
		list.forEach(System.out::println);
		List<Person> filterList = persons.stream().parallel().filter(p -> p.name == "Jim").collect(Collectors.toList());
		filterList.forEach((p) -> System.out.print(p + " "));
	}

}
