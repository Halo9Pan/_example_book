/**
 * Created on Nov 25, 2011
 */
package info.halo9pan.examples.prospring3.ch16.repository;

import info.halo9pan.examples.prospring3.ch16.domain.Contact;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

	public List<Contact> findByFirstName(String firstName);

}
