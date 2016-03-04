/**
 * Created on Oct 18, 2011
 */
package info.halo9pan.examples.prospring3.ch10.repository;

import info.halo9pan.examples.prospring3.ch10.domain.ContactAudit;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Clarence
 *
 */
public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {

}
