/**
 * Created on Sep 21, 2011
 */
package info.halo9pan.examples.prospring3.ch4.annotation;

import info.halo9pan.examples.prospring3.ch4.Oracle;

import org.springframework.stereotype.Service;

/**
 * @author Clarence
 *
 */
@Service("injectRef")
public class InjectRef {

	private Oracle oracle;

	public void setOracle(Oracle oracle) {
		this.oracle = oracle;
		System.out.println(oracle.defineMeaningOfLife());
	}

}
