package test.ThreadPoolTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolExecutorTest
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/15 10:19
 */

public class ThreadPoolExecutorTest {

    @Test
    public void test1() throws InterruptedException {
        long start = System.currentTimeMillis();
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(999);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(8, 20, 2,
                        TimeUnit.SECONDS, arrayBlockingQueue, new MyThreadFactory(Executors.defaultThreadFactory(), "test"), new ThreadPoolExecutor.CallerRunsPolicy());
        //设置核心线程根据回收策略进行回收
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        CountDownLatch countDownLatch = new CountDownLatch(10);

        ArrayList<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<String> submit = threadPoolExecutor.submit(new MyRunnable(i, countDownLatch));
            futures.add(submit);
        }
        countDownLatch.await();
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }


    public void test2() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

    }

}