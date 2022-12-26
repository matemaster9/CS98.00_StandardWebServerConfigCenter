package cs.matemaster.standardwebserver.common.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@Schema(name = "生成模式视图")
public class GenerateSchemaVO {

    @Schema(description = "建表SQL")
    private String createTableSQL;

    @Schema(description = "创建索引SQL")
    private String createIndexSQL;

    @Schema(description = "持久化对象")
    private String persistentObj;
}
