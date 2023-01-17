package cs.matemaster.standardwebserver.app.service;

import cs.matemaster.standardwebserver.common.model.dto.TableSchemaDto;
import cs.matemaster.standardwebserver.common.model.request.TableSchemaPagingQuery;
import cs.matemaster.standardwebserver.common.model.vo.TableSchemaVO;

import java.util.List;

/**
 * @author matemaster
 */
public interface SchemaService {

    void persistTableSchemaInfo(TableSchemaDto tableSchemaDto, String tableSQL, String indexSQL);


    int getTableSchemaTotalCount();

    List<TableSchemaVO> pagingTableSchema(TableSchemaPagingQuery query, int start, int offset);
}
