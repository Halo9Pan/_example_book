package info.halo9pan.experiment.jmx;

import java.time.Clock;

public class Basic {

	public static void main(String[] args) {
		while (true) {
			try {
				Clock clock = Clock.systemDefaultZone();
				System.out.println(clock.instant());
				Thread.sleep(60 * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
