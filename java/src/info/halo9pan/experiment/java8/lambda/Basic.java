package info.halo9pan.experiment.java8.lambda;

import java.util.Comparator;

public class Basic {

	public static void main(String[] args) {
		sampleRunnable();
	}

	static void sampleRunnable() {
		Runnable r = () -> System.out.println("Hello lambda!");
		Thread t = new Thread(r);
		t.start();
	}

	static Comparator<Integer> futureComparator() {
		Comparator<Integer> cmp = (x, y) -> (x < y) ? -1 : ((x > y) ? 1 : 0);
		return cmp;
	}

	static Comparator<Integer> classicComparator() {
		Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				return (x < y) ? -1 : ((x > y) ? 1 : 0);
			}
		};
		return cmp;
	}

}
