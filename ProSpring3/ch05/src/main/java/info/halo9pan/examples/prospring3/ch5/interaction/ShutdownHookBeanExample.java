/*
 * Created on Sep 25, 2011
 */
package info.halo9pan.examples.prospring3.ch5.interaction;

import info.halo9pan.examples.prospring3.ch5.lifecycle.DestructiveBeanWithInterface;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class ShutdownHookBeanExample {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("interaction/shutdownHook.xml");
		ctx.refresh();

		DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");
	}
}