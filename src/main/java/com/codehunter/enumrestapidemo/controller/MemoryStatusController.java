package com.codehunter.enumrestapidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryStatusController {

    @GetMapping("memory-status")
    public MemoryStats getMemoryStatistics() {
        return new MemoryStats(Runtime.getRuntime().totalMemory(),
                Runtime.getRuntime().maxMemory(),
                Runtime.getRuntime().freeMemory()
        );
    }
}

record MemoryStats(Long heapSize, Long heapMaxSize, Long heapFreeSize) {
}
