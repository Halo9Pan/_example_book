/**
 * Created on Dec 21, 2011
 */
package info.halo9pan.examples.prospring3.ch23.repository;

import info.halo9pan.examples.prospring3.ch23.domain.Contact;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

}
