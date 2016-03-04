package info.halo9pan.experiment.hardware.cpu;

public class L1CacheMiss {
	private static final int RUNS = 10;
	private static final int DIMENSION_1 = 1024 * 1024;
	private static final int DIMENSION_2 = 6;

	private static long[][] longs;

	public static void main(String[] args) throws Exception {
		Thread.sleep(1000L);
		longs = new long[DIMENSION_1][];
		for (int i = 0; i < DIMENSION_1; i++) {
			longs[i] = new long[DIMENSION_2];
			for (int j = 0; j < DIMENSION_2; j++) {
				longs[i][j] = 0L;
			}
		}
		System.out.println("starting....");

		long sum = 0L;
		for (int r = 0; r < RUNS; r++) {

			long start = System.nanoTime();
// slow
			for (int j = 0; j < DIMENSION_2; j++) {
				for (int i = 0; i < DIMENSION_1; i++) {
					sum += longs[i][j];
				}
			}
			System.out.print((System.nanoTime() - start));
			System.out.print(":");

// fast
			start = System.nanoTime();
			for (int i = 0; i < DIMENSION_1; i++) {
				for (int j = 0; j < DIMENSION_2; j++) {
					sum += longs[i][j];
				}
			}

			System.out.print((System.nanoTime() - start));
			System.out.println();
		}

	}
}