package info.halo9pan.experiment.jmx;

import javax.management.Notification;
import javax.management.NotificationListener;

public class SimpleListener implements NotificationListener {

	@Override
	public void handleNotification(Notification notification, Object handback) {
		System.out.println("type=" + notification.getType());
		System.out.println("source=" + notification.getSource());
		System.out.println("sequence=" + notification.getSequenceNumber());
		System.out.println("send time=" + notification.getTimeStamp());
		System.out.println("message=" + notification.getMessage());

		if (handback != null) {
			if (handback instanceof SimpleEcho) {
				SimpleEcho hello = (SimpleEcho) handback;
				hello.print(notification.getMessage());
			}
		}
	}

}
