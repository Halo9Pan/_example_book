/**
 * Created on Oct 24, 2011
 */
package info.halo9pan.examples.prospring3.ch11.persistence;

import info.halo9pan.examples.prospring3.ch11.domain.Contact;
import info.halo9pan.examples.prospring3.ch11.domain.SearchCriteria;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactMapper {

	public List<Contact> findAll();

	public List<Contact> findAllWithDetail();

	public Contact findById(Long id);

	public List<Contact> findByFirstNameAndLastName(SearchCriteria criteria);

	public void insertContact(Contact contact);

	public void updateContact(Contact contact);

	public void deleteContact(Long id);

}
