/**
 * Created on Nov 7, 2011
 */
package info.halo9pan.examples.prospring3.ch13.service;

import info.halo9pan.examples.prospring3.ch13.domain.Contact;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactService {

	public List<Contact> findAll();

	public Contact findById(Long id);

	public Contact save(Contact contact);

	public long countAll();
}
