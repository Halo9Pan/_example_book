/*
 * Created on Oct 8, 2011
 */
package info.halo9pan.examples.prospring3.ch7.introductions;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * @author clarence
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {

	public IsModifiedAdvisor() {
		super(new IsModifiedMixin());
	}
}
