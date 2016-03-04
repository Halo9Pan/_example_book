/**
 * Created on Oct 24, 2011
 */
package info.halo9pan.examples.prospring3.ch11.persistence;

import info.halo9pan.examples.prospring3.ch11.domain.ContactTelDetail;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactTelDetailMapper {

	public List<ContactTelDetail> selectTelDetailForContact(Long contactId);

	public void insertContactTelDetail(ContactTelDetail contactTelDetail);

	public void updateContactTelDetail(ContactTelDetail contactTelDetail);

	public void deleteOrphanContactTelDetail(List<Long> ids);

	public void deleteTelDetailForContact(Long contactId);

}
