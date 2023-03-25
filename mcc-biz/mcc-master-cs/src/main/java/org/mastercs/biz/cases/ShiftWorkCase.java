package org.mastercs.biz.cases;

import java.util.List;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author matemaster
 */
public class ShiftWorkCase {

    static Thread t1 = null;
    static Thread t2 = null;

    /**
     * 线程交替打印1，-1，2，-2，3，-3，4，-4，5，-5, 6, -6, 7, -7, 8, -8, 9, -9, 10, -10
     */
    public static void printAlternately() {
        List<Integer> list = IntStream
                .iterate(1, i -> i + 1)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> list2 = IntStream
                .iterate(-1, i -> i - 1)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());


        t1 = new Thread(() -> {
            list.forEach(elem -> {
                LockSupport.unpark(t2);
                System.out.println(elem);
                LockSupport.park();
            });
        });


        t2 = new Thread(() -> {
            list2.forEach(elem -> {
                LockSupport.park();
                System.out.println(elem);
                LockSupport.unpark(t1);
            });
        });

        t1.start();
        t2.start();
    }
}
