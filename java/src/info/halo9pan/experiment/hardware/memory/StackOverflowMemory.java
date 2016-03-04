package info.halo9pan.experiment.hardware.memory;

public class StackOverflowMemory {

	public int bomb(int i){
		if(i > 0){
			return bomb(--i);
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		StackOverflowMemory out = new StackOverflowMemory();
		int max = Short.MAX_VALUE;
		System.out.println(max);
		out.bomb(max);
	}

}
