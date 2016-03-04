package info.halo9pan.experiment.jmx;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class SimpleNotification extends NotificationBroadcasterSupport implements NotificationMBean {

	private int sequence = 0;

	@Override
	public void notify(String content) {
		Notification n = new Notification("notification", this, ++sequence, System.currentTimeMillis(), content);
		sendNotification(n);
	}

}
