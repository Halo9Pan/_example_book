package info.halo9pan.experiment.hardware.memory;

public class MemoryChokePoint {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int max = (Integer.MAX_VALUE - 8);
		int[] i = new int[max];
		System.out.println("Memory ready: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		for (int j = 0; j < max; j++) {
			i[j] = Integer.MAX_VALUE;
		}
		System.out.println("Memory access: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		for (int j = 0; j < max; j++) {
			int k = (j / 2) + (j / 4);
		}
		System.out.println("Calculating: " + (System.currentTimeMillis() - start));
		try {
			Thread.sleep(10 * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
