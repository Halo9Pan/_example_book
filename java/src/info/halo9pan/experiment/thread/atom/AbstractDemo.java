package info.halo9pan.experiment.thread.atom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import info.halo9pan.experiment.thread.Invoker;
import info.halo9pan.experiment.thread.Runner;

public abstract class AbstractDemo {

	protected int THREAD_NUMBER = 4;

	private ExecutorService threadPool;
	private List<Invoker> list = new ArrayList<Invoker>();

	protected Runner runner;

	protected abstract Runner createRunner();

	protected void show() {
		this.threadPool = Executors.newFixedThreadPool(THREAD_NUMBER);
		this.runner = createRunner();
		for (int i = 0; i < THREAD_NUMBER; i++) {
			Invoker invoker = createInvoker(i);
			list.add(invoker);
			this.threadPool.execute(invoker);
		}
		this.threadPool.shutdown();
		this.close();
	}

	protected Invoker createInvoker(int i) {
		Invoker invoker = new Invoker(i, this.runner);
		return invoker;
	}

	protected void close() {
		long waitingTime = getWaitingTime();
		try {
			this.threadPool.awaitTermination(waitingTime, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.runner.close();
		long maxRunTime = 0;
		for (Invoker i : this.list) {
			long runTime = i.getSpentTime();
			maxRunTime = (maxRunTime < runTime) ? runTime : maxRunTime;
		}
		System.out.println("Max spent time: " + maxRunTime);
		System.out.println("Runner Identifier: " + this.runner.getIdentifier());
	}
	
	protected long getWaitingTime(){
		long waitingTime = this.runner.getRunTime();
		return waitingTime * 2;
	}

}
