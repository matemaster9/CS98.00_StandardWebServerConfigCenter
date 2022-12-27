package cs.matemaster.standardwebserver.common.model.dto;

import cs.matemaster.standardwebserver.common.model.request.MockSchemaRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@Data
@NoArgsConstructor
public class ColumnSchemaDto {

    private String table;

    private Map<String, Integer> columns;


    public void assemble(MockSchemaRequest request) {
        String tableName = request.getTableName();
        Map<String, Integer> columnsMap = request.getColumnsList().stream().collect(Collectors.toMap(MockSchemaRequest.Columns::getColumnName, MockSchemaRequest.Columns::getMockType));
        setTable(tableName);
        setColumns(columnsMap);
    }
}
