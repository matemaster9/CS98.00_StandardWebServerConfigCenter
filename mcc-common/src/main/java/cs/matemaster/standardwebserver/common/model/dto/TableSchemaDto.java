package cs.matemaster.standardwebserver.common.model.dto;

import cs.matemaster.standardwebserver.common.model.request.GenerateSchemaRequest;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author matemaster
 */
@Data
@NoArgsConstructor
public class TableSchemaDto {

    private String databaseName;

    private String tableName;

    private List<Columns> columnList;

    private List<Keys> keyList;

    private List<Indexes> indexList;

    public TableSchemaDto(GenerateSchemaRequest request) {

    }

    @Setter
    @Getter
    public static class Columns {

        private String columnName;

        private String comment;

        private String dataType;

        private boolean notNull;

        private boolean autoIncrement = false;

        private long autoIncrementStart;

        private String defaultValue;

        private String onUpdate;
    }

    @Setter
    @Getter
    public static class Keys {

        private String keyName;

        private boolean primary;

        private List<String> columns;
    }

    @Setter
    @Getter
    public static class Indexes {

        private String indexName;

        private boolean unique;

        private String comment;

        private List<String> columns;
    }
}
