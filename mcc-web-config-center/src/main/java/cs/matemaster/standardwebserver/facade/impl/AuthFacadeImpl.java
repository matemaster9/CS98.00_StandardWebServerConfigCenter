package cs.matemaster.standardwebserver.facade.impl;

import cs.matemaster.standardwebserver.common.exception.IllegalParamsException;
import cs.matemaster.standardwebserver.common.model.dto.sys.EncryptedSysUser;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import cs.matemaster.standardwebserver.config.SecurityConfig;
import cs.matemaster.standardwebserver.facade.AuthFacade;
import cs.matemaster.standardwebserver.service.AuthService;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
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
        String accountHexStr = SecurityUtil.AESDecrypt(request.getEncryptedAccount(), securityConfig.getAesSecretKey());
        String passwordHexStr = SecurityUtil.AESDecrypt(request.getEncryptedPassword(), securityConfig.getAesSecretKey());

        if (Objects.isNull(accountHexStr) || Objects.isNull(passwordHexStr)) {
            throw new IllegalParamsException("非法用户信息");
        }

        SysUserDto sysUser = new SysUserDto();
        try {
            sysUser.setAccount(new String(Hex.decodeHex(accountHexStr), StandardCharsets.UTF_8));
            sysUser.setPassword(new String(Hex.decodeHex(passwordHexStr), StandardCharsets.UTF_8));
        } catch (DecoderException e) {
            throw new IllegalParamsException(e.getMessage());
        }

        return authService.sign(sysUser);
    }
}
