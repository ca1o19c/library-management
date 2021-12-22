package com.academy.librarymanagement.config;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class HttpAndRestTemplateConfig {

    public static String getUri(String endpoint) {
        return UriComponentsBuilder
                .fromUriString(endpoint)
                .build()
                .encode()
                .toUriString();
    }

    public static String getUriWithPathParams(String endpoint, Map<String, String> requestPathParam) {
        return UriComponentsBuilder
                .fromUriString(endpoint)
                .buildAndExpand(requestPathParam)
                .encode()
                .toUriString();
    }

    public static String getUriWithQuery(String endpoint, Map<String, ?> queryParams) {
        var uri = UriComponentsBuilder.fromUriString(endpoint);

        queryParams.forEach(uri::queryParam);

        return uri.build().encode().toString();
    }

    public static HttpEntity<?> getHttpEntity() {
        var headers = getHttpHeaders();
        return new HttpEntity<>(headers);
    }

    public static HttpEntity<?> getHttpEntity(Object payload) {
        var headers = getHttpHeaders();
        return new HttpEntity<>(payload, headers);
    }

    private static HttpHeaders getHttpHeaders() {
        var headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        return headers;
    }
}
