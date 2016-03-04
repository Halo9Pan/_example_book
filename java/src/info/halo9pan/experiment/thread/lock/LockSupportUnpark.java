package info.halo9pan.experiment.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created: 2014-01-02
 * @author Halo9Pan
 */
public class LockSupportUnpark {

    public static void main(String[] args) {
    	final Object blocker = new Object();
		class WaitThread extends Thread {

			@Override
			public void run() {
				System.out.println("Wait Thread was started.");
				LockSupport.park(blocker);
				System.out.println("Wait Thread was finished.");
			}
		}
        final WaitThread waitThread = new WaitThread();
        Thread unparkThread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Interrupt Thread was started.");
                    TimeUnit.SECONDS.sleep(1L);
                    System.out.println("Wait Thread state." + waitThread.getState());
                    LockSupport.unpark(waitThread);
                    System.out.println("Interrupt Thread was finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        waitThread.start();
        unparkThread.start();
    }

}

