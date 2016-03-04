/*
 * Created on Sep 30, 2011
 */
package info.halo9pan.examples.prospring3.ch6.namepc;

import info.halo9pan.examples.prospring3.ch6.staticpc.SimpleAdvice;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author clarence
 */
public class NamePointcutUsingAdvisor {

	public static void main(String[] args) {
		NameBean target = new NameBean();

		// create advisor
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
		advisor.addMethodName("foo");
		advisor.addMethodName("bar");

		// create the proxy
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		NameBean proxy = (NameBean) pf.getProxy();

		proxy.foo();
		proxy.foo(999);
		proxy.bar();
		proxy.yup();
	}
}