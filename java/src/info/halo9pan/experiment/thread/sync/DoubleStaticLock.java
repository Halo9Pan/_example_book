package info.halo9pan.experiment.thread.sync;

import info.halo9pan.experiment.thread.Invoker;
import info.halo9pan.experiment.thread.Runner;

public class DoubleStaticLock extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("synchronized关键字加在静态方法前，多个静态方法前添加synchronized关键字");
		DoubleStaticLock demo = new DoubleStaticLock();
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new DoubleStaticRunner();
		return runner;
	}

	protected Invoker createInvoker(int i) {
		Invoker invoker = new Invoker(i, this.runner){

			@Override
			public void run() {
				long start = System.currentTimeMillis();
				if((this.id % 2) == 0){
					DoubleStaticRunner.doSomethingStatic();
				} else {
					DoubleStaticRunner.doAnotherStatic();
				}
				long end = System.currentTimeMillis();
				this.spentTime = (end - start);
				System.out.println("[" + this.id + "]" + "结束运行，耗时" + this.spentTime);
			}
			
		};
		return invoker;
	}

	protected void printIdentifier() {
		super.printIdentifier();
		System.out.println("运行计数：" + DoubleStaticRunner.number);
	}

}

class DoubleStaticRunner extends Runner {
	
	public static int number;

	public static synchronized void doSomethingStatic() {
		long time = 1000L;
		try {
			Thread.sleep((long) (time * 0.4));
			int n = number;
			Thread.sleep((long) (time * 0.2));
			number = n + 1;
			Thread.sleep((long) (time * 0.4));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void doAnotherStatic() {
		long time = 2000L;
		try {
			Thread.sleep((long) (time * 0.8));
			int n = number;
			Thread.sleep((long) (time * 0.1));
			number = n + 1;
			Thread.sleep((long) (time * 0.1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doSomething(int invoker) {
	}

}