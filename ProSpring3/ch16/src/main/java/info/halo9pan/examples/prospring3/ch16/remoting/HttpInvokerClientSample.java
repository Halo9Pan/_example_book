/**
 * Created on Nov 25, 2011
 */
package info.halo9pan.examples.prospring3.ch16.remoting;

import info.halo9pan.examples.prospring3.ch16.domain.Contact;
import info.halo9pan.examples.prospring3.ch16.service.ContactService;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class HttpInvokerClientSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:http-invoker-app-context.xml");
		ctx.refresh();

		ContactService contactService = ctx.getBean("remoteContactService", ContactService.class);

		// Find all contacts
		System.out.println("Finding all contacts");
		List<Contact> contacts = contactService.findAll();
		listContacts(contacts);

		// Find contacts by first name
		System.out.println("Finding contact with first name equals Clarence");
		contacts = contactService.findByFirstName("Clarence");
		listContacts(contacts);

	}

	private static void listContacts(List<Contact> contacts) {

		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		System.out.println("");

	}

}
