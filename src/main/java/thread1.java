import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * ***********************************************************************************
 * *
 * Project:PACKAGE_NAME
 * ClassName: thread1
 * Description: 1.0
 * Author: Zhao Wenqing
 * Date:  2023/9/11 20:34
 *
 * **********************s**************************************************************
 */
public class thread1 {
    public static void main(String[] args) {

        //获取 线程管理
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不同步 monitor 和 synchronizer 信息 仅获取进程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo th01 : threadInfos) {
            System.out.println("[" + th01.getThreadId() + "]" + th01.getThreadName() + ":" + th01.getThreadState());
            System.out.println("(" + th01.getLockName() + ")" + th01.getLockInfo());
        }

    }
}
