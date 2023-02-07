package cs.matemaster.standardwebserver.app.persistence;

import cs.matemaster.standardwebserver.common.model.dto.CallLogPO;

/**
 * @author matemaster
 */
public interface CallLogMapper {


    int insertCallLog(CallLogPO log);
}
