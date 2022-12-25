package cs.matemaster.standardwebserver.app.facade;

import cs.matemaster.standardwebserver.common.model.request.GenerateSchemaRequest;
import cs.matemaster.standardwebserver.common.model.request.MockSchemaRequest;
import cs.matemaster.standardwebserver.common.model.request.TableSchemaPagingQuery;
import cs.matemaster.standardwebserver.common.model.response.PageDataView;
import cs.matemaster.standardwebserver.common.model.vo.GenerateSchemaVO;
import cs.matemaster.standardwebserver.common.model.vo.MockSchemaVO;
import cs.matemaster.standardwebserver.common.model.vo.TableSchemaVO;

import java.util.List;

/**
 * @author matemaster
 */
public interface SchemaFacade {

    GenerateSchemaVO generateSchema(GenerateSchemaRequest request);

    MockSchemaVO getMockSchema(MockSchemaRequest request);

    PageDataView<List<TableSchemaVO>> pagingTableSchema(TableSchemaPagingQuery query);
}
