package cs.matemaster.tech.easyexcel.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author matemaster
 */
@Getter
@Setter
@ToString
public class ActivityDto {
    private String activityId;
    private String activityName;
    private int activityVisitCount;
    private int activityViewCount;
    private int activityParticipateCount;
    private int activityPrizeCount;
    private BigDecimal activityPrizeAmount;
}
