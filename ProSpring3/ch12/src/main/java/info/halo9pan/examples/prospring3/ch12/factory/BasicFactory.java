/**
 * Created on Nov 2, 2011
 */
package info.halo9pan.examples.prospring3.ch12.factory;

import info.halo9pan.examples.prospring3.ch12.service.OrderService;
import info.halo9pan.examples.prospring3.ch12.service.impl.DefaultOrderServiceImpl;

/**
 * @author Clarence
 * 
 */
public class BasicFactory {
	private static final BasicFactory instance;
	private OrderService orderService;

	static {
		instance = new BasicFactory();
	}

	public static BasicFactory getlnstance() {
		return instance;
	}

	public BasicFactory() {
		this.orderService = new DefaultOrderServiceImpl();
	}

	public OrderService getOrderService() {
		return this.orderService;
	}
}
