package com.example.fooservice.controller;

import com.example.fooservice.client.BarClient;
import com.example.fooservice.client.BarClientProxy;
import com.example.fooservice.client.dto.BarDto;
import com.example.fooservice.client.query.BarQueryParams;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@RestController
public class FooController {
    private BarClientProxy barClient;

    public FooController(BarClientProxy barClient) {
        this.barClient = barClient;
    }

    @GetMapping("random-bar")
    public BarDto getBar() {
        return barClient.getBar(createHttpHeaders(), createId(), createQueryParams());
    }

    private BarQueryParams createQueryParams() {
        return new BarQueryParams(4, "four");
    }

    private long createId() {
        Random random = new Random();
        return random.nextInt(10 - 1) + 1;
    }

    private Map<String, String> createHeaderMap() {
        return Map.of("version", "1",
                "client-name", "foo service");
    }

    private HttpHeaders createHttpHeaders() {
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("version", "1");
        httpHeaders.add("client-name", "foo service");
        return httpHeaders;
    }

    @PostMapping("bar")
    @ResponseStatus(HttpStatus.CREATED)
    public BarDto createBar(@RequestBody BarDto barDto) {
       return barClient.createBar(barDto);
    }
}
