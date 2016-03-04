package info.halo9pan.experiment.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created: 2014-01-02
 * @author Halo9Pan
 */
public class LockSupportInterrupt {

    public static void main(String[] args) {
		class WaitThread extends Thread {

			@Override
			public void run() {
				System.out.println("Wait Thread was started.");
				LockSupport.park();
				System.out.println("Wait Thread was finished.");
			}
		}
        final WaitThread waitThread = new WaitThread();
        Thread interruptThread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Interrupt Thread was started.");
                    TimeUnit.SECONDS.sleep(1L);
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

