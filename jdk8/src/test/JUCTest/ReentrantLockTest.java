package test.JUCTest;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ReentrantLockTest
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/26 11:06
 */

public class ReentrantLockTest {


    @Test
    public void test1() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Business business = new Business();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    business.sub2();
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            business.sub1();
        }

    }

    @Test
    public void test2() {
        int i = 1 << 16;
        System.out.println(i);
        int j = (1 << 16) - 1;
        System.out.println(j);
    }
}