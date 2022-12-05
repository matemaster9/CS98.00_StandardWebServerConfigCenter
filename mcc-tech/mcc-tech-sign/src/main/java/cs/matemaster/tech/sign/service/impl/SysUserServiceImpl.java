package cs.matemaster.tech.sign.service.impl;

import cs.matemaster.standardwebserver.common.exception.BaseBusinessException;
import cs.matemaster.standardwebserver.common.exception.IllegalParamsException;
import cs.matemaster.tech.sign.mapper.SysUserMapper;
import cs.matemaster.tech.sign.model.SysUserDto;
import cs.matemaster.tech.sign.service.SysUserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author matemaster
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private SysUserMapper sysUserMapper;

    @Override
    public void validate(SysUserDto sysUserDto) {
        SysUserDto sysUser = sysUserMapper.getSysUserByUsername(sysUserDto.getUsername());
        if (sysUser == null) {
            throw new BaseBusinessException("用户不存在");
        }

        if (!StringUtils.equals(sysUser.getPassword(), sysUserDto.getPassword())) {
            throw new BaseBusinessException("用户信息不匹配");
        }
    }
}
