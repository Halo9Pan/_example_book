/**
 * Created on Dec 28, 2011
 */
package info.halo9pan.examples.prospring3.ch20.service;

import info.halo9pan.examples.prospring3.ch20.domain.Contact;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactService {

	public List<Contact> findAll();

	public Contact findById(Long id);

	public Contact findByIdWithDetail(Long id);

	public Contact save(Contact contact);

}
