package com.mjacobs;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        final CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(
                RequestConfig.custom().setConnectionRequestTimeout(100).setSocketTimeout(1000).build()).build();

        final HttpGet httpReq = new HttpGet("http://httpstat.us/200");

        try (final CloseableHttpResponse httpResp = httpClient.execute(httpReq)) {
            System.out.println("HTTP RESPONSE : " + httpResp);
            System.out.println("HTTP RESP BODY : " + httpResp.getEntity().toString());

        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
}
