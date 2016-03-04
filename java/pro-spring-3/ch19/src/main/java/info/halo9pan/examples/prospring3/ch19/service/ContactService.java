/**
 * Created on Dec 21, 2011
 */
package info.halo9pan.examples.prospring3.ch19.service;

import info.halo9pan.examples.prospring3.ch19.domain.Contact;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Clarence
 *
 */
public interface ContactService {

	public List<Contact> findAll();

	public Contact findById(Long id);

	public Contact findByFirstNameAndLastName(String firstName, String lastName);

	public Contact save(Contact contact);

	public Page<Contact> findAllByPage(Pageable pageable);

}
