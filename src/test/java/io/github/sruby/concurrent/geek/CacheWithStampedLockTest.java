package io.github.sruby.concurrent.geek;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class CacheWithStampedLockTest {

    private CacheWithStampedLock cache = new CacheWithStampedLock();

    @SneakyThrows
    @Test
    void put() {
        new Thread(()->cache.put("key1","value1")).start();
        new Thread(()->cache.put("key2","value2")).start();

        log.debug("get before");
        String key2 = cache.get("key2");
        String key1 = cache.get("key1");
        log.debug("key1:{},key2:{}",key1,key2);
    }

    @Test
    void get() {
    }
}