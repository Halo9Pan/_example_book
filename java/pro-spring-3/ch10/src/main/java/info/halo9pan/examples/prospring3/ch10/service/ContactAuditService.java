/**
 * Created on Oct 18, 2011
 */
package info.halo9pan.examples.prospring3.ch10.service;

import info.halo9pan.examples.prospring3.ch10.domain.ContactAudit;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactAuditService {

	public List<ContactAudit> findAll();

	public ContactAudit findById(Long id);

	public ContactAudit save(ContactAudit contact);

	public ContactAudit findAuditByRevision(Long id, int revision);

}
