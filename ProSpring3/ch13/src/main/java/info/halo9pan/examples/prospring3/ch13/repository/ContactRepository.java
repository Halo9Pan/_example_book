/**
 * Created on Oct 18, 2011
 */
package info.halo9pan.examples.prospring3.ch13.repository;

import info.halo9pan.examples.prospring3.ch13.domain.Contact;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

	@Query("select count(c) from Contact c")
	public Long countAllContacts();

}
