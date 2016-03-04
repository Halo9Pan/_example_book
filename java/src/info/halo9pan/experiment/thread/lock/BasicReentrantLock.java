package info.halo9pan.experiment.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasicReentrantLock {

	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
        class WaitThread extends Thread{
            String token;

            public WaitThread(String token) {
                super();
                this.token = token;
            }

            @Override
			public void run() {
				try {
                    System.out.println("Wait Thread " + token + " was started.");
					lock.lock();
                    System.out.println("Wait Thread " + token + " got the lock.");
                    TimeUnit.SECONDS.sleep(4L);
                    System.out.println("Wait Thread " + token + " was finished.");
                    lock.unlock();
                } catch (InterruptedException e) {
                    System.out.println("Wait Thread " + token + " was interrupted.");
				}
			}
		}
        final WaitThread oneThread = new WaitThread("one");
        final WaitThread twoThread = new WaitThread("two");
        Thread modifyThread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Interrupt Thread was started.");
                    TimeUnit.SECONDS.sleep(1L);
                    twoThread.interrupt();
                    System.out.println("Interrupt Thread was finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        oneThread.start();
        twoThread.start();
        modifyThread.start();
	}

}
