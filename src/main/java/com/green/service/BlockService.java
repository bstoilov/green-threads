package com.green.service;

import java.util.concurrent.CompletableFuture;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BlockService {
    private static final Logger LOGGER = LogManager.getLogger(BlockService.class);

    @Async
    public CompletableFuture<String> block(Long millis) {
        LOGGER.info("Blocking for {} millis", millis);
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            LOGGER.error(e);
        }

        return CompletableFuture.completedFuture("Done");
    }
}
