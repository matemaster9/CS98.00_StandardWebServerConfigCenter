package cs.matemaster.standardwebserver.app.persistence;

import cs.matemaster.standardwebserver.common.model.po.TableSchemaPO;
import cs.matemaster.standardwebserver.common.model.request.TableSchemaPagingQuery;
import cs.matemaster.standardwebserver.common.model.vo.TableSchemaVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author matemaster
 */
@Mapper
public interface TableSchemaInfoMapper {

    @Insert("insert into table_schema_info" +
            "(table_name, columns, create_table_sql, create_index_sql) " +
            "VALUES " +
            "(#{po.tableName}, #{po.columns}, #{po.createTableSQL}, #{po.createIndexSQL})")
    void insertTableSchema(@Param("po") TableSchemaPO tableSchemaPO);

    int queryTableSchemaTotalCount();

    List<TableSchemaVO> findTableSchemaByPagingQuery(TableSchemaPagingQuery query, int offset);
}
