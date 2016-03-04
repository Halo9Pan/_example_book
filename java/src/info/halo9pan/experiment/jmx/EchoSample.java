package info.halo9pan.experiment.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class EchoSample {

	public static void main(String[] args) throws Exception {
		// 创建MBeanServer
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		// 新建MBean ObjectName, 在MBeanServer里标识注册的MBean
		ObjectName name = new ObjectName("info.halo9pan.experiment.jmx:type=SimpleEcho");

		// 创建MBean
		SimpleEcho mbean = new SimpleEcho();

		// 在MBeanServer里注册MBean, 标识为ObjectName(com.tenpay.jmx:type=SimpleEcho)
		mbs.registerMBean(mbean, name);

		// 在MBeanServer里调用已注册的EchoMBean的print方法
		mbs.invoke(name, "print", new Object[] { "haitao.tu" }, new String[] { "java.lang.String" });

		Thread.sleep(Long.MAX_VALUE);
	}

}