package cs.matemaster.standardwebserver.app.persistence;

import cs.matemaster.standardwebserver.common.model.po.TableSchemaPO;

/**
 * @author matemaster
 */
public interface TableSchemaInfoMapper {

    void insertTableSchema(TableSchemaPO tableSchemaPO);
}
