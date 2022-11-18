import cs.matemaster.standardwebserver.authority.util.JsonWebTokenUtil;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import io.jsonwebtoken.Claims;
import org.junit.Test;

/**
 * @author matemaster
 */
public class JWTTest {

    @Test
    public void name() {
        SysUserDto sysUser = new SysUserDto();
        sysUser.setAccount("12968912984");
        sysUser.setPassword("#skuVJDWO987");

        String token = JsonWebTokenUtil.getToken(sysUser);
        System.out.println(token);

        SysUserDto message = JsonWebTokenUtil.getMessage(token);
        System.out.println(message);
    }


    @Test
    public void name1() {
        SysUserDto sysUser = new SysUserDto();
        sysUser.setAccount("12968912984");
        sysUser.setPassword("#skuVJDWO987");

        String token = JsonWebTokenUtil.getToken(sysUser);
        System.out.println(token);

        Claims message = JsonWebTokenUtil.getClaims(token);
        System.out.println(message.get("SysUser", String.class));
    }
}
