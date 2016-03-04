package info.halo9pan.experiment.thread.atom;

import info.halo9pan.experiment.thread.Runner;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerSet extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("AtomicInteger.set(Invoker.number)");
		IntegerSet demo = new IntegerSet();
		demo.THREAD_NUMBER = 1000;
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new IntegerSetRunner();
		return runner;
	}

}

class IntegerSetRunner extends Runner {

	private AtomicInteger atom = new AtomicInteger();
	private Set<Integer> check = Collections.synchronizedSet(new HashSet<Integer>());

	@Override
	public void doSomething(int invoker) {
		long time = getRunTime();
		try {
			Thread.sleep((long) (time * 0.5));
			int v = this.atom.get();
			System.out.println("[" + invoker + "]" + " original value: " + v);
			if (this.check.contains(invoker)) {
				throw new IllegalAccessException("[" + v + "]" + ": " + this.check);
			} else {
				this.atom.set(invoker);
				this.check.add(invoker);
				System.out.println("[" + invoker + "]" + " new value: " + invoker);
			}
			Thread.sleep((long) (time * 0.5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		this.identifier = this.atom.get();
	}
}
