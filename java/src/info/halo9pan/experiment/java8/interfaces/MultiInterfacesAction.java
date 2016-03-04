package info.halo9pan.experiment.java8.interfaces;

public class MultiInterfacesAction implements IActionOne, IActionTwo {

	@Override
	public void init() {
		System.out.println("implement method myself");
	}

	@Override
	public void run() {
	}

}
