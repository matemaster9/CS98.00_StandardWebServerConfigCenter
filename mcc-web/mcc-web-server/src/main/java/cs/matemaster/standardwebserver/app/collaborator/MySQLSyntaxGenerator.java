package cs.matemaster.standardwebserver.app.collaborator;

import cs.matemaster.standardwebserver.common.model.dto.ColumnSchemaDto;
import cs.matemaster.standardwebserver.common.model.dto.TableSchemaDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@Slf4j
@Component
public class MySQLSyntaxGenerator {


    public String getCreateTableSQL(TableSchemaDto tableSchema) {
        String createTableSQLTemplate = "create table if not exists {0} " +
                "( \n" +
                "{1} \n" +
                ");";
        String tableName = String.join(".", tableSchema.getDatabaseName(), tableSchema.getTableName());
        List<TableSchemaDto.Columns> columnList = tableSchema.getColumnList();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columnList.size() - 1; i++) {
            builder.append(buildColumnSQL(columnList.get(i)));
            builder.append(", \n");
        }
        builder.append(buildColumnSQL(columnList.get(columnList.size() - 1)));

        List<TableSchemaDto.Keys> keyList = tableSchema.getKeyList();
        if (CollectionUtils.isNotEmpty(keyList)) {
            builder.append(", \n");
            for (int i = 0; i < keyList.size() - 1; i++) {
                builder.append(buildConstraintSQL(keyList.get(i)));
                builder.append(", \n");
            }
            builder.append(buildConstraintSQL(keyList.get(columnList.size() - 1)));
        }

        String createTableSQL = MessageFormat.format(createTableSQLTemplate, tableName, builder.toString());
        log.info("CreateTableSQL: {}", createTableSQL);
        return createTableSQL;
    }

    private String buildConstraintSQL(TableSchemaDto.Keys keys) {
        String primaryKeyTemplate = "constraint {0} primary key ({1})";
        String uniqueKeyTemplate = "constraint {0} unique ({1})";

        String result = "";
        String columns = String.join(",", keys.getColumns());
        if (keys.isPrimary()) {
            result = MessageFormat.format(primaryKeyTemplate, keys.getKeyName(), columns);
        }
        if (keys.isUnique()) {
            result = MessageFormat.format(uniqueKeyTemplate, keys.getKeyName(), columns);
        }

        return result;
    }

    private String buildColumnSQL(TableSchemaDto.Columns columns) {
        // e.g : column_name int default current_timestamp not null auto_increment on update ccc comment 'aaa'
        String columnName = columns.getColumnName();
        String dataType = columns.getDataType();
        String defaultValue = columns.getDefaultValue();
        boolean notNull = columns.isNotNull();
        boolean autoIncrement = columns.isAutoIncrement();
        String onUpdate = columns.getOnUpdate();
        String comment = columns.getComment();

        StringBuilder builder = new StringBuilder();
        builder.append(columnName);
        builder.append(" ");

        builder.append(dataType);
        builder.append(" ");

        if (StringUtils.isNotBlank(defaultValue)) {
            builder.append("default ").append(defaultValue).append(" ");
        }

        if (notNull) {
            builder.append("not null ");
        }

        if (autoIncrement) {
            builder.append("auto_increment ");
        }

        if (StringUtils.isNotBlank(onUpdate)) {
            builder.append("on update ").append(onUpdate).append(" ");
        }

        if (StringUtils.isNotBlank(comment)) {
            builder.append("comment ").append("'").append(comment).append("' ");
        }

        return builder.toString();
    }

    public String getCreateIndexSQL(TableSchemaDto tableSchema) {
        List<TableSchemaDto.Indexes> indexList = tableSchema.getIndexList();

        if (CollectionUtils.isEmpty(indexList)) {
            return null;
        }

        String createIndexSQL = indexList.stream().map(item -> buildIndexSQL(item, tableSchema.getTableName())).collect(Collectors.joining(";"));
        log.info("CreateIndexSQL: {}", createIndexSQL);
        return createIndexSQL;
    }

    private String buildIndexSQL(TableSchemaDto.Indexes indexes, String tableName) {
        String createIndexTemplate = "create index {0} on {1} ({2})";
        String createUniqueIndexTemplate = "create unique index {0} on {1} ({2})";

        StringBuilder builder = new StringBuilder();
        String columns = String.join(",", indexes.getColumns());
        String format;
        if (indexes.isUnique()) {
            format = MessageFormat.format(createUniqueIndexTemplate, indexes.getIndexName(), tableName, columns);
        } else {
            format = MessageFormat.format(createIndexTemplate, indexes.getIndexName(), tableName, columns);
        }
        builder.append(format);

        if (StringUtils.isNotBlank(indexes.getComment())) {
            builder.append(" comment ").append("'").append(indexes.getComment()).append("'");
        }

        return builder.toString();
    }

    public String getInsertDataSQL(ColumnSchemaDto columnSchemaDto,List<Map<String, Object>> data) {
        return null;
    }
}
