package info.halo9pan.experiment.java8.lambda;

public class Executor {

	@FunctionalInterface
	static interface Action {
		void run(String s);
	}

	void futureExecute(Action action) {
		action.run("Hello, lambda!");
	}

	void classicExecute() {
		(new Action() {
			public void run(String param) {
				System.out.println(param);
			}
		}).run("Goodbye, ugly old code style.");
	}

	public static void main(String[] args) {
		Executor executor = new Executor();
		executor.classicExecute();
		executor.futureExecute((String param) -> System.out.println(param));
		executor.futureExecute(param -> System.out.println(param));
		executor.futureExecute(System.out::println);

		executor.futureExecute(s -> System.out.println("*" + s + "*"));
	}
}
