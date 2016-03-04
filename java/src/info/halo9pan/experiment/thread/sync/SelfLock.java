package info.halo9pan.experiment.thread.sync;

import info.halo9pan.experiment.thread.Runner;

public class SelfLock extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("synchronized语句块，this作为锁");
		SelfLock demo = new SelfLock();
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new SelfRunner();
		return runner;
	}

}

class SelfRunner extends Runner {

	@Override
	public void doSomething(int invoker) {
		long time = getRunTime();
		try {
			synchronized (this) {
				Thread.sleep((long) (time * 0.4));
				int number = this.identifier;
				Thread.sleep((long) (time * 0.2));
				this.identifier = number + 1;
				Thread.sleep((long) (time * 0.4));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}