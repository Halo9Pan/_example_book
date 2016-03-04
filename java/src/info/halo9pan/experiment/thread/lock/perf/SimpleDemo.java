package info.halo9pan.experiment.thread.lock.perf;

import info.halo9pan.experiment.thread.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public abstract class SimpleDemo {

	protected int threadNumber;
	private List<Thread> threadList;
	protected Runner runner;
    protected CountDownLatch latch;
    protected CyclicBarrier barrier;

    public SimpleDemo(int threadNumber, Runner runner) {
		this.threadNumber = threadNumber;
        this.runner = runner;
	}

	protected void batchShow(int times){
		long start = System.nanoTime();
		for (int i = 0; i < times; i++) {
			this.show();
		}
		long end = System.nanoTime();
		long spentTime = (end - start);
		StringBuffer buffer = new StringBuffer();
		buffer.append("Used thread: ").append(String.format("%4d", threadNumber)).append(". ");
		buffer.append("Run times: ").append(times).append(". ");
        buffer.append("Spent time: ").append(String.format("%12d", spentTime)).append("ns. ");
        buffer.append("Average time: ").append(String.format("%8d", spentTime/threadNumber/times)).append("ns. ");
		System.out.println(buffer.toString());
	}
	
	protected void show() {
        this.latch = new CountDownLatch(threadNumber);
        this.barrier = new CyclicBarrier(threadNumber);
		this.threadList = new ArrayList<>(threadNumber);
		for (int i = 0; i < threadNumber; i++) {
			Runnable invoker = createInvoker(i);
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

	protected Runnable createInvoker(final int i) {
		Runnable invoker = new Runnable(){
			public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                runner.doSomething(i);
                latch.countDown();
			}};
		return invoker;
	}

}


