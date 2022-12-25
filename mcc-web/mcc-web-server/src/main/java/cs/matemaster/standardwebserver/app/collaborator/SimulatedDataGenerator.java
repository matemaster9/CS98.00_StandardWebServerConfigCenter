package cs.matemaster.standardwebserver.app.collaborator;

import cs.matemaster.standardwebserver.common.model.dto.ColumnSchemaDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Component
public class SimulatedDataGenerator {
    public List<Map<String, Object>> getColumnDataList(ColumnSchemaDto columnSchemaDto) {
        return Collections.emptyList();
    }
}
