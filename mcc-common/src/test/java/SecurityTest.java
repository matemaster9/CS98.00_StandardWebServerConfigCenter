import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author matemaster
 */
public class SecurityTest {

    @Test
    public void name() {
        Map<String, String> keyPair = SecurityUtil.getRSAKeyPair(SecurityUtil.PasswordLength.Level_1);
        System.out.println(keyPair.get("PublicKeyStr"));
        System.out.println(keyPair.get("PrivateKeyStr"));
    }

    @Test
    public void test1() {
        String aesSecretKey = SecurityUtil.getAESSecretKey(SecurityUtil.PasswordLength.AES_3);
        System.out.println(aesSecretKey);
    }

    @Test
    public void test2() throws DecoderException {
        SysUserDto sysUser = new SysUserDto();
        sysUser.setAccount("12968912984");
        sysUser.setPassword("#skuVJDWO987");
        String message = JsonUtil.serialize(sysUser);

        String secretKey = SecurityUtil.getAESSecretKey(SecurityUtil.PasswordLength.AES_1);

        String encryptedMessage = SecurityUtil.AESEncrypt(message, secretKey);
        String decryptedMessage = SecurityUtil.AESDecrypt(encryptedMessage, secretKey);

        System.out.println(encryptedMessage);
        System.out.println(decryptedMessage);
        System.out.println(new String(Hex.decodeHex(decryptedMessage), StandardCharsets.UTF_8));
    }
}
