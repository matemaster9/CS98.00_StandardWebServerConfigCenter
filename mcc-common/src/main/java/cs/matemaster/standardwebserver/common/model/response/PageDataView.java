package cs.matemaster.standardwebserver.common.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

/**
 * @author matemaster
 */
@Getter
@Builder
@Schema(name = "分页视图")
public class PageDataView<T> {

    @Schema(description = "页号")
    private int pageNo;

    @Schema(description = "页面大小")
    private int pageSize;

    @Schema(description = "数据")
    private T data;

    @Schema(description = "数据总数")
    private int totalCount;
}
