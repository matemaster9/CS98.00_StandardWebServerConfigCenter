package cs.matemaster.standardwebserver.common.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Data
public class MockSchemaVO {

    @Schema(description = "插入数据SQL")
    private String insertDataSQL;

    @Schema(description = "持久化对象")
    private String persistentObj;

    @Schema(description = "模拟数据")
    private List<Map<String, Object>> simulatedData;

    @Schema(description = "json格式的模拟数据")
    private String jsonSimulatedData;
}
