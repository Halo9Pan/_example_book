package info.halo9pan.experiment.thread.obj;

import java.util.concurrent.TimeUnit;

public class ThreadInterruptWait {

    public static void main(String[] args) {
        final Object lock = new Object();
        class WaitThread extends Thread {

            @Override
            public void run() {
                try {
                    System.out.println("Wait Thread was started.");
                    synchronized (lock) {
                        lock.wait();
                    }
                    System.out.println("Wait Thread was finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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