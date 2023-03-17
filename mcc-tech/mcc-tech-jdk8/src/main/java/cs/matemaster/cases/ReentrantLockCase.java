package cs.matemaster.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author matemaster
 */
public class ReentrantLockCase {

    private static final Logger log = LoggerFactory.getLogger(ReentrantLockCase.class);

    public static void reentrant() {
        ReentrantLock lock = new ReentrantLock(true);

        Thread mockThread = new Thread(() -> {
            for (int i = 0, count = 10; i < count; i++) {
                try {
                    lock.lock();
                    log.info(Thread.currentThread().getName() + " lock...");
                } finally {
                    lock.unlock();
                    log.info(Thread.currentThread().getName() + " unlock...");
                }
            }
        });

        Thread mockThread2 = new Thread(() -> {
            for (int i = 0, lockCount = 10; i < lockCount; i++) {
                lock.lock();
                log.info(Thread.currentThread().getName() + "lock...");
            }

            int holdCount = lock.getHoldCount();
            log.info(Thread.currentThread().getName() + " holdCount: " + holdCount);
            for (int i = 0; i < holdCount; i++) {
                lock.unlock();
                log.info(Thread.currentThread().getName() + "unlock...");
            }
        });

        mockThread.start();
        mockThread2.start();
    }
}
