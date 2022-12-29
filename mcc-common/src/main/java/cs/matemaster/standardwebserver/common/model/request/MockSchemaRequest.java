package cs.matemaster.standardwebserver.common.model.request;

import cs.matemaster.standardwebserver.common.constant.MockDataTypeEnum;
import cs.matemaster.standardwebserver.common.util.BizAssertUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

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
        BizAssertUtil.illegalParams(StringUtils.isBlank(tableName),"表名不可空");
        BizAssertUtil.illegalParams(CollectionUtils.isEmpty(columnsList),"列信息不可空");
        columnsList.forEach(item -> {
            BizAssertUtil.illegalParams(StringUtils.isBlank(item.getColumnName()),"列名不可空");
            BizAssertUtil.illegalParams(MockDataTypeEnum.getInstanceByCode(item.getMockType()) == null,"请选择合适模拟类型");
        });
    }

    @Setter
    @Getter
    public static class Columns {

        private String columnName;

        private int mockType;
    }
}
