/**
 * Created on Sep 20, 2011
 */
package info.halo9pan.examples.prospring3.ch4.annotation;

import info.halo9pan.examples.prospring3.ch4.Oracle;

import org.springframework.stereotype.Service;

/**
 * @author Clarence
 *
 */
@Service("oracle")
public class BookwormOracle implements Oracle {

	public String defineMeaningOfLife() {
		return "Encyclopedias are a waste of money - use the Internet";
	}

}
