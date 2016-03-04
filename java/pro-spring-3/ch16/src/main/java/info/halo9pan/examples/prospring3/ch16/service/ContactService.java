/**
 * Created on Nov 25, 2011
 */
package info.halo9pan.examples.prospring3.ch16.service;

import info.halo9pan.examples.prospring3.ch16.domain.Contact;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactService {

	public List<Contact> findAll();

	public List<Contact> findByFirstName(String firstName);

	public Contact findById(Long id);

	public Contact save(Contact contact);

	public void delete(Contact contact);

}
