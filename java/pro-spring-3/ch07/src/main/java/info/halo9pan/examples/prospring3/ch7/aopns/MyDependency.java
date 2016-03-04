/*
 * Created on Oct 8, 2011
 */
package info.halo9pan.examples.prospring3.ch7.aopns;

/**
 * @author clarence
 */
public class MyDependency {

	public void foo(int intValue) {
		System.out.println("foo(int): " + intValue);
	}

	public void bar() {
		System.out.println("bar()");
	}
}
