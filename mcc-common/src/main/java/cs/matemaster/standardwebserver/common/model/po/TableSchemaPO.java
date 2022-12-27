package cs.matemaster.standardwebserver.common.model.po;

import cs.matemaster.standardwebserver.common.model.dto.TableSchemaDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@Data
@NoArgsConstructor
public class TableSchemaPO {

    private long id;

    private String tableName;

    private String columns;

    private String createTableSQL;

    private String createIndexSQL;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private boolean deleteFlag;

    public void init(TableSchemaDto tableSchemaDto, String createTableSQL, String createIndexSQL) {
        String columnsStr = tableSchemaDto.getColumnList()
                .stream()
                .map(TableSchemaDto.Columns::getColumnName)
                .collect(Collectors.joining(","));

        setColumns(columnsStr);
        setTableName(tableSchemaDto.getTableName());
        setCreateTableSQL(createTableSQL);
        setCreateIndexSQL(createIndexSQL);
        setCreateTime(LocalDateTime.now());
        setUpdateTime(LocalDateTime.now());
        setDeleteFlag(false);
    }
}
