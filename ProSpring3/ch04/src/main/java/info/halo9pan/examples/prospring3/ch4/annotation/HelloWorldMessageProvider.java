/**
 * Created on Sep 11, 2011
 */
package info.halo9pan.examples.prospring3.ch4.annotation;

import info.halo9pan.examples.prospring3.ch4.MessageProvider;

import org.springframework.stereotype.Service;

/**
 * @author Clarence
 *
 */
// @Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {

		return "Hello World!";
	}

}
