package cs.matemaster.standardwebserver.app.collaborator;

import cs.matemaster.standardwebserver.common.model.dto.TableSchemaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Slf4j
@Component
public class MySQLSyntaxGenerator {


    public String getCreateTableSQL(TableSchemaDto tableSchema) {
        return null;
    }

    public String getCreateIndexSQL(TableSchemaDto tableSchema) {
        return null;
    }

    public String getInsertDataSQL(List<Map<String, Object>> data) {
        return null;
    }
}
