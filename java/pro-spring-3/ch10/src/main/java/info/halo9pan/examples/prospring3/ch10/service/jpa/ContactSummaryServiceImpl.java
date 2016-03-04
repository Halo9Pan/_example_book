/**
 * Created on Oct 17, 2011
 */
package info.halo9pan.examples.prospring3.ch10.service.jpa;

import info.halo9pan.examples.prospring3.ch10.domain.ContactSummary;
import info.halo9pan.examples.prospring3.ch10.service.ContactSummaryService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Clarence
 *
 */
@Service("contactSummaryService")
@Repository
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public List<ContactSummary> findAll() {

		List<ContactSummary> result = em
				.createQuery("select new info.halo9pan.examples.prospring3.ch10.domain.ContactSummary(" + "c.firstName, c.lastName, t.telNumber) " + "from Contact c left join c.contactTelDetails t " + "where t.telType='Home'", ContactSummary.class)
				.getResultList();
		return result;
	}

}
