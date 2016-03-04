package info.halo9pan.experiment.thread.sync;

import info.halo9pan.experiment.thread.Runner;

public class ObjectLock extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("synchronized语句块锁，this.lock加锁");
		ObjectLock demo = new ObjectLock();
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new ObjectLockRunner();
		return runner;
	}

}

class ObjectLockRunner extends Runner {

	private Object lock;

	public ObjectLockRunner() {
		this.lock = new Object();
	}

	@Override
	public void doSomething(int invoker) {
		long time = getRunTime();
		try {
			synchronized (this.lock) {
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
