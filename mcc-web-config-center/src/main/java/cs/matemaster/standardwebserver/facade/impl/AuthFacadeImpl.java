package cs.matemaster.standardwebserver.facade.impl;

import cs.matemaster.standardwebserver.common.exception.IllegalParamsException;
import cs.matemaster.standardwebserver.common.model.dto.sys.EncryptedSysUser;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import cs.matemaster.standardwebserver.config.SecurityConfig;
import cs.matemaster.standardwebserver.facade.AuthFacade;
import cs.matemaster.standardwebserver.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class AuthFacadeImpl implements AuthFacade {

    private SecurityConfig securityConfig;
    private AuthService authService;

    @Override
    public String sign(EncryptedSysUser request) {
        request.validate();
        String account = SecurityUtil.AESDecryptAsPlainText(request.getEncryptedAccount(), securityConfig.getAesSecretKey());
        String password = SecurityUtil.AESDecryptAsPlainText(request.getEncryptedPassword(), securityConfig.getAesSecretKey());

        if (Objects.isNull(account) || Objects.isNull(password)) {
            throw new IllegalParamsException("非法用户信息");
        }

        SysUserDto sysUser = new SysUserDto();
        sysUser.setAccount(account);
        sysUser.setPassword(password);

        return authService.sign(sysUser);
    }
}
