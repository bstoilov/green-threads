package com.green.web;

import com.green.service.BlockService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockingController {
    private static final Logger LOGGER = LogManager.getLogger(BlockingController.class);

    private final BlockService blockService;

    BlockingController(BlockService blockService) {
        this.blockService = blockService;
    }

    @GetMapping("block/{millis}")
    public String block(
        @PathVariable(value = "millis") Long millis) throws InterruptedException, ExecutionException, TimeoutException {
        return blockService.block(millis).get(1000, TimeUnit.SECONDS);
    }
}
