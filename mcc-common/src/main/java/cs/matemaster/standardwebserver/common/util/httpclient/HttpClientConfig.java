package cs.matemaster.standardwebserver.common.util.httpclient;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
public final class HttpClientConfig {
    public static final String CONTENT_TYPE_URL_ENCODED = "application/x-www-form-urlencoded; charset=UTF-8";
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json; charset=UTF-8";
    public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain; charset=UTF-8";
    public static final int RETRY_EXECUTION_COUNT = 0;
    public static final int CONNECTION_REQUEST_TIMEOUT = 1_000;
    public static final int CONNECTION_TIMEOUT = 3_000;
    public static final int SOCKET_TIMEOUT = 10_000;
}
