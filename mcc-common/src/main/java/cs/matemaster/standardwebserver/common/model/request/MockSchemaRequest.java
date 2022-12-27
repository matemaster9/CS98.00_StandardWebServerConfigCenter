package cs.matemaster.standardwebserver.common.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author matemaster
 */
@Data
@Schema(name = "mock模式请求")
public class MockSchemaRequest {

    @Schema(description = "表名")
    private String tableName;

    @Schema(description = "列信息")
    private List<Columns> columnsList;

    public void validate() {

    }

    @Setter
    @Getter
    public static class Columns {

        private String columnName;

        private int mockType;
    }
}
