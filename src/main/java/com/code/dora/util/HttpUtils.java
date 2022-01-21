package com.code.dora.util;

import com.code.dora.http.HttpClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
@Slf4j
public class HttpUtils {

    private static RestTemplate restTemplate = new RestTemplate();

    /**
     * restTemplate发送请求
     * @param header
     * @param url
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T get(Map<String, String> header, String url, Class<T> clazz) {
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, String> entry : header.entrySet()) {
            httpHeaders.add(entry.getKey(), entry.getValue());
        }
        HttpEntity httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<T> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, clazz);
        } catch (Exception ex) {
            log.warn("ex,", ex);
        }
        if (responseEntity != null) {
            return responseEntity.getBody();
        }
        return null;
    }

    /**
     * httpclient连接池发送请求
     * @param url
     * @param header
     * @return
     */
    public static String get(String url, Map<String, String> header) {
        CloseableHttpClient httpClient = HttpClientFactory.getHttpClient();
        HttpGet httpGet = new HttpGet(url);
        header.forEach(httpGet::addHeader);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            if (response.getEntity() != null) {
                return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            }
        } catch (IOException ex) {
            log.warn("exception,", ex);
        }
        return null;
    }




}
