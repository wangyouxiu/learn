package test.JUCTest;//package test.JUCTest;
//
//import org.junit.Test;
//
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//
//public class ReentrantReadWriteLockTest {
//
//
//    @Test
//    public void test() {
//        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
//        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
//        readLock.lock();
//        readLock.unlock();
//        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
//        writeLock.lock();
//        writeLock.unlock();
//
//    }
//
//
//    Object data;
//    volatile boolean cacheValid;
//    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
//
//    void processCachedData() {
//        rwl.readLock().lock();
//        if (!cacheValid) {
//            // Must release read lock before acquiring write lock
//            rwl.readLock().unlock();
//            rwl.writeLock().lock();
//            try {
//                // Recheck state because another thread might have
//                // acquired write lock and changed state before we did.
//                if (!cacheValid) {
//                    data = ...
//                    cacheValid = true;
//                }
//                // Downgrade by acquiring read lock before releasing write lock
//                rwl.readLock().lock();
//            } finally {
//                rwl.writeLock().unlock(); // Unlock write, still hold read
//            }
//        }
//
//        try {
//            use(data);
//        } finally {
//            rwl.readLock().unlock();
//        }
//    }
//}