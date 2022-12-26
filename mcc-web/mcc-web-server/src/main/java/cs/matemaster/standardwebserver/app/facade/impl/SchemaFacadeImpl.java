package cs.matemaster.standardwebserver.app.facade.impl;

import cs.matemaster.standardwebserver.app.collaborator.MySQLSyntaxGenerator;
import cs.matemaster.standardwebserver.app.collaborator.PersistentObjectGenerator;
import cs.matemaster.standardwebserver.app.collaborator.SimulatedDataGenerator;
import cs.matemaster.standardwebserver.app.facade.SchemaFacade;
import cs.matemaster.standardwebserver.app.service.SchemaService;
import cs.matemaster.standardwebserver.common.model.dto.ColumnSchemaDto;
import cs.matemaster.standardwebserver.common.model.dto.TableSchemaDto;
import cs.matemaster.standardwebserver.common.model.request.GenerateSchemaRequest;
import cs.matemaster.standardwebserver.common.model.request.MockSchemaRequest;
import cs.matemaster.standardwebserver.common.model.request.TableSchemaPagingQuery;
import cs.matemaster.standardwebserver.common.model.response.PageDataView;
import cs.matemaster.standardwebserver.common.model.vo.GenerateSchemaVO;
import cs.matemaster.standardwebserver.common.model.vo.MockSchemaVO;
import cs.matemaster.standardwebserver.common.model.vo.TableSchemaVO;
import cs.matemaster.standardwebserver.common.util.BusinessUtil;
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

    private final PersistentObjectGenerator persistentObjectGenerator;

    private final SimulatedDataGenerator simulatedDataGenerator;

    private final SchemaService schemaService;

    @Override
    public GenerateSchemaVO generateSchema(GenerateSchemaRequest request) {
        request.validate();
        TableSchemaDto tableSchemaDto = new TableSchemaDto(request);
        String persistentObj = persistentObjectGenerator.getJavaCode(tableSchemaDto);
        String createTableSQL = mySQLSyntaxGenerator.getCreateTableSQL(tableSchemaDto);
        String createIndexSQL = mySQLSyntaxGenerator.getCreateIndexSQL(tableSchemaDto);

        if (request.isEnablePersist()) {
            schemaService.persistTableSchemaInfo(tableSchemaDto, createTableSQL, createIndexSQL);
        }

        GenerateSchemaVO generateSchemaVO = new GenerateSchemaVO();
        generateSchemaVO.setPersistentObj(persistentObj);
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

        MockSchemaVO mockSchemaVO = new MockSchemaVO();
        mockSchemaVO.setInsertDataSQL(insertDataSQL);
        mockSchemaVO.setSimulatedData(simulatedData);
        mockSchemaVO.setJsonSimulatedData(jsonSimulatedData);
        return mockSchemaVO;
    }

    @Override
    public PageDataView<List<TableSchemaVO>> pagingTableSchema(TableSchemaPagingQuery query) {

        int totalCount = schemaService.getTableSchemaTotalCount();
        int queryOffset = BusinessUtil.getQueryOffset(totalCount, query.getPageSize());
        List<TableSchemaVO> data = schemaService.pagingTableSchema(query, queryOffset);

        return PageDataView.<List<TableSchemaVO>>builder()
                .pageNo(query.getPageNo())
                .pageSize(query.getPageSize())
                .data(data)
                .build();
    }
}
