package info.halo9pan.experiment.hardware.memory;

public class OutOfHeapMemory {

	public static void main(String[] args) {
		int max = (Integer.MAX_VALUE - 4) - 1;
		System.out.println(max);
		int[] i = new int[max];
		System.out.println(i.length);
//		Object[] objects = new Object[max];
//		int[] j = new int[10];
		try {
			Thread.sleep(10 * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
