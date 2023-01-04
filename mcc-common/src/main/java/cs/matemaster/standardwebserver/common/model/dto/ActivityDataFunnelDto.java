package cs.matemaster.standardwebserver.common.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author matemaster
 */
@Data
@Schema(name = "活动数据漏斗dto")
public class ActivityDataFunnelDto {

    @Schema(description = "活动id")
    private String activityId;

    @Schema(description = "日期")
    private LocalDate date;

    @Schema(description = "部门id")
    private String deptId;

    @Schema(description = "部门名称")
    private String deptName;

    @Schema(description = "访问人次")
    private int viewCount;

    @Schema(description = "参与人次")
    private int participantNumber;

    @Schema(description = "中奖人次")
    private int prizeNumber;

    @Schema(description = "领奖人次")
    private int recipientNumber;

    @Schema(description = "羊毛党参与人次")
    private int ymdParticipantNumber;

    @Schema(description = "羊毛党领奖人次")
    private int ymdPrizeNumber;

    @Schema(description = "领券人数")
    private int useTicketNumber;

    @Schema(description = "用券人数")
    private int recipientTicketNumber;

    @Schema(description = "中奖金额")
    private BigDecimal prizeAmount;

    @Schema(description = "领奖金额")
    private BigDecimal recipientAmount;
}
