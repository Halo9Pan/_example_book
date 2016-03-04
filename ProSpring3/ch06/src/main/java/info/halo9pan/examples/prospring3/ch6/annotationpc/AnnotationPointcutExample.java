/*
 * Created on Sep 30, 2011
 */
package info.halo9pan.examples.prospring3.ch6.annotationpc;

import info.halo9pan.examples.prospring3.ch6.staticpc.SimpleAdvice;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 * @author clarence
 */
public class AnnotationPointcutExample {

	public static void main(String[] args) {
		SampleAnnotationBean target = new SampleAnnotationBean();

		// create the advisor
		AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

		// create the proxy
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		SampleAnnotationBean proxy = (SampleAnnotationBean) pf.getProxy();

		proxy.foo(100);
		proxy.bar();

	}

}
