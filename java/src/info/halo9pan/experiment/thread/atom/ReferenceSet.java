package info.halo9pan.experiment.thread.atom;

import java.util.concurrent.atomic.AtomicReference;

import info.halo9pan.experiment.thread.Runner;

public class ReferenceSet extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("AtomicInteger.set(Invoker.number)");
		ReferenceSet demo = new ReferenceSet();
		demo.THREAD_NUMBER = 1000;
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new ReferenceSetRunner();
		return runner;
	}

}

class ReferenceSetTarget {
	int number;

	protected int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "IntegerTarget [" + number + "]";
	}
}

class ReferenceSetRunner extends Runner {

	private AtomicReference<ReferenceSetTarget> atom = new AtomicReference<ReferenceSetTarget>();

	@Override
	public void doSomething(int invoker) {
		ReferenceSetTarget target = new ReferenceSetTarget();
		target.number = invoker;
		this.atom.set(target);
	}

	@Override
	public Object getIdentifier() {
		return this.atom.get().number;
	}
}
