/**
 * Created on Sep 30, 2011
 */
package info.halo9pan.examples.prospring3.ch6.aspectjexppc;

import info.halo9pan.examples.prospring3.ch6.staticpc.SimpleAdvice;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author Clarence
 *
 */
public class AspectjexpPointcutExample {

	public static void main(String[] args) {
		AspectjexpBean target = new AspectjexpBean();

		// create the advisor
		AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
		pc.setExpression("execution(* foo*(..))");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

		// create the proxy
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		AspectjexpBean proxy = (AspectjexpBean) pf.getProxy();

		proxy.foo1();
		proxy.foo2();
		proxy.bar();
	}
}
