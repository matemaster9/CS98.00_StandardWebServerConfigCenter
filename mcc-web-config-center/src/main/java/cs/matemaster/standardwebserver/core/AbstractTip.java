package cs.matemaster.standardwebserver.core;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@Schema(name = "接口统一返回对象")
public abstract class AbstractTip {

    @Schema(description = "状态码")
    protected String code;

    @Schema(description = "接口返回消息")
    protected String message;

    @Schema(description = "时间戳")
    protected Long timestamp;
}
