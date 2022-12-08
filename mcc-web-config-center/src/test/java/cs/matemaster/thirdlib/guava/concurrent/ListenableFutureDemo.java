package cs.matemaster.thirdlib.guava.concurrent;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author matemaster
 */
public class ListenableFutureDemo {

    private static final ExecutorService pool = new ThreadPoolExecutor(10, 10, 60,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("thread-%S").build());


    @Test
    public void onSuccess() {
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(pool);
        ListenableFuture<String> listenableFuture = listeningExecutorService.submit(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name);
            return name;
        });

        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result + "成功执行");
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t);
            }
        }, pool);
    }

    @Test
    public void onFailure() {
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(pool);
        ListenableFuture<String> listenableFuture = listeningExecutorService.submit(() -> {
            throw new UnsupportedOperationException("listenableFuture异常执行测试");
        });

        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result + "成功执行");
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getMessage());
            }
        }, pool);
    }


    @Test
    public void asyncFunc() {

    }
}
