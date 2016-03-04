package info.halo9pan.experiment.thread.sync;

import info.halo9pan.experiment.thread.Runner;

public class LessBlockLock extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("synchronized语句块，this作为锁，局部加锁");
		LessBlockLock demo = new LessBlockLock();
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new LessBlockLockRunner();
		return runner;
	}

}

class LessBlockLockRunner extends Runner {

	@Override
	public void doSomething(int invoker) {
		long time = getRunTime();
		try {
			Thread.sleep((long) (time * 0.4));
			synchronized (this) {
				int number = this.identifier;
				Thread.sleep((long) (time * 0.2));
				this.identifier = number + 1;
			}
			Thread.sleep((long) (time * 0.4));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
