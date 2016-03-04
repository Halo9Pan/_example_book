/**
 * Created on Sep 20, 2011
 */
package info.halo9pan.examples.prospring3.ch4;

/**
 * @author Clarence
 *
 */
public class ContextualizedDependencyLookup implements ManagedComponent {

	private Dependency dependency;

	public void performLookup(Container container) {
		this.dependency = (Dependency) container.getDependency("myDependency");
	}

}
