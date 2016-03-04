package info.halo9pan.experiment.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.NotificationListener;
import javax.management.ObjectName;

public class NotificationAgent {
	public static void main(String args[]) throws Exception {
		MBeanServer server = MBeanServerFactory.createMBeanServer();
		
		ObjectName echoName = new ObjectName("info.halo9pan.experiment.jmx:type=SimpleEcho");
		SimpleEcho echo = new SimpleEcho();
		server.registerMBean(echo, echoName);

		ObjectName notificationEchoName = new ObjectName("info.halo9pan.experiment.jmx:type=SimpleNotification");
		SimpleNotification notificationEcho = new SimpleNotification();
		server.registerMBean(notificationEcho, notificationEchoName);
		
		ObjectName listenerName = new ObjectName("info.halo9pan.experiment.jmx:type=SimpleListener");
		NotificationListener listener = new SimpleListener();
		server.registerMBean(listener, listenerName);
		notificationEcho.addNotificationListener(listener, null, echo);
		
		System.out.println("start.....");
		Thread.sleep(Long.MAX_VALUE);
	}
}
