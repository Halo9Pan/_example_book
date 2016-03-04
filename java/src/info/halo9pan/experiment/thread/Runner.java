package info.halo9pan.experiment.thread;

public abstract class Runner {

	protected static final long DEFAULT_RUN_TIME = 1000L;
	protected int identifier;
	protected long runTime = DEFAULT_RUN_TIME;

	public abstract void doSomething(int invoker);

	protected void setRunTime(long runTime) {
		this.runTime = runTime;
	}

	public Object getIdentifier() {
		return identifier;
	}

	public long getRunTime() {
		return this.runTime;
	}

	public void close() {
	}

}
