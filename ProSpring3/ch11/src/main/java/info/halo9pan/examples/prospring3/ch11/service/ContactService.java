/**
 * Created on Oct 24, 2011
 */
package info.halo9pan.examples.prospring3.ch11.service;

import info.halo9pan.examples.prospring3.ch11.domain.Contact;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactService {

	// Find all contacts - without details
	public List<Contact> findAll();

	// Find all contacts - with tels and hobbies
	public List<Contact> findAllWithDetail();

	// Find by ID - with tels and hobbies
	public Contact findById(Long id);

	// Create a new or save an existing contact
	public Contact save(Contact contact);

	// Delete a contact
	public void delete(Contact contact);

	// Find a contact by first name and last name
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

}
