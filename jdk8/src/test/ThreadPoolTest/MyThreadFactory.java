package test.ThreadPoolTest;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyThreadFactory
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/15 10:33
 */

public final class MyThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNum = new AtomicInteger();
    private final ThreadFactory delegate;
    private final String name;

    public MyThreadFactory(ThreadFactory delegate, String name) {
        this.delegate = delegate;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = delegate.newThread(r);
        t.setName(name + " [#" + threadNum.incrementAndGet() + "]");
        return t;
    }
}