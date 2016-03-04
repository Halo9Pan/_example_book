/**
 * Created on Oct 20, 2011
 */
package info.halo9pan.examples.prospring3.ch10;

import info.halo9pan.examples.prospring3.ch10.domain.ContactSummary;
import info.halo9pan.examples.prospring3.ch10.service.ContactSummaryService;
import info.halo9pan.examples.prospring3.ch10.service.jpa.ContactSummaryUntypeImpl;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class ContactSummarySample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();

		// Contact summary with untype result
		ContactSummaryUntypeImpl contactSummaryUntype = ctx
				.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
		contactSummaryUntype.displayAllContactSummary();

		// Contact summary with constructor expression
		ContactSummaryService contactSummaryService = ctx.getBean("contactSummaryService", ContactSummaryService.class);
		List<ContactSummary> contacts = contactSummaryService.findAll();

		for (ContactSummary contactSummary : contacts) {
			System.out.println(contactSummary);
		}

	}

}
