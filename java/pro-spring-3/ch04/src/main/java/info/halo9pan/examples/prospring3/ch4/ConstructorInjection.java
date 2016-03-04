/**
 * Created on Sep 20, 2011
 */
package info.halo9pan.examples.prospring3.ch4;

/**
 * @author Clarence
 *
 */
public class ConstructorInjection {

	private Dependency dependency;

	public ConstructorInjection(Dependency dependency) {
		this.dependency = dependency;
	}

}
