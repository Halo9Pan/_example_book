/**
 * Created on Oct 17, 2011
 */
package info.halo9pan.examples.prospring3.ch10.service;

import info.halo9pan.examples.prospring3.ch10.domain.ContactSummary;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface ContactSummaryService {

	public List<ContactSummary> findAll();

}
