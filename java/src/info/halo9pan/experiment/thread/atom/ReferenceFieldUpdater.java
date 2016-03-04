package info.halo9pan.experiment.thread.atom;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import info.halo9pan.experiment.thread.Runner;

public class ReferenceFieldUpdater extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("No synchronized key word，AtomicInteger++");
		ReferenceFieldUpdater demo = new ReferenceFieldUpdater();
		demo.THREAD_NUMBER = 1000;
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new ReferenceFieldUpdaterRunner();
		return runner;
	}

}

class ReferenceTarget {
	volatile String updateTime;

	protected String getUpdateTime() {
		return updateTime;
	}
}

class ReferenceFieldUpdaterRunner extends Runner {

	private AtomicReferenceFieldUpdater<ReferenceTarget, String> updater = AtomicReferenceFieldUpdater
			.newUpdater(ReferenceTarget.class, String.class, "updateTime");
	private ReferenceTarget referenceTarget = new ReferenceTarget();

	@Override
	public void doSomething(int invoker) {
		String now = Calendar.getInstance().getTime().toString();
		this.updater.set(this.referenceTarget, now);
	}

	@Override
	public Object getIdentifier() {
		return this.referenceTarget.getUpdateTime();
	}
}
