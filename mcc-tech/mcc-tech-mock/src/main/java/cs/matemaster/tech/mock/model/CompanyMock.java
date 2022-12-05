package cs.matemaster.tech.mock.model;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author matemaster
 */
@Getter
@Builder
@ToString
public class CompanyMock {
    /**
     * 排名
     */
    private int rank;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 收入
     */
    private long income;

    /**
     * 利益
     */
    private long profit;

    /**
     * 所属国家
     */
    private String country;

    /**
     * 创始人
     */
    private String founder;

    public static CompanyMockBuilder mockBuilder() {
        Faker faker = new Faker();
        return builder()
                .rank(faker.number().randomDigitNotZero())
                .companyName(faker.company().name())
                .income(faker.number().randomNumber())
                .profit(faker.number().randomNumber())
                .founder(faker.name().fullName())
                .country(faker.country().name());
    }
}
