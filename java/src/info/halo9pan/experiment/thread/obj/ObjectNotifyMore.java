package info.halo9pan.experiment.thread.obj;

public class ObjectNotifyMore {

	public static void main(String[] args) {
		final Object lock = new Object();
		class WaitThread extends Thread{
			String token;
			
			public WaitThread(String token) {
				super();
				this.token = token;
			}

			@Override
			public void run() {
				try {
					System.out.println("Wait Thread " + token + " was started.");
					synchronized(lock){
						lock.wait();
					}
					System.out.println("Wait Thread " + token + " was finished.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Thread notifyThread = new Thread(){
			@Override
			public void run() {
				try {
					System.out.println("Notify Thread was started.");
					System.out.println("Notify Thread sleep 1s.");
					Thread.sleep(1000L);
					System.out.println("Notify Thread notify.");
					synchronized(lock){
						lock.notify();
					}
					System.out.println("Notify Thread was finished.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		WaitThread one = new WaitThread("one");
		one.start();
		WaitThread two = new WaitThread("two");
		two.start();
		notifyThread.start();
	}

}
