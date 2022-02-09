package com.example.fooservice.client.config;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class BarClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            requestTemplate.header("user", "Bela");
//            requestTemplate.header("password", "11AsTeRiSkS");
//        };
//    }


//    @Bean
//    public ApacheHttpClient client() {
//        return new ApacheHttpClient();
//    }
}
