/**
 * Created on Dec 21, 2011
 */
package info.halo9pan.examples.prospring3.ch19.repository;

import info.halo9pan.examples.prospring3.ch19.domain.Contact;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

}
