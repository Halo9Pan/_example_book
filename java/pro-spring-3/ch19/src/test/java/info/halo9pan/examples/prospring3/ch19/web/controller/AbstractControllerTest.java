/**
 * Created on Jan 4, 2012
 */
package info.halo9pan.examples.prospring3.ch19.web.controller;

import info.halo9pan.examples.prospring3.ch19.test.config.ControllerTestConfig;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Clarence
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ControllerTestConfig.class })
@ActiveProfiles("test")
public class AbstractControllerTest {

}
