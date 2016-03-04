package info.halo9pan.experiment.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasicLockCondition {

	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
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
                    System.out.println("Wait Thread " + token + " start to wait.");
                    condition.await();
                    System.out.println("Wait Thread " + token + " finish waiting.");
                    System.out.println("Wait Thread " + token + " was finished.");
                } catch (InterruptedException e) {
                    System.out.println("Wait Thread " + token + " was interrupted.");
				}
			}
		}
        final WaitThread waitThread = new WaitThread("one");
        Thread modifyThread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Signal Thread was started.");
                    TimeUnit.SECONDS.sleep(1L);
                    boolean acquire = lock.tryLock();
                    System.out.println("Signal Thread got the lock: " + acquire);
                    condition.signalAll();
                    lock.unlock();
                    System.out.println("Signal Thread was finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        waitThread.start();
        modifyThread.start();
	}

}
