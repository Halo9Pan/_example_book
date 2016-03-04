package info.halo9pan.experiment.thread.atom;

import info.halo9pan.experiment.thread.Runner;

import java.util.concurrent.atomic.AtomicInteger;

public class FieldIncrement extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("AtomicInteger++");
		FieldIncrement demo = new FieldIncrement();
		demo.THREAD_NUMBER = 1000;
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new FieldIncrementRunner();
		return runner;
	}

}

class FieldIncrementRunner extends Runner {

	private AtomicInteger atom = new AtomicInteger();

	@Override
	public void doSomething(int invoker) {
		long time = getRunTime();
		try {
			Thread.sleep((long) (time * 0.5));
			this.atom.getAndIncrement();
			Thread.sleep((long) (time * 0.5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.identifier = this.atom.get();
	}
}
