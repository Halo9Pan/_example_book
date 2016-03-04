/*
 * Created on Sep 30, 2011
 */
package info.halo9pan.examples.prospring3.ch6.dynamicpc;

import info.halo9pan.examples.prospring3.ch6.staticpc.SimpleAdvice;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author clarence
 */
public class DynamicPointcutExample {

	public static void main(String[] args) {
		SampleBean target = new SampleBean();

		// create advisor
		Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAdvice());

		// create proxy
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		SampleBean proxy = (SampleBean) pf.getProxy();

		proxy.foo(1);
		proxy.foo(10);
		proxy.foo(100);

		proxy.bar();
		proxy.bar();
		proxy.bar();
	}
}