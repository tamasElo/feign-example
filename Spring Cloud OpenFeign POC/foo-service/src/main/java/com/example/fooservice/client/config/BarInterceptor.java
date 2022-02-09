package com.example.fooservice.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class BarInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("user", "Bela");
        requestTemplate.header("password", "11AsTeRiSkS");
    }
}
