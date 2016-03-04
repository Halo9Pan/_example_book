package info.halo9pan.experiment.thread.lock.perf;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by Halo9Pan on 13-12-31.
 */
public abstract class ReadWriteDemo {

    protected int readThreadNumber;
    protected int writeThreadNumber;

    private List<Thread> threadList;

    protected Runner reader;
    protected Runner writer;

    protected CountDownLatch latch;
    protected CyclicBarrier barrier;

    public ReadWriteDemo(int read, int write) {
        this.readThreadNumber = read;
        this.writeThreadNumber = write;
    }

    protected void setReader(Runner runner) {
        this.reader = runner;
    }

    protected void setWriter(Runner runner) {
        this.writer = runner;
    }

    protected void batchShow(int times) {
        long start = System.nanoTime();
        for (int i = 0; i < times; i++) {
            this.show();
        }
        long end = System.nanoTime();
        long spentTime = (end - start);
        StringBuffer buffer = new StringBuffer();
        buffer.append("Used thread: ").append(String.format("%10s", readThreadNumber + "/" + writeThreadNumber)).append(". ");
        buffer.append("Run times: ").append(times).append(". ");
        buffer.append("Spent time: ").append(String.format("%12d", spentTime)).append("ns. ");
        buffer.append("Average time: ").append(String.format("%8d", spentTime/times/(readThreadNumber + writeThreadNumber))).append("ns. ");
        System.out.println(buffer.toString());
    }

    protected void show() {
        int threadNumber = readThreadNumber + writeThreadNumber;
        this.threadList = new ArrayList<>(threadNumber);
        this.latch = new CountDownLatch(threadNumber);
        this.barrier = new CyclicBarrier(threadNumber);
        for (int i = 0; i < readThreadNumber; i++) {
            Runnable invoker = createReadRunner(i);
            Thread t = new Thread(invoker);
            this.threadList.add(t);
        }
        for (int i = 0; i < writeThreadNumber; i++) {
            Runnable invoker = createWriteRunner(i);
            Thread t = new Thread(invoker);
            this.threadList.add(t);
        }
        for (Thread t : this.threadList) {
            t.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected Runnable createReadRunner(final int i) {
        Runnable invoker = new Runnable() {
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                reader.safeRead();
                latch.countDown();
            }
        };
        return invoker;
    }

    protected Runnable createWriteRunner(final int i) {
        Runnable invoker = new Runnable() {
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                writer.safeWrite();
                latch.countDown();
            }
        };
        return invoker;
    }

}

abstract class Runner {
    protected int total = (int)Math.pow(2D, 16D);
    protected List<String> keyList = generateRandomList(total);
    protected Map<String, String> map = generateRandomMap(keyList);

    protected List<String> generateRandomList(int length) {
        List<String> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            String key = randomString(8);
            list.add(key);
        }
        return list;
    }

    protected Map<String, String> generateRandomMap(List<String> list) {
        Map<String, String> map = new HashMap<String, String>(list.size());
        for (String s : list) {
            String value = randomString(32);
            map.put(s, value);
        }
        return map;
    }


    protected String randomString(int len) {
        String all = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int length = all.length();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(all.charAt(rnd.nextInt(length)));
        return sb.toString();
    }

    protected String read(String key) {
        return this.map.get(key);
    }

    protected String write(String key, String value) {
        return this.map.put(key, value);
    }

    protected abstract String safeRead();

    protected abstract String safeWrite();

    protected String getRandomKey() {
        double random = Math.random();
        int index = (int) (total * random);
        String key = keyList.get(index);
        return key;
    }

}

abstract class ProcessRunner extends Runner{
    @Override
    protected String read(String key) {
        try {
            TimeUnit.MICROSECONDS.sleep(2L);
        } catch (InterruptedException e) {
        }
        return super.read(key);
    }

    @Override
    protected String write(String key, String value) {
        try {
            TimeUnit.MICROSECONDS.sleep(2L);
        } catch (InterruptedException e) {
        }
        return super.write(key, value);
    }
}