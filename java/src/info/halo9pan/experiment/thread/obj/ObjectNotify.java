package info.halo9pan.experiment.thread.obj;

public class ObjectNotify {

	public static void main(String[] args) {
		final Object lock = new Object();
		Thread waitThread = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("Wait Thread was started.");
					synchronized (lock) {
						lock.wait();
					}
					System.out.println("Wait Thread was finished.");
					synchronized (lock) {
						System.out.println("Wait Thread wait again.");
						lock.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread notifyThread = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("Notify Thread was started.");
					System.out.println("Notify Thread sleep 1s.");
					Thread.sleep(1000L);
					System.out.println("Notify Thread notify.");
					synchronized (lock) {
						lock.notify();
					}
					System.out.println("Notify Thread was finished.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		waitThread.start();
		notifyThread.start();
	}

}
