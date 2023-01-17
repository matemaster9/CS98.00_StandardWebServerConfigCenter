package cs.matemaster.standardwebserver.common.model.request;

import cs.matemaster.standardwebserver.common.util.BizAssertUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author matemaster
 */
@Data
@Schema(name = "生成模式请求")
public class GenerateSchemaRequest {

    @Schema(description = "数据库名称")
    private String databaseName;

    @Schema(description = "表名")
    private String tableName;

    @Schema(description = "数据库列")
    private List<Columns> columnList;

    @Schema(description = "表键")
    private List<Keys> keyList;

    @Schema(description = "表索引")
    private List<Indexes> indexList;

    @Schema(description = "是否持久化")
    private boolean enablePersist;

    public void validate() {
        BizAssertUtil.illegalParams(databaseName == null, "数据库名称必填");
        BizAssertUtil.illegalParams(tableName == null, "数据库表名必填");
        BizAssertUtil.illegalParams(CollectionUtils.isEmpty(columnList), "数据库列必填");

        columnList.forEach(columns -> {
            BizAssertUtil.illegalParams(columns.getColumnName() == null, "列名必填");
            BizAssertUtil.illegalParams(columns.getDataType() == null, "数据类型必填");
        });

        if (CollectionUtils.isEmpty(keyList)) {
            return;
        }

        keyList.forEach(keys -> {
            BizAssertUtil.illegalParams(keys.getKeyName() == null, "键名必填");
            BizAssertUtil.illegalParams(CollectionUtils.isEmpty(keys.getColumns()), "包含列必填");
        });

        if (CollectionUtils.isEmpty(indexList)) {
            return;
        }

        indexList.forEach(indexes -> {
            BizAssertUtil.illegalParams(indexes.getIndexName() == null, "索引名必填");
            BizAssertUtil.illegalParams(CollectionUtils.isEmpty(indexes.getColumns()), "包含列必填");
        });
    }

    @Setter
    @Getter
    public static class Columns {

        /**
         * 列名
         */
        private String columnName;

        /**
         * 备注
         */
        private String comment;

        /**
         * 数据类型
         */
        private String dataType;

        /**
         * 是否 not null
         */
        private boolean notNull = false;

        /**
         * 是否 auto_increment
         */
        private boolean autoIncrement = false;

        /**
         * 自增起点
         */
        private long autoIncrementStart = 1;

        /**
         * 列的默认值
         */
        private String defaultValue;

        /**
         * 记录更新时的操作
         */
        private String onUpdate;
    }

    @Setter
    @Getter
    public static class Keys {

        /**
         * 键名称
         */
        private String keyName;

        /**
         * 是否主键
         */
        private boolean primary;

        /**
         * 是否唯一
         */
        private boolean unique;

        /**
         * 键包含的列
         */
        private List<String> columns;
    }

    @Setter
    @Getter
    public static class Indexes {

        /**
         * 索引名称
         */
        private String indexName;

        /**
         * 是否为唯一索引
         */
        private boolean unique;

        /**
         * 备注
         */
        private String comment;

        /**
         * 索引包含的列
         */
        private List<String> columns;
    }
}
