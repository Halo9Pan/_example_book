/**
 * Created on Oct 18, 2011
 */
package info.halo9pan.examples.prospring3.ch10.repository;

import info.halo9pan.examples.prospring3.ch10.domain.Contact;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

	public List<Contact> findByFirstName(String firstName);

	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

}
