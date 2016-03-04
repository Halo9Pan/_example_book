package info.halo9pan.experiment.thread.lock.perf;

import info.halo9pan.experiment.thread.Runner;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InstantOperation extends SimpleDemo {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 8, 16, 2000};
        int times = 1;
        for (int i : numbers) {
            System.out.println("================================================================================");
            SimpleDemo sync = new InstantOperation(i, new SyncRunner());
            System.out.print(String.format("%-20s", "Using synchronize:"));
            sync.batchShow(times);
            SimpleDemo lock = new InstantOperation(i, new LockRunner());
            System.out.print(String.format("%-20s", "Using ReentrantLock:"));
            lock.batchShow(times);
        }
    }

    public InstantOperation(int threadNumber, Runner runner) {
        super(threadNumber, runner);
    }

    static class LockRunner extends Runner {

        private Lock lock = new ReentrantLock();

        @Override
        public void doSomething(int invoker) {
            lock.lock();
            this.identifier++;
            lock.unlock();
        }

    }

    static class SyncRunner extends Runner {

        @Override
        public void doSomething(int invoker) {
            synchronized (this) {
                this.identifier++;
            }
        }

    }
}

