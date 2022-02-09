package com.example.barservice;

import org.springframework.stereotype.Service;

@Service
public class BlockingService {

    public BarDto getBar(Long id) {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException ign) {
        }
        return new BarDto(id, "bar message");
    }
}
