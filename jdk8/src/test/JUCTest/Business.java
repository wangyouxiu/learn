package test.JUCTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Business
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/30 12:04
 */

public class Business {
    private int i = 10;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Boolean isSub1 = true;

    public void sub1() {
        lock.lock();
        try {
            while (!isSub1) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isSub1 = false;
            System.out.println(Thread.currentThread().getName() + "---" + --i);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void sub2() {
        lock.lock();
        try {
            while (isSub1) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isSub1 = true;
            i -= 2;
            System.out.println(Thread.currentThread().getName()+"===="+i);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }


}