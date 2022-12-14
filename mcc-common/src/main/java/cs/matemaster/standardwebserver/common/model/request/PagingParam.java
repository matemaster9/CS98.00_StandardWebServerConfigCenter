package cs.matemaster.standardwebserver.common.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author matemaster
 */
@Setter
@Getter
@Schema(name = "分页参数")
public class PagingParam {

    @Schema(description = "页号")
    private int pageNo = 1;

    @Schema(description = "页面大小")
    private int pageSize = 10;
}
