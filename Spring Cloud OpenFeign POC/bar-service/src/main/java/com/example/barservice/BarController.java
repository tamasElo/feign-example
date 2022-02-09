package com.example.barservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BarController {

    private final BlockingService blockingService;
    Logger log = LoggerFactory.getLogger(BarController.class);

    @Autowired
    public BarController(BlockingService blockingService) {
        this.blockingService = blockingService;
    }

    @GetMapping("bar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BarDto getBar(@RequestHeader Map<String, String> header,
                         @PathVariable("id") Long id,
                         @RequestParam Integer first,
                         @RequestParam String second,
                         @RequestParam(required = false) Integer third) {
        log.info("header values: " + header);
        log.info("request parameters: " + "first: " + first + " second: " + second + " third: " + third);
        return blockingService.getBar(id);
    }

    @PostMapping("bar")
    @ResponseStatus(HttpStatus.CREATED)
    public BarDto createBar(@RequestBody BarDto barDto) {
        log.info("request body: " + barDto);
        return barDto;
    }
}
