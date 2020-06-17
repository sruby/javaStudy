package io.github.sruby.concurrent.geek.bo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * test
 *
 * @author sruby on
 */
@Slf4j
class BlockedQueueTest {
    private BlockedQueue blockedQueue = new BlockedQueue();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @SneakyThrows
    @Test
    void enq() {
        new Thread(()->{
            for (int i = 0; i < 12; i++){
                blockedQueue.enq(String.valueOf(i));
                log.debug("blockedQueue size:{}",blockedQueue.getQueue().size());
                log.debug("blockedQueue:{}",blockedQueue);
            }
        }).start();

        TimeUnit.SECONDS.sleep(3);

        new Thread(() -> {
            blockedQueue.dep();
            log.debug(" dep blockedQueue size:{}",blockedQueue.getQueue().size());
            log.debug("dep blockedQueue:{}",blockedQueue);
        }).start();

    }

    @Test
    void dep() {
        blockedQueue.dep();
    }

    @Test
    public void test(){

    }
}