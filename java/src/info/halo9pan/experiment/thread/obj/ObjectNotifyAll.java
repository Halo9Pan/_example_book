package info.halo9pan.experiment.thread.obj;

public class ObjectNotifyAll {

	public static void main(String[] args) {
		final Object lock = new Object();
		class WaitThread extends Thread {
			String token;

			public WaitThread(String token) {
				super();
				this.token = token;
			}

			@Override
			public void run() {
				try {
					System.out.println("Wait Thread " + token + " was started.");
					synchronized (lock) {
						lock.wait();
					}
					System.out.println("Wait Thread " + token + " was finished.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Thread notifyThread = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("Notify Thread was started.");
					System.out.println("Notify Thread sleep 1s.");
					Thread.sleep(1000L);
					System.out.println("Notify Thread notify.");
					synchronized (lock) {
						lock.notifyAll();
					}
					System.out.println("Notify Thread was finished.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		for (int i = 0; i < 10; i++) {
			WaitThread waitThread = new WaitThread(String.valueOf(i));
			waitThread.start();
		}
		notifyThread.start();
	}

}
