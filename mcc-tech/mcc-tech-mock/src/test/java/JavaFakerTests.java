import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Job;
import com.github.javafaker.Name;
import com.github.javafaker.PhoneNumber;
import cs.matemaster.tech.mock.model.CompanyMock;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
@Slf4j
public class JavaFakerTests {

    @Test
    public void name() {
        Faker faker = new Faker(Locale.CHINA);
        Name nameMock = faker.name();
        log.info(nameMock.name());
        log.info(nameMock.firstName());
        log.info(nameMock.lastName());
        log.info(nameMock.fullName());
        log.info(nameMock.nameWithMiddle());
        log.info(nameMock.bloodGroup());
        log.info(nameMock.username());
        log.info(nameMock.title());
    }

    @Test
    public void phoneNumber() {
        Faker faker = new Faker(Locale.CHINA);
        PhoneNumber phoneNumberMock = faker.phoneNumber();
        log.info(phoneNumberMock.phoneNumber());
        log.info(phoneNumberMock.cellPhone());
        log.info(phoneNumberMock.subscriberNumber());
        log.info(phoneNumberMock.extension());
    }

    @Test
    public void idNumber() {
        Faker faker = new Faker(Locale.CHINA);
        IdNumber idNumberMock = faker.idNumber();
        log.info(idNumberMock.valid());
    }

    @Test
    public void address() {
        Faker faker = new Faker(Locale.CHINA);
        Address addressMock = faker.address();
        log.info(addressMock.fullAddress());
    }

    @Test
    public void job() {
        Faker faker = new Faker(Locale.CHINA);
        Job jobMock = faker.job();
        log.info(jobMock.title());
    }

    @Test
    public void company() {
        CompanyMock companyMock = CompanyMock.mockBuilder().build();
        log.info(companyMock.toString());
    }
}
