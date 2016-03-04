/**
 * Created on Dec 28, 2011
 */
package info.halo9pan.examples.prospring3.ch20.repository;

import info.halo9pan.examples.prospring3.ch20.domain.Contact;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

	@Query("select c from Contact c left join fetch c.hobbies h where c.id = :id")
	public Contact findByIdWithDetail(@Param("id") Long id);

}
