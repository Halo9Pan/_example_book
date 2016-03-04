package info.halo9pan.experiment.thread.sync;

import info.halo9pan.experiment.thread.Runner;

public class FieldPlus extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("没有synchronized关键字，identifier++");
		FieldPlus demo = new FieldPlus();
		demo.THREAD_NUMBER = 1000;
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new FieldPlusRunner();
		return runner;
	}

}

class FieldPlusRunner extends Runner {

	@Override
	public void doSomething(int invoker) {
		long time = getRunTime();
		try {
			Thread.sleep((long) (time * 0.5));
			this.identifier++;
			Thread.sleep((long) (time * 0.5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
