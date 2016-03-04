package info.halo9pan.experiment.thread.lock.perf;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import info.halo9pan.experiment.thread.Runner;

public class ProcessOperation extends SimpleDemo {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 8, 16, 2000};
        int times = 1;
        for (int i : numbers) {
            System.out.println("================================================================================");
            SimpleDemo sync = new ProcessOperation(i, new SyncRunner());
            System.out.print(String.format("%-20s", "Using synchronize:"));
            sync.batchShow(times);
            SimpleDemo lock = new ProcessOperation(i, new LockRunner());
            System.out.print(String.format("%-20s", "Using ReentrantLock:"));
            lock.batchShow(times);
        }
    }

    public ProcessOperation(int threadNumber, Runner runner) {
		super(threadNumber, runner);
	}

    static class LockRunner extends Runner {

        private Lock lock = new ReentrantLock();

        @Override
        public void doSomething(int invoker) {
            lock.lock();
            try {
                TimeUnit.MICROSECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            this.identifier++;
            lock.unlock();
        }

    }

    static class SyncRunner extends Runner {

        @Override
        public void doSomething(int invoker) {
            synchronized (this) {
                try {
                    TimeUnit.MICROSECONDS.sleep(2);
                } catch (InterruptedException e) {
                }
                this.identifier++;
            }
        }

    }
}
