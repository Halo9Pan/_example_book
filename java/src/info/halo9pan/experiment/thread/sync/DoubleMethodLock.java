package info.halo9pan.experiment.thread.sync;

import info.halo9pan.experiment.thread.Invoker;
import info.halo9pan.experiment.thread.Runner;

public class DoubleMethodLock extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("synchronized关键字加在方法前，多个方法前添加synchronized关键字");
		DoubleMethodLock demo = new DoubleMethodLock();
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new DoubleMethodRunner();
		return runner;
	}

	protected Invoker createInvoker(final int i) {
		Invoker invoker = new Invoker(i, this.runner){

			@Override
			public void run() {
				long start = System.currentTimeMillis();
				DoubleMethodRunner dmr = (DoubleMethodRunner)this.runner;
				if((this.id % 2) == 0){
					dmr.doSomething(i);
				} else {
					dmr.doAnother();
				}
				long end = System.currentTimeMillis();
				this.spentTime = (end - start);
				System.out.println("[" + this.id + "]" + "结束运行，耗时" + this.spentTime);
			}
			
		};
		return invoker;
	}

}

class DoubleMethodRunner extends Runner {

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

	public synchronized void doAnother() {
		long time = getRunTime() * 2;
		try {
			Thread.sleep((long) (time * 0.8));
			int number = this.identifier;
			Thread.sleep((long) (time * 0.1));
			this.identifier = number + 1;
			Thread.sleep((long) (time * 0.1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}