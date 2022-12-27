package cs.matemaster.standardwebserver.app.persistence;

import cs.matemaster.standardwebserver.common.model.po.TableSchemaPO;
import cs.matemaster.standardwebserver.common.model.request.TableSchemaPagingQuery;
import cs.matemaster.standardwebserver.common.model.vo.TableSchemaVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("select count(1) " +
            "from table_schema_info " +
            "where delete_flag = 0")
    int queryTableSchemaTotalCount();

    @Select("select a.id, " +
            "       a.table_name, " +
            "       a.columns, " +
            "       a.create_table_sql, " +
            "       a.create_index_sql, " +
            "       a.create_time, " +
            "       a.update_time, " +
            "       a.delete_flag " +
            "from table_schema_info as a " +
            "         inner join (select id " +
            "                     from table_schema_info " +
            "                     where table_name like #{q.name} " +
            "                       and delete_flag = 0 " +
            "                     limit #{startIndex},#{offset}) as b " +
            "                    on a.id = b.id")
    List<TableSchemaVO> findTableSchemaByPagingQuery(@Param("q") TableSchemaPagingQuery query, @Param("startIndex") int startIndex, @Param("offset") int offset);
}
