package info.halo9pan.experiment.java8.interfaces;

public interface IActionOne {

	void run();

	default void init() {
		System.out.println("interface one method.");
	}
	
}
