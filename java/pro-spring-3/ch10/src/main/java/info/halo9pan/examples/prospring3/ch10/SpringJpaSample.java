/**
 * Created on Oct 18, 2011
 */
package info.halo9pan.examples.prospring3.ch10;

import info.halo9pan.examples.prospring3.ch10.domain.Contact;
import info.halo9pan.examples.prospring3.ch10.service.ContactService;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class SpringJpaSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-data-app-context.xml");
		ctx.refresh();

		System.out.println("App Context initialized successfully");

		ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);

		// Find all contacts
		List<Contact> contacts = contactService.findAll();
		listContacts(contacts);

		// Find contacts by first name
		contacts = contactService.findByFirstName("Clarence");
		listContacts(contacts);

		// Find contacts by first name and last name
		contacts = contactService.findByFirstNameAndLastName("Clarence", "Ho");
		listContacts(contacts);

	}

	private static void listContacts(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();
		}
	}

}
