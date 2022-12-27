package cs.matemaster.standardwebserver.app.collaborator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cs.matemaster.standardwebserver.common.constant.MockDataTypeEnum;
import cs.matemaster.standardwebserver.common.model.dto.ColumnSchemaDto;
import cs.matemaster.standardwebserver.common.util.DataFakerUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Component
public class SimulatedDataGenerator {
    public List<Map<String, Object>> getColumnDataList(ColumnSchemaDto columnSchemaDto) {
        Map<String, Integer> columns = columnSchemaDto.getColumns();

        List<Map<String, Object>> result = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            Map<String, Object> item = Maps.newHashMap();
            for (Map.Entry<String, Integer> entry : columns.entrySet()) {
                Integer mockType = entry.getValue();
                String mockData = DataFakerUtil.getRandomValue(MockDataTypeEnum.getInstanceByCode(mockType));
                item.put(entry.getKey(), mockData);
            }
            result.add(item);
        }
        return result;
    }
}
