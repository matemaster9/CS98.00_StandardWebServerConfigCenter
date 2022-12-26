package cs.matemaster.standardwebserver.app.service.impl;

import cs.matemaster.standardwebserver.app.constant.AppErrorEnum;
import cs.matemaster.standardwebserver.app.persistence.TableSchemaInfoMapper;
import cs.matemaster.standardwebserver.app.service.SchemaService;
import cs.matemaster.standardwebserver.common.exception.BaseTransactionException;
import cs.matemaster.standardwebserver.common.model.dto.TableSchemaDto;
import cs.matemaster.standardwebserver.common.model.po.TableSchemaPO;
import cs.matemaster.standardwebserver.common.model.request.TableSchemaPagingQuery;
import cs.matemaster.standardwebserver.common.model.vo.TableSchemaVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author matemaster
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SchemaServiceImpl implements SchemaService {

    private final TableSchemaInfoMapper tableSchemaInfoMapper;

    @Override
    @Transactional(rollbackFor = BaseTransactionException.class)
    public void persistTableSchema(TableSchemaDto tableSchemaDto) {
        TableSchemaPO tableSchemaPO = new TableSchemaPO(tableSchemaDto);
        try {
            tableSchemaInfoMapper.insertTableSchema(tableSchemaPO);
        } catch (Exception e) {
            throw new BaseTransactionException(AppErrorEnum.STORE_TABLE_SCHEMA_ERROR);
        }
        log.info("保存成功 table_name: {} create_time: {}", tableSchemaDto.getTableName(), tableSchemaPO.getCreateTime());
    }

    @Override
    public int getTableSchemaTotalCount() {
        return tableSchemaInfoMapper.queryTableSchemaTotalCount();
    }

    @Override
    public List<TableSchemaVO> pagingTableSchema(TableSchemaPagingQuery query, int offset) {
        return tableSchemaInfoMapper.findTableSchemaByPagingQuery(query, offset);
    }
}
