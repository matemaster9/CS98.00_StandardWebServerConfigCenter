package cs.matemaster.tech.es_client;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import cs.matemaster.tech.es_client.model.KibanaSampleDataLog;
import lombok.SneakyThrows;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClient;

import javax.net.ssl.SSLContext;

/**
 * @author matemaster
 */
public class ElasticSearchServer {

    private static final ElasticsearchClient esClient;

    public static void main(String[] args) {
        searchAPI();
    }

    @SneakyThrows
    static void searchAPI() {
        // SearchRequest: POST /kibana_sample_data_logs/_search?typed_keys=true {}
        SearchRequest searchRequest = SearchRequest.of(builder -> builder.index(ElasticsearchConst.kibana_sample_data_logs));

        SearchResponse<KibanaSampleDataLog> response = esClient.search(searchRequest, KibanaSampleDataLog.class);
        System.out.println(response.hits().hits().get(0).source());
    }




    static {
        RestClient restClient = RestClient
                .builder(new HttpHost("10.37.129.100", 9200, "https"))
                .setHttpClientConfigCallback(httpAsyncClientBuilder -> {
                    // 配置es 用户密码认证
                    final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                    credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "Z2BolO0x4lMBE4A6D3e+"));
                    httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);

                    // 配置es ssl访问
                    final SSLContext sslContext;
                    try {
                        // 信任所有
                        sslContext = SSLContexts.custom().loadTrustMaterial(null, (x509Certificates, s) -> true).build();
                    } catch (Exception e) {
                        return null;
                    }
                    httpAsyncClientBuilder.setSSLContext(sslContext);
                    return httpAsyncClientBuilder;
                })
                .build();
        RestClientTransport restClientTransport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        esClient = new ElasticsearchClient(restClientTransport);
    }
}
