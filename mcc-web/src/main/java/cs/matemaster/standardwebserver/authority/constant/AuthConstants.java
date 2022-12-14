package cs.matemaster.standardwebserver.authority.constant;

/**
 * @author matemaster
 */
public final class AuthConstants {
    private AuthConstants() {
    }

    public static final String CipherUser = "CipherUser";
    public static final String TokenId = "TokenId";
    public static final long AccessExpireSecond = 30 * 60L;
    public static final long RefreshExpireSecond = 24 * 60 * 60L;
}
