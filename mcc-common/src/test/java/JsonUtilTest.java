import com.fasterxml.jackson.core.type.TypeReference;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import org.junit.Test;

/**
 * @author matemaster
 */
public class JsonUtilTest {

    @Test
    public void test1() {
        SysUserDto sysUser = new SysUserDto();
        sysUser.setAccount("12968912984");
        sysUser.setPassword("#skuVJDWO987");
        String serialize = JsonUtil.serialize(sysUser);
        System.out.println(serialize);

        SysUserDto deserialize = JsonUtil.deserialize(serialize, SysUserDto.class);
        System.out.println(deserialize);
    }
}
