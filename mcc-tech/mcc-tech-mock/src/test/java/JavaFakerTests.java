import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Locale;

/**
 * @author matemaster
 */
@Slf4j
public class JavaFakerTests {

    @Test
    public void test() {
        Faker faker = new Faker(Locale.CHINA);
        String name = faker.name().fullName();
        log.info(name);
    }
}
