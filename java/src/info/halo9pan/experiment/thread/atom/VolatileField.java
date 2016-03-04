package info.halo9pan.experiment.thread.atom;

import info.halo9pan.experiment.thread.Invoker;
import info.halo9pan.experiment.thread.Runner;

public class VolatileField extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("No synchronized key work，one field add volatile key work.");
		VolatileField demo = new VolatileField();
		demo.THREAD_NUMBER = 1000;
		demo.show();
	}

	@Override
	protected Invoker createInvoker(int i) {
		Invoker invoker = new Invoker(i, this.runner){

			@Override
			public void run() {
				super.run();
			}
		};
		return invoker;
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new VolatileFieldRunner();
		return runner;
	}

}

class VolatileFieldRunner extends Runner {

	volatile private int number;

	@Override
	public void doSomething(int invoker) {
		long time = getRunTime();
		try {
			Thread.sleep((long) (time * 0.5));
			int n = this.number;
			this.number = n + 1;
			Thread.sleep((long) (time * 0.5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getIdentifier() {
		return this.number;
	}
}
