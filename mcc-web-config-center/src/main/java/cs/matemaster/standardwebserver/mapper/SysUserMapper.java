package cs.matemaster.standardwebserver.mapper;

import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author matemaster
 */
public interface SysUserMapper {

    @Insert("insert into sys_user(account, password) values (#{sysUser.account}, #{sysUser.password})")
    int insertSysUser(@Param("sysUser") SysUserDto sysUserDto);
}
