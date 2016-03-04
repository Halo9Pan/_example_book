/**
 * Created on Oct 6, 2011
 */
package info.halo9pan.examples.prospring3.ch8.dao;

import info.halo9pan.examples.prospring3.ch8.domain.Contact;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactDao {

	public List<Contact> findAll();

	public List<Contact> findAllWithDetail();

	public List<Contact> findByFirstName(String firstName);

	public String findFirstNameById(Long id);

	public String findLastNameById(Long id);

	public void insert(Contact contact);

	public void update(Contact contact);

	public void delete(Long contactId);

	public void insertWithDetail(Contact contact);

}
