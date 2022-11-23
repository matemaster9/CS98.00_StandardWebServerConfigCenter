package cs.matemaster.standardwebserver.common.model.dto.excel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author matemaster
 */
@Getter
@Builder
@ToString
@Schema(name = "接口性能分析对象")
public class InterfacePerformanceQuota {

    @Schema(name = "接口路径")
    private String path;

    @Schema(name = "协议")
    private String protocol;

    @Schema(name = "交易响应时间")
    private long responseTime;

    @Schema(name = "每秒点击次数")
    private long hps;

    @Schema(name = "系统每秒处理查询次数")
    private long qps;

    @Schema(name = "系统每秒处理交易数")
    private long tps;

    @Schema(name = "并发用户")
    private int virtualUser;
}
