package info.halo9pan.experiment.thread.atom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

import info.halo9pan.experiment.thread.Runner;

public class MarkableReference extends AbstractDemo {

	public static void main(String[] args) {
		System.out.println("No synchronized key word，AtomicInteger++");
		MarkableReference demo = new MarkableReference();
		demo.THREAD_NUMBER = 1000;
		demo.show();
	}

	@Override
	protected Runner createRunner() {
		Runner runner = new MarkableReferenceRunner();
		return runner;
	}

}

class MarkableReferenceKey {
	volatile String key;

	public MarkableReferenceKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "[" + key + "]";
	}

}

class MarkableReferenceRunner extends Runner {

	private MarkableReferenceKey odd = new MarkableReferenceKey("odd");
	private MarkableReferenceKey even = new MarkableReferenceKey("even");
	private AtomicMarkableReference<MarkableReferenceKey> reference = new AtomicMarkableReference<MarkableReferenceKey>(even, false);

	@Override
	public void doSomething(int invoker) {
		boolean mark = (invoker % 2 == 0) ? true : false;
		MarkableReferenceKey key = mark ? this.even : this.odd;
		this.reference.set(key, true);
		int tryTime = invoker;
		StringBuffer buffer = new StringBuffer();
		buffer.append(invoker).append(":");
		int i = 0;
		for (; (i < tryTime); i++) {
			boolean success = this.reference.attemptMark(this.even, true);
			if (success) {
				break;
			} else {
				try {
					TimeUnit.NANOSECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				buffer.append('.');
			}
		}
		System.out.println(buffer);
	}

	@Override
	public Object getIdentifier() {
		return this.reference.getReference().toString() + ":" + this.reference.isMarked();
	}

	@Override
	public void close() {
		this.reference.compareAndSet(this.odd, this.even, true, false);
	}

}
