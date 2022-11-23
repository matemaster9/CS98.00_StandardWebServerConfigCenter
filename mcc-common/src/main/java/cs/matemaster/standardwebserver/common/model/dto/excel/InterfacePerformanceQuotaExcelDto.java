package cs.matemaster.standardwebserver.common.model.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author matemaster
 */
@Getter
@Setter
@ToString
public class InterfacePerformanceQuotaExcelDto {

    @ExcelProperty(value = "接口路径")
    private String path;

    @ExcelProperty(value = "协议")
    private String protocol;

    @ExcelProperty(value = "交易响应时间")
    private long responseTime;

    @ExcelProperty(value = "每秒点击次数")
    private long hps;

    @ExcelProperty(value = "系统每秒处理查询次数")
    private long qps;

    @ExcelProperty(value = "系统每秒处理交易数")
    private long tps;

    @ExcelProperty(value = "并发用户")
    private int virtualUser;
}
