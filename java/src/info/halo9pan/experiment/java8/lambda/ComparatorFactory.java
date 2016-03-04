package info.halo9pan.experiment.java8.lambda;

import java.util.Comparator;

public class ComparatorFactory {
	public Comparator<Integer> makeComparator() {
		return Integer::compareUnsigned;
	}

	public static void main(String[] args) {
		Comparator<Integer> cmp = new ComparatorFactory().makeComparator();
		System.out.println(cmp.compare(10, -5));
	}
}