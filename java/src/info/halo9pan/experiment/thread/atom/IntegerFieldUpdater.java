package info.halo9pan.experiment.thread.atom;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import info.halo9pan.experiment.thread.Runner;

public class IntegerFieldUpdater extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("No synchronized key word，AtomicInteger++");
		IntegerFieldUpdater demo = new IntegerFieldUpdater();
		demo.THREAD_NUMBER = 1000;
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new IntegerFieldUpdaterRunner();
		return runner;
	}

}

class IntegerTarget {
	volatile int number;

	protected int getNumber() {
		return number;
	}
}

class IntegerFieldUpdaterRunner extends Runner {

	private AtomicIntegerFieldUpdater<IntegerTarget> updater = AtomicIntegerFieldUpdater.newUpdater(IntegerTarget.class, "number");
	private IntegerTarget integerTarget = new IntegerTarget();

	@Override
	public void doSomething(int invoker) {
		long time = getRunTime();
		try {
			Thread.sleep((long) (time * 0.5));
			this.updater.getAndIncrement(this.integerTarget);
			Thread.sleep((long) (time * 0.5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		this.identifier = this.integerTarget.getNumber();
	}
}
