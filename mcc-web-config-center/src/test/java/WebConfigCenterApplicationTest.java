
import cs.matemaster.standardwebserver.WebConfigCenterApplication;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import cs.matemaster.standardwebserver.config.WebSystemConfig;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfigCenterApplication.class)
public class WebConfigCenterApplicationTest {

    @Autowired
    private WebSystemConfig webSystemConfig;

    @Test
    public void test1() throws DecoderException {
        SysUserDto sysUser = new SysUserDto();
        sysUser.setAccount("12968912984");
        sysUser.setPassword("#skuVJDWO987");

        String plainText = JsonUtil.serialize(sysUser);
        String cipher = SecurityUtil.RSAPublicKeyEncrypt(plainText, webSystemConfig.getRsaPublicKey());
        System.out.println(cipher);
        String decrypt = SecurityUtil.RSAPrivateKeyDecrypt(cipher, webSystemConfig.getRsaPrivateKey());
        System.out.println(decrypt);
        System.out.println(new String(Hex.decodeHex(decrypt), StandardCharsets.UTF_8));
    }

    @Test
    public void test2() throws DecoderException {
        SysUserDto sysUser = new SysUserDto();
        sysUser.setAccount("12968912984");
        sysUser.setPassword("#skuVJDWO987");
        String plainText = JsonUtil.serialize(sysUser);

        String cipher = SecurityUtil.RSAPrivateKeyEncrypt(plainText, webSystemConfig.getRsaPrivateKey());
        System.out.println(cipher);
        String decrypt = SecurityUtil.RSAPublicKeyDecrypt(cipher, webSystemConfig.getRsaPublicKey());
        System.out.println(decrypt);
        System.out.println(new String(Hex.decodeHex(decrypt), StandardCharsets.UTF_8));
    }
}
