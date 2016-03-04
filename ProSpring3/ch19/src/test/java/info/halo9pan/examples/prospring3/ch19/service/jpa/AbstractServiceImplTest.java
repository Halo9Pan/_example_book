/**
 * Created on Jan 4, 2012
 */
package info.halo9pan.examples.prospring3.ch19.service.jpa;

import info.halo9pan.examples.prospring3.ch19.test.config.ServiceTestConfig;
import info.halo9pan.examples.prospring3.ch19.test.listener.ServiceTestExecutionListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Clarence
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class })
@TestExecutionListeners({ ServiceTestExecutionListener.class })
@ActiveProfiles("test")
public abstract class AbstractServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	@PersistenceContext
	protected EntityManager em;

}
