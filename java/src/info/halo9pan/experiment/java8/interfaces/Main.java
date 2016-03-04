package info.halo9pan.experiment.java8.interfaces;

public class Main {

	public static void main(String[] args) {
		IAction action = new IAction() {
			@Override
			public void run() {

			}
		};
		action.init("Hello!");
		IAction one = new ActionImpl();
		one.init("Hello, one.");
	}

}
