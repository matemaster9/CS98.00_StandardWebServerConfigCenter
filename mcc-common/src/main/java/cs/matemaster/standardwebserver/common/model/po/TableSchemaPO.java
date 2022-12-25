package cs.matemaster.standardwebserver.common.model.po;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author matemaster
 */
@Data
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
}
