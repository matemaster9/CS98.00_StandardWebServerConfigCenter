package cs.matemaster.standardwebserver.app.persistence;

import cs.matemaster.standardwebserver.common.model.po.TableSchemaPO;
import cs.matemaster.standardwebserver.common.model.request.TableSchemaPagingQuery;
import cs.matemaster.standardwebserver.common.model.vo.TableSchemaVO;

import java.util.List;

/**
 * @author matemaster
 */
public interface TableSchemaInfoMapper {

    void insertTableSchema(TableSchemaPO tableSchemaPO);

    int queryTableSchemaTotalCount();

    List<TableSchemaVO> findTableSchemaByPagingQuery(TableSchemaPagingQuery query, int offset);
}
