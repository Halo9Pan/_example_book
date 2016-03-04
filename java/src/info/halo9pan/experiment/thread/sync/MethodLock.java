package info.halo9pan.experiment.thread.sync;

import info.halo9pan.experiment.thread.Runner;

public class MethodLock extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("synchronized关键字加在方法前");
		MethodLock demo = new MethodLock();
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new MethodRunner();
		return runner;
	}

}

class MethodRunner extends Runner {

	@Override
	public synchronized void doSomething(int invoker) {
		long time = getRunTime();
		try {
			Thread.sleep((long) (time * 0.4));
			int number = this.identifier;
			Thread.sleep((long) (time * 0.2));
			this.identifier = number + 1;
			Thread.sleep((long) (time * 0.4));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}