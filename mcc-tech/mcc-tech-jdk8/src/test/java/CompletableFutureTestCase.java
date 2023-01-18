import cs.matemaster.standardwebserver.common.util.DataFakerUtil;
import lombok.SneakyThrows;
import lombok.var;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author matemaster
 */
public class CompletableFutureTestCase {

    @Test
    @SneakyThrows
    public void task() {

        CompletableFuture.runAsync(() -> {
            byte[] bytes = RandomUtils.nextBytes(10);
            System.out.println(Arrays.toString(bytes));
        });

        var future = CompletableFuture.supplyAsync(() -> UUID.randomUUID().toString());
        System.out.println(future.getNow("UUID"));

        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void waitTask() {
        var runAsync1 = CompletableFuture.runAsync(() -> {
            System.out.println("当前执行线程：" + Thread.currentThread().getName());
            System.out.println("随机值：" + RandomUtils.nextLong());
        });
        var runAsync2 = CompletableFuture.runAsync(() -> {
            System.out.println("当前执行线程：" + Thread.currentThread().getName());
            System.out.println("随机值：" + DataFakerUtil.getRandomDeptId());
        });
        var runAsync3 = CompletableFuture.runAsync(() -> {
            System.out.println("当前执行线程：" + Thread.currentThread().getName());
            System.out.println("随机值：" + RandomUtils.nextDouble());
        });

        CompletableFuture.allOf(runAsync1, runAsync2, runAsync3).join();

        System.out.println("程序执行完毕");
    }
}
