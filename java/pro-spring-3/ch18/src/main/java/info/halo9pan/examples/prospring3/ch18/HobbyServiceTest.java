/**
 * Created on Dec 21, 2011
 */
package info.halo9pan.examples.prospring3.ch18;

import info.halo9pan.examples.prospring3.ch18.domain.Hobby;
import info.halo9pan.examples.prospring3.ch18.service.HobbyService;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class HobbyServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jpa-app-context.xml");
		ctx.refresh();

		System.out.println("App context initialized successfully");

		HobbyService hobbyService = ctx.getBean("hobbyService", HobbyService.class);

		List<Hobby> hobbies = hobbyService.findAll();

		for (Hobby hobby : hobbies) {
			System.out.println(hobby.getHobbyId());
		}

	}

}
