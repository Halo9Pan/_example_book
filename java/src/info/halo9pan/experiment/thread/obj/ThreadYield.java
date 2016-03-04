package info.halo9pan.experiment.thread.obj;

public class ThreadYield extends Thread {

	public ThreadYield(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			Thread.yield();
		}
	}

	public static void main(String[] args) {
		ThreadYield t1 = new ThreadYield("High priority");
		ThreadYield t2 = new ThreadYield("Low priority");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}

}
