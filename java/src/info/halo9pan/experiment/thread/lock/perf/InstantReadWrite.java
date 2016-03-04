package info.halo9pan.experiment.thread.lock.perf;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Halo9Pan on 13-12-31.
 */
public class InstantReadWrite extends ReadWriteDemo {

    public static void main(String[] args) {
        Runner sync = new SyncRunner();
        Runner lock = new LockRunner();
        int[] readNumber = { 2, 4, 1, 4, 2000, 1, 2000 };
        int[] writeNumber = { 2, 1, 4, 4, 1, 2000, 2000 };
        int times = 1;
        for (int i = 0 ; i < readNumber.length; i++) {
            int read = readNumber[i];
            int write = writeNumber[i];
            System.out.println("================================================================================");
            ReadWriteDemo syncDemo = new InstantReadWrite(read, write, sync);
            System.out.print(String.format("%-32s", "Using synchronize:"));
            syncDemo.batchShow(times);
            ReadWriteDemo lockDemo = new InstantReadWrite(read, write, lock);
            System.out.print(String.format("%-32s", "Using ReentrantReadWriteLock:"));
            lockDemo.batchShow(times);
        }
    }

    public InstantReadWrite(int read, int write, Runner runner) {
        super(read, write);
        setReader(runner);
        setWriter(runner);
    }

    static class SyncRunner extends Runner{

        @Override
        protected String safeRead() {
            String key = getRandomKey();
            String s = null;
            synchronized (this){
                s = super.read(key);
            }
            return s;
        }

        @Override
        protected String safeWrite() {
            String key = getRandomKey();
            String value = randomString(32);
            String s = null;
            synchronized (this){
                s = super.write(key, value);
            }
            return s;
        }
    }

    static class LockRunner extends Runner{

        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();
        @Override
        protected String safeRead() {
            String key = getRandomKey();
            String s = null;
            readLock.lock();
            s = super.read(key);
            readLock.unlock();
            return s;
        }

        @Override
        protected String safeWrite() {
            String key = getRandomKey();
            String value = randomString(32);
            String s = null;
            writeLock.lock();
            s = super.write(key, value);
            writeLock.unlock();
            return s;
        }

    }
}

