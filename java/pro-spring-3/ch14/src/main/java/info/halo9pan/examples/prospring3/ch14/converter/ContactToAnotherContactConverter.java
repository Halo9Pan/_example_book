/**
 * Created on Nov 22, 2011
 */
package info.halo9pan.examples.prospring3.ch14.converter;

import info.halo9pan.examples.prospring3.ch14.domain.AnotherContact;
import info.halo9pan.examples.prospring3.ch14.domain.Contact;

import org.springframework.core.convert.converter.Converter;

/**
 * @author Clarence
 *
 */
public class ContactToAnotherContactConverter implements Converter<Contact, AnotherContact> {

	public AnotherContact convert(Contact contact) {
		AnotherContact anotherContact = new AnotherContact();
		anotherContact.setFirstName(contact.getLastName());
		anotherContact.setLastName(contact.getFirstName());
		anotherContact.setBirthDate(contact.getBirthDate());
		anotherContact.setPersonalSite(contact.getPersonalSite());

		return anotherContact;
	}

}
