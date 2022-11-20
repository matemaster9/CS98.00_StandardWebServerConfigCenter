package cs.matemaster.standardwebserver.facade;

import cs.matemaster.standardwebserver.common.model.dto.sys.EncryptedSysUser;

/**
 * @author matemaster
 */
public interface AuthFacade {

    String sign(EncryptedSysUser request);
}
