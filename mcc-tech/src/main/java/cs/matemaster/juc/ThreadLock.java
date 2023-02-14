package cs.matemaster.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author matemaster
 */
@Slf4j
public class ThreadLock {

    private static final Object LOCK_OBJECT = new Object();

    public static void main(String[] args) {

        Thread one = new Thread(() -> {
            synchronized (LOCK_OBJECT) {
                log.info("one");
            }
        });

        Thread another = new Thread(() -> {
            synchronized (LOCK_OBJECT) {
                log.info("another");
            }
        });

        one.start();
        another.start();
    }


    static {
        synchronized (ThreadLock.class) {
            System.out.println("static code module");
        }
    }

    public synchronized static void syncStaticMethod() {
    }

    public synchronized void syncMethod() {
    }
}
