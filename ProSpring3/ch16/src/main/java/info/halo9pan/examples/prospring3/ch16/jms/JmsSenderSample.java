/**
 * Created on Nov 25, 2011
 */
package info.halo9pan.examples.prospring3.ch16.jms;

import info.halo9pan.examples.prospring3.ch16.jms.sender.MessageSender;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Clarence
 *
 */
public class JmsSenderSample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jms-sender-app-context.xml");
		ctx.refresh();

		// Send message
		MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);

		messageSender.sendMessage("Clarence testing JMS message");
	}

}
