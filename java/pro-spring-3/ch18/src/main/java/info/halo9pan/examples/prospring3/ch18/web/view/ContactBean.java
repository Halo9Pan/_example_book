/**
 * Created on Dec 30, 2011
 */
package info.halo9pan.examples.prospring3.ch18.web.view;

import info.halo9pan.examples.prospring3.ch18.domain.Contact;
import info.halo9pan.examples.prospring3.ch18.domain.Hobby;

import java.io.Serializable;

import org.primefaces.model.DualListModel;

/**
 * @author Clarence
 *
 */
public class ContactBean implements Serializable {

	private Contact contact;

	private DualListModel<Hobby> hobbies;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public DualListModel<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(DualListModel<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

}
