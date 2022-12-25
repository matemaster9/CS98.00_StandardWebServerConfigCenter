package cs.matemaster.standardwebserver.common.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@Schema(name = "表格信息分页查询请求")
public class TableSchemaPagingQuery extends PagingParam {

    @Schema(description = "表格名称")
    private String name;
}
