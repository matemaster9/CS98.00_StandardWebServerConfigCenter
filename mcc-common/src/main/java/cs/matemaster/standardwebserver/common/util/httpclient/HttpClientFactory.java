package cs.matemaster.standardwebserver.common.util.httpclient;


import cs.matemaster.standardwebserver.common.util.BusinessUtil;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
public class HttpClientFactory {

    private HttpClientFactory() {
    }

    public static CloseableHttpClient getHttpClient(int connectionRequestTimeout,
                                                    int connectionTimeout,
                                                    int socketTimeout) {

        return HttpClients.custom()
                .setDefaultRequestConfig(getRequestConfig(connectionRequestTimeout, connectionTimeout, socketTimeout))
                .setRetryHandler(getRetryHandler())
                .setConnectionManager(getConnectionManager())
                .build();

    }

    private static RequestConfig getRequestConfig(int connectionRequestTimeout,
                                                  int connectionTimeout,
                                                  int socketTimeout) {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
    }

    private static HttpRequestRetryHandler getRetryHandler() {
        return (exception, executionCount, context) -> {

            // ???????????????????????????
            if (executionCount >= HttpClientConfig.RETRY_EXECUTION_COUNT) {
                return false;
            }
            // ??????????????????????????????
            if (exception instanceof NoHttpResponseException) {
                return true;
            }
            // SSL?????????????????????
            if (exception instanceof SSLHandshakeException) {
                return false;
            }
            // ???????????????????????????
            if (exception instanceof ConnectTimeoutException) {
                return false;
            }
            // ???????????????
            if (exception instanceof InterruptedIOException) {
                return true;
            }
            // ?????????????????????????????????
            if (exception instanceof UnknownHostException) {
                return false;
            }
            // SSL???????????????
            if (exception instanceof SSLException) {
                return false;
            }
            HttpClientContext httpClientContext = HttpClientContext.adapt(context);
            HttpRequest request = httpClientContext.getRequest();

            // ???????????????????????????
            return BusinessUtil.isFalse(request instanceof HttpEntityEnclosingRequest);
        };
    }

    private static PoolingHttpClientConnectionManager getConnectionManager() {

        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(3, TimeUnit.MINUTES);

        // ?????????????????????????????????????????????????????????????????????
        manager.setMaxTotal(200);
        manager.setDefaultMaxPerRoute(50);
        manager.closeIdleConnections(30, TimeUnit.MINUTES);
        manager.closeExpiredConnections();

        return manager;
    }

}
