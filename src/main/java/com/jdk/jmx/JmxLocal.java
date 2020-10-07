package com.jdk.jmx;

import com.jdk.jmx.sc.User;
import org.junit.Test;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;

/**
 * 学习jmx相关的API
 *
 * @description:
 * @date:2020/10/7 15:40
 **/
public class JmxLocal {


    @Test
    public void testOperatingSystemMXBean() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        // 操作系统体系结构
        System.out.println(operatingSystemMXBean.getArch());
        System.out.println(operatingSystemMXBean.getAvailableProcessors());
        System.out.println(operatingSystemMXBean.getName());
        System.out.println(operatingSystemMXBean.getSystemLoadAverage());
        System.out.println(operatingSystemMXBean.getVersion());
        System.out.println(operatingSystemMXBean.getObjectName());
        System.out.println(operatingSystemMXBean.getClass());
    }

    @Test
    public void testThreadMXBean() throws IOException {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        System.out.println(mxBean.getThreadCount());
        long[] allThreadIds = mxBean.getAllThreadIds();
        for (long id : allThreadIds) {
            System.out.println(mxBean.getThreadInfo(id));
            // "Finalizer" Id=3 WAITING on java.lang.ref.ReferenceQueue$Lock@5e9f23b4
        }
        // 让程序卡在这里，jconsole查看
        System.out.println(System.in.read());
    }

    @Test
    public void testMyMxBean() throws MalformedObjectNameException,
            NotCompliantMBeanException, InstanceAlreadyExistsException,
            MBeanRegistrationException, IOException {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        MyServer server = new MyServer(8080, "localhost", 10, 1);
        MyServerManagement jmxBean = new MyServerManagement(server);
        ObjectName serverName = new ObjectName("com.jdk.jmx:type=MyServerManagement");
        mbs.registerMBean(jmxBean, serverName);

        System.in.read();

    }

    @Test
    public void testUserMBean() throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("jmx:type=User");
        User bean = new User("张三", "123");
        mbs.registerMBean(bean, objectName);

        String oldName = null;
        String oldPassword = null;

        System.out.println("jmx started -----");

        while (true) {
            if (!bean.getName().equals(oldName) || !bean.getPassword().equals(oldPassword)) {
                System.out.println(bean.getName() + " " + bean.getPassword());
                oldName = bean.getName();
                oldPassword = bean.getPassword();
            }
            Thread.sleep(1000);
        }

    }

}
