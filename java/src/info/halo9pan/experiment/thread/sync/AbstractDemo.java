package info.halo9pan.experiment.thread.sync;

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
		this.printIdentifier();
	}

	protected Invoker createInvoker(int i) {
		Invoker invoker = new Invoker(i, this.runner);
		return invoker;
	}

	protected void printIdentifier() {
		long waitingTime = (long) (this.runner.getRunTime() * THREAD_NUMBER);
		try {
			this.threadPool.awaitTermination(waitingTime * 2, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long maxRunTime = 0;
		for (Invoker i : this.list) {
			long runTime = i.getSpentTime();
			maxRunTime = (maxRunTime < runTime) ? runTime : maxRunTime;
		}
		System.out.println("Max spent time: " + maxRunTime);
		System.out.println("Runner Identifier: " + runner.getIdentifier());
	}

}
