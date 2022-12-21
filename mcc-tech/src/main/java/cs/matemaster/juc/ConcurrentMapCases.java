package cs.matemaster.juc;

import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import com.google.common.collect.Maps;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
public class ConcurrentMapCases {

    private static final Logger log = LoggerFactory.getLogger(ConcurrentMapCases.class);

    @SneakyThrows
    public static void main(String[] args) {
        putConcurrently();
    }


    static void putConcurrently() throws InterruptedException {
        Map<String, Object> container = Maps.newConcurrentMap();
        Faker faker = new Faker();
        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 100; i++) {
                Country country = faker.country();
                container.put(country.capital(), country.name());
            }
        });
        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 100; i++) {
                Country country = faker.country();
                container.put(country.capital(), country.name());
            }
        });
        TimeUnit.SECONDS.sleep(1);
        container.forEach((k, v) -> log.info("key: {} value: {}", k, v));
    }

    static List<Country> mockCountry(int size) {
        Faker faker = new Faker();

        return Stream
                .generate(faker::country)
                .limit(size)
                .collect(Collectors.toList());
    }
}
