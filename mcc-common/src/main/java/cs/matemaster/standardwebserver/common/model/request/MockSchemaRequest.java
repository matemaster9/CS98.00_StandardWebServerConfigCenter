package cs.matemaster.standardwebserver.common.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@Schema(name = "mock模式请求")
public class MockSchemaRequest {

    @Schema(description = "数据库名称")
    private String databaseName;

    @Schema(description = "表名")
    private String tableName;

    @Schema(description = "列名")
    private String columnName;

    @Schema(description = "备注")
    private String comment;

    @Schema(description = "数据类型")
    private String dataType;

    @Schema(description = "是否 auto_increment")
    private boolean autoIncrement = false;

    @Schema(description = "自增起点")
    private long autoIncrementStart;

    public void validate() {

    }
}
