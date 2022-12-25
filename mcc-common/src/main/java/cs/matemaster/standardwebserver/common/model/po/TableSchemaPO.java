package cs.matemaster.standardwebserver.common.model.po;

import cs.matemaster.standardwebserver.common.model.dto.TableSchemaDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author matemaster
 */
@Data
@NoArgsConstructor
public class TableSchemaPO {

    private long id;

    private String tableName;

    private String comment;

    private String columns;

    private String createTableSQL;

    private String createIndexSQL;

    private LocalDate createTime;

    private LocalDate updateTime;

    private boolean deleteFlag;

    public TableSchemaPO(TableSchemaDto tableSchemaDto) {
    }
}
