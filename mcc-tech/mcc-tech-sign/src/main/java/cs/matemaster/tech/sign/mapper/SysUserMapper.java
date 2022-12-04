package cs.matemaster.tech.sign.mapper;


import cs.matemaster.tech.sign.model.SysUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Mapper
@Component
public interface SysUserMapper {

    @Select("select account as username, password " +
            "from sys_user " +
            "where account = #{username} ")
    SysUserDto getSysUserByUsername(String username);
}
