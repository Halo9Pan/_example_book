/**
 * Created on Nov 7, 2011
 */
package info.halo9pan.examples.prospring3.ch13;

import info.halo9pan.examples.prospring3.ch13.domain.Contact;
import info.halo9pan.examples.prospring3.ch13.service.ContactService;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class TxJtaSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:tx-jta-app-context.xml");
		ctx.refresh();

		ContactService contactService = ctx.getBean("contactService", ContactService.class);

		Contact contact = new Contact();
		contact.setFirstName("Jta");
		contact.setLastName("Manager");
		contactService.save(contact);
		System.out.println("Contact saved successfully");

	}

}
