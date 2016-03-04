/**
 * Created on Oct 12, 2011
 */
package info.halo9pan.examples.prospring3.ch9.dao;

import info.halo9pan.examples.prospring3.ch9.domain.Contact;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactDao {

	// Find all contacts
	public List<Contact> findAll();

	// Find all contacts with telephone and hobbies
	public List<Contact> findAllWithDetail();

	// Find a contact with details by id
	public Contact findById(Long id);

	// Insert or update a contact
	public Contact save(Contact contact);

	// Delete a contact
	public void delete(Contact contact);
}
