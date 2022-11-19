package cs.matemaster.standardwebserver.aop.auth;

/**
 * @author matemaster
 */
public final class AuthConstants {

    public static final String CipherUser = "CipherUser";
    public static final String TokenId = "TokenId";
    public static final long AccessExpireSecond = 30 * 60;
    public static final long RefreshExpireSecond = 24 * 60 * 60;
}
