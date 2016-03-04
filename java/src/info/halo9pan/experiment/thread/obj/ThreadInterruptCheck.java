package info.halo9pan.experiment.thread.obj;

import java.util.concurrent.TimeUnit;

/**
 * Created: 2014-01-02
 * @author Halo9Pan
 */
public class ThreadInterruptCheck {

	public static void main(String[] args) {
		class WaitThread extends Thread {

			@Override
			public void run() {
				System.out.println("Wait Thread was started.");
				int times = Integer.MIN_VALUE;
				try {
					while (times++ < Integer.MAX_VALUE) {
						if (Thread.interrupted()) {
							System.out.println("Wait Thread was interrupted.");
							throw new InterruptedException(Thread.currentThread().getName());
						}
					}
				} catch (InterruptedException e) {
					new RuntimeException(e);
				}
				System.out.println("Wait Thread was finished.");
			}
		}
		final WaitThread waitThread = new WaitThread();
		Thread interruptThread = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("Interrupt Thread was started.");
					TimeUnit.MILLISECONDS.sleep(1000L);
					System.out.println("Wait Thread state." + waitThread.getState());
					waitThread.interrupt();
					System.out.println("Interrupt Thread was finished.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		waitThread.start();
		interruptThread.start();
	}

}
