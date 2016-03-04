package info.halo9pan.experiment.jmx;

public class SimpleEcho implements EchoMBean {

	@Override
	public void print(String content) {
		System.out.println("Content: " + content);  
	}

}
