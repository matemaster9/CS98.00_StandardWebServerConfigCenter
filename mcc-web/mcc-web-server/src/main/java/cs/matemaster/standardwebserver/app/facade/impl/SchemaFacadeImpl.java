package cs.matemaster.standardwebserver.app.facade.impl;

import cs.matemaster.standardwebserver.app.collaborator.MySQLSyntaxGenerator;
import cs.matemaster.standardwebserver.app.collaborator.PersistentObjectBuilder;
import cs.matemaster.standardwebserver.app.collaborator.SimulatedDataGenerator;
import cs.matemaster.standardwebserver.app.facade.SchemaFacade;
import cs.matemaster.standardwebserver.common.model.dto.ColumnSchemaDto;
import cs.matemaster.standardwebserver.common.model.dto.TableSchemaDto;
import cs.matemaster.standardwebserver.common.model.request.GenerateSchemaRequest;
import cs.matemaster.standardwebserver.common.model.request.MockSchemaRequest;
import cs.matemaster.standardwebserver.common.model.vo.GenerateSchemaVO;
import cs.matemaster.standardwebserver.common.model.vo.MockSchemaVO;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Component
@RequiredArgsConstructor
public class SchemaFacadeImpl implements SchemaFacade {

    private final MySQLSyntaxGenerator mySQLSyntaxGenerator;

    private final PersistentObjectBuilder persistentObjectBuilder;

    private final SimulatedDataGenerator simulatedDataGenerator;

    @Override
    public GenerateSchemaVO generateSchema(GenerateSchemaRequest request) {
        request.validate();
        TableSchemaDto tableSchemaDto = new TableSchemaDto(request);
        String createTableSQL = mySQLSyntaxGenerator.getCreateTableSQL(tableSchemaDto);
        String createIndexSQL = mySQLSyntaxGenerator.getCreateIndexSQL(tableSchemaDto);

        GenerateSchemaVO generateSchemaVO = new GenerateSchemaVO();
        generateSchemaVO.setCreateTableSQL(createTableSQL);
        generateSchemaVO.setCreateIndexSQL(createIndexSQL);
        return generateSchemaVO;
    }

    @Override
    public MockSchemaVO getMockSchema(MockSchemaRequest request) {
        request.validate();
        ColumnSchemaDto columnSchemaDto = new ColumnSchemaDto();
        List<Map<String, Object>> simulatedData = simulatedDataGenerator.getColumnDataList(columnSchemaDto);
        String insertDataSQL = mySQLSyntaxGenerator.getInsertDataSQL(simulatedData);
        String jsonSimulatedData = JsonUtil.pretty(JsonUtil.serialize(simulatedData));
        String persistentObj = persistentObjectBuilder.getJavaCode(columnSchemaDto);

        MockSchemaVO mockSchemaVO = new MockSchemaVO();
        mockSchemaVO.setInsertDataSQL(insertDataSQL);
        mockSchemaVO.setPersistentObj(persistentObj);
        mockSchemaVO.setSimulatedData(simulatedData);
        mockSchemaVO.setJsonSimulatedData(jsonSimulatedData);
        return mockSchemaVO;
    }
}
