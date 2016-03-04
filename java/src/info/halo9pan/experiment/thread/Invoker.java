package info.halo9pan.experiment.thread;

public class Invoker implements Runnable {
	
	protected int id;
	protected Runner runner;
	protected long spentTime;

	public Invoker(int id, Runner runner) {
		super();
		this.id = id;
		this.runner = runner;
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		this.runner.doSomething(this.id);
		long end = System.currentTimeMillis();
		this.spentTime = (end - start);
		System.out.println("[" + this.id + "]" + " finished, spent time: " + this.spentTime);
	}
	
	public long getSpentTime(){
		return this.spentTime;
	}

}
