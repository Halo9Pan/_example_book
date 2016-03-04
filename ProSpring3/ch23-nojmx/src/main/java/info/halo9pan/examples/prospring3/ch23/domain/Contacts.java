/**
 * Created on Nov 29, 2011
 */
package info.halo9pan.examples.prospring3.ch23.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author Clarence
 *
 */
public class Contacts implements Serializable {

	private List<Contact> contacts;

	public Contacts() {
	}

	public Contacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
