package com.example.fooservice.client;

import com.example.fooservice.client.dto.BarDto;
import com.example.fooservice.client.query.BarQueryParams;
import io.micrometer.core.annotation.Timed;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class BarClientProxy implements BarClient{

    private BarClient barClient;

    public BarClientProxy(BarClient barClient) {
        this.barClient = barClient;
    }

    @Override
    @Timed(value = "getBar.time", description = "Time taken to return bar")
    public BarDto getBar(HttpHeaders header, Long id, BarQueryParams barQueryParams) {
        return barClient.getBar(header, id, barQueryParams);
    }

    @Override
    @Timed(value = "createBar.time", description = "Time taken to create bar")
    public BarDto createBar(BarDto barDto) {
        return barClient.createBar(barDto);
    }
}
