package info.halo9pan.experiment.thread.obj;

public class ObjectWait {

	public static void main(String[] args) {
		final Object lock = new Object();
		class WaitThread extends Thread {
			boolean condition = true;

			@Override
			public void run() {
				try {
					System.out.println("Wait Thread was started.");
					synchronized (lock) {
						while (condition) {
							lock.wait(10L);
						}
					}
					System.out.println("Wait Thread was finished.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		final WaitThread waitThread = new WaitThread();
		Thread conditionThread = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("Condition Thread was started.");
					Thread.sleep(1000L);
					waitThread.condition = false;
					System.out.println("Condition Thread was finished.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		waitThread.start();
		conditionThread.start();
	}
}
