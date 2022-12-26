package cs.matemaster.standardwebserver.common.model.dto;

import cs.matemaster.standardwebserver.common.model.request.GenerateSchemaRequest;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        databaseName = request.getDatabaseName();
        tableName = request.getTableName();
        columnList = request.getColumnList().stream().map(Columns::new).collect(Collectors.toList());
        keyList = CollectionUtils.isEmpty(request.getKeyList()) ? Collections.emptyList() : request.getKeyList().stream().map(Keys::new).collect(Collectors.toList());
        indexList = CollectionUtils.isEmpty(request.getIndexList()) ? Collections.emptyList() : request.getIndexList().stream().map(Indexes::new).collect(Collectors.toList());
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Columns {

        private String columnName;

        private String comment;

        private String dataType;

        private boolean notNull;

        private boolean autoIncrement = false;

        private String defaultValue;

        private String onUpdate;

        public Columns(GenerateSchemaRequest.Columns columns) {
            columnName = columns.getColumnName();
            comment = columns.getComment();
            dataType = columns.getDataType();
            notNull = columns.isNotNull();
            autoIncrement = columns.isAutoIncrement();
            defaultValue = columns.getDefaultValue();
            onUpdate = columns.getOnUpdate();
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Keys {

        private String keyName;

        private boolean primary;

        private boolean unique;

        private List<String> columns;

        public Keys(GenerateSchemaRequest.Keys keys) {
            this.keyName = keys.getKeyName();
            this.primary = keys.isPrimary();
            this.unique = keys.isUnique();
            this.columns = keys.getColumns();
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Indexes {

        private String indexName;

        private boolean unique;

        private String comment;

        private List<String> columns;

        public Indexes(GenerateSchemaRequest.Indexes indexes) {
            this.indexName = indexes.getIndexName();
            this.unique = indexes.isUnique();
            this.comment = indexes.getComment();
            this.columns = indexes.getColumns();
        }
    }
}
