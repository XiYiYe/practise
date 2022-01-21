package com.code.dora.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.cloud.netflix.ribbon.apache.HttpClientUtils;

@Slf4j
public class HttpClientFactory {
    /**
     * 连接时间
     */
    private static final int CONNECT_TIMEOUT = 8000;
    /**
     * socket连接时间
     */
    private static final int SOCKET_TIMEOUT = 10000;
    /**
     * 最大连接数
     */
    private static final int MAX_CONN = 20;
    /**
     * 路由最大连接数
     */
    private static final int MAX_PER_ROUTE = 20;

    private static final int MAX_ROUTE = 200;

    private static CloseableHttpClient httpClient;

    private static final PoolingHttpClientConnectionManager MANAGER;

    private static final RequestConfig REQUEST_CONFIG;

    static {
        MANAGER = new PoolingHttpClientConnectionManager();
        MANAGER.setMaxTotal(MAX_CONN);
        MANAGER.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        REQUEST_CONFIG = RequestConfig.custom().setConnectionRequestTimeout(CONNECT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT).build();
    }

    /**
     * 获取httpClient连接
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (HttpClientUtils.class) {
                if (httpClient == null) {
                    httpClient = HttpClients.custom().setConnectionManager(MANAGER).setDefaultRequestConfig(REQUEST_CONFIG).build();
                }
            }
        }
        return httpClient;
    }



}
