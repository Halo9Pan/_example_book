/**
 * Created on Nov 7, 2011
 */
package info.halo9pan.examples.prospring3.ch13;

import info.halo9pan.examples.prospring3.ch13.service.ContactService;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class TxProgrammaticSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:tx-programmatic-app-context.xml");
		ctx.refresh();

		ContactService contactService = ctx.getBean("contactService", ContactService.class);

		System.out.println("Contact count: " + contactService.countAll());

	}

}
