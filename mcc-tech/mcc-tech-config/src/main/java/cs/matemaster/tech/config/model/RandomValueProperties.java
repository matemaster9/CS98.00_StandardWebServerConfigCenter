package cs.matemaster.tech.config.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Getter
@ToString
@Configuration
public class RandomValueProperties {
    @Value("${random-value.secret}")
    private String secret;

    @Value("${random-value.number}")
    private Integer number;

    @Value("${random-value.big-number}")
    private Long bigNumber;

    @Value("${random-value.uuid}")
    private String uuid;

    @Value("${random-value.less-ten}")
    private Integer lessTen;

    @Value("${random-value.range}")
    private Integer range;

    @Value("${random-value.message}")
    private String message;
}
