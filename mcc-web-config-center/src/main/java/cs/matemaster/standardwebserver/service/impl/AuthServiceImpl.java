package cs.matemaster.standardwebserver.service.impl;

import cs.matemaster.standardwebserver.authority.service.AuthServiceSupport;
import cs.matemaster.standardwebserver.authority.util.JsonWebTokenUtil;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.BusinessUtil;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import cs.matemaster.standardwebserver.config.SecurityConfig;
import cs.matemaster.standardwebserver.constant.ConfigCenterErrorEnum;
import cs.matemaster.standardwebserver.exception.BaseBusinessException;
import cs.matemaster.standardwebserver.mapper.SysUserMapper;
import cs.matemaster.standardwebserver.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author matemaster
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private SysUserMapper sysUserMapper;

    private AuthServiceSupport authServiceSupport;

    private SecurityConfig securityConfig;

    @Override
    public String sign(SysUserDto sysUser) {
        SysUserDto sysUserInfo = sysUserMapper.getSysUserByAccount(sysUser.getAccount());

        if (Objects.isNull(sysUserInfo)) {
            throw new BaseBusinessException(ConfigCenterErrorEnum.MCCA_ACCOUNT_NOT_EXIST);
        }

        if (!sysUserInfo.equals(sysUser)) {
            throw new BaseBusinessException(ConfigCenterErrorEnum.MCCA_PASSWORD_ERROR);
        }

        String cipher = SecurityUtil.AESEncrypt(JsonUtil.serialize(sysUser), securityConfig.getAesSecretKey());
        String tokenId = JsonWebTokenUtil.getTokenId();

        return authServiceSupport.getToken(cipher, tokenId);
    }
}
