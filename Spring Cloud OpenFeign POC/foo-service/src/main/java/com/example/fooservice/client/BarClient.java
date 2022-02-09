package com.example.fooservice.client;

import com.example.fooservice.client.config.BarClientConfig;
import com.example.fooservice.client.dto.BarDto;
import com.example.fooservice.client.query.BarQueryParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(value = "${bar-client.name}", url = "${bar-client.url}")
@FeignClient(value = "${bar-client.name}", url = "${bar-client.url}", configuration = BarClientConfig.class)
public interface BarClient {

    @GetMapping("bar/{id}")
    BarDto getBar(@RequestHeader HttpHeaders header,
                  @PathVariable("id") Long id,
                  @SpringQueryMap BarQueryParams barQueryParams);

    /*
    @RequestBody annotation can be omitted when the HTTP request body payload passed via the first method argument.
    Reference: https://nullbeans.com/how-to-configure-openfiegn-clients-to-perform-http-requests
    */
    @PostMapping("bar")
    public BarDto createBar(BarDto barDto);
}

