import cs.matemaster.standardwebserver.common.model.dto.sys.EncryptedSysUser;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import org.junit.Test;

/**
 * @author matemaster
 */
public class MockTest {

    @Test
    public void test() {
        EncryptedSysUser encryptedSysUser = new EncryptedSysUser();
        encryptedSysUser.setEncryptAlgorithm("AES");

        String account = SecurityUtil.AESEncryptAsBase64("21869481", "3bxL6KTWwvIkcXC/4XUk+wblWM4rx3hgStKBaFSFVDk=");
        String password = SecurityUtil.AESEncryptAsBase64("#OASCBH87", "3bxL6KTWwvIkcXC/4XUk+wblWM4rx3hgStKBaFSFVDk=");
        encryptedSysUser.setEncryptedAccount(account);
        encryptedSysUser.setEncryptedPassword(password);

        String serialize = JsonUtil.serialize(encryptedSysUser);
        System.out.println(serialize);
    }
}
