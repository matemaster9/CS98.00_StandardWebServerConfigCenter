package cs.matemaster.standardwebserver.mapper;

import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author matemaster
 */
public interface SysUserMapper {

    @Insert("insert into sys_user(account, password) values (#{sysUser.account}, #{sysUser.password})")
    int insertSysUser(@Param("sysUser") SysUserDto sysUserDto);

    @Select("select account, password " +
            "from sys_user " +
            "where account = #{account} ")
    SysUserDto getSysUserByAccount(String account);
}
