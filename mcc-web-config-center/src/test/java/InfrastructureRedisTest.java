import cs.matemaster.standardwebserver.WebConfigCenterApplication;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.infrastructure.redis.RedisClientSupport;
import cs.matemaster.standardwebserver.infrastructure.redis.RedisClientProps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfigCenterApplication.class)
public class InfrastructureRedisTest {

    @Autowired
    private RedisClientProps redisClientProps;
    @Autowired
    private RedisClientSupport redisClientSupport;

    @Test
    public void test1() {
        System.out.println(redisClientProps);
    }

    @Test
    public void test2() {
        SysUserDto sysUser = new SysUserDto();
        sysUser.setAccount("12968912984");
        sysUser.setPassword("#skuVJDWO987");
        String serialize = JsonUtil.serialize(sysUser);

        redisClientSupport.setMessage("SysUser", sysUser.getAccount(), serialize);
    }
}
