/**
 * Created on Sep 20, 2011
 */
package info.halo9pan.examples.prospring3.ch4.xml;

import info.halo9pan.examples.prospring3.ch4.MessageProvider;

/**
 * @author Clarence
 *
 */
public class ConfigurableMessageProvider implements MessageProvider {

	private String message;

	public ConfigurableMessageProvider() {
	}

	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}