/*
 * Created on Sep 30, 2011
 */
package info.halo9pan.examples.prospring3.ch6.proxies;

/**
 * @author clarence
 */
public class SimpleBean implements ISimpleBean {

	private long dummy = 0;

	public void advised() {
		dummy = System.currentTimeMillis();
	}

	public void unadvised() {
		dummy = System.currentTimeMillis();
	}
}
