package info.halo9pan.experiment.java8.lambda;

@FunctionalInterface
public interface Action {
	
	void run(String param);

	default void stop(String param) {
	}
}
