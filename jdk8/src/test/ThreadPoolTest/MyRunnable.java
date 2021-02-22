package test.ThreadPoolTest;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName MyRunnable
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/15 11:07
 */

public class MyRunnable implements Callable<String> {

    private int num;

    private CountDownLatch endTaskLatch;

    public MyRunnable(int num,CountDownLatch latch) {
        this.num = num;
        this.endTaskLatch = latch;
    }

    @Override
    public String call() throws Exception {
        System.out.println("线程编号" + Thread.currentThread().getName() + "任务编号:" + num + "正在运行");
        Thread.sleep(2000);
        System.out.println("线程编号" + Thread.currentThread().getName() + "任务编号:" + num + "处理完成");
        endTaskLatch.countDown();
        return "任务编号：" + num + "成功";
    }
}