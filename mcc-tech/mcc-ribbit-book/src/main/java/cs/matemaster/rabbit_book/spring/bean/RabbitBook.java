package cs.matemaster.rabbit_book.spring.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author matemaster
 */
@Setter
@Getter
@ToString
public class RabbitBook {

    private String name;
    private BigDecimal price;
}
