package info.halo9pan.experiment.java8.interfaces;

public interface IWrong {

	void run();

	default void init(String param) {
		System.out.println(param);
	}
/*	
	default int hashCode() {
		// This calss can't be compiled.
	}
*/
}
