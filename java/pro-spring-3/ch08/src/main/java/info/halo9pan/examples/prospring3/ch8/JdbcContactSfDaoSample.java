/**
 * Created on Nov 16, 2011
 */
package info.halo9pan.examples.prospring3.ch8;

import info.halo9pan.examples.prospring3.ch8.dao.ContactSfDao;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class JdbcContactSfDaoSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-sf.xml");
		ctx.refresh();

		ContactSfDao contactSfDao = ctx.getBean("contactSfDao", ContactSfDao.class);

		System.out.println(contactSfDao.getFirstNameById(1l));
	}

}
