package io.github.sruby.concurrent.geek;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @description: cache used ReadWriteLock
 * @author: sruby
 * @create: 2020-06-03 16:27
 */
@Slf4j
public class CacheWithStampedLock {
    private static Map<String,String> cache = new HashMap<>();
    private final StampedLock stampedLock = new StampedLock();
    @SneakyThrows
    public void put(String key, String value){
        long stamp = stampedLock.writeLock();
        try {
            TimeUnit.SECONDS.sleep(1);
            cache.put(key,value);
            log.debug("put,key:{}",key);
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public String get(String key){
        long stamp = stampedLock.readLock();
        String value;
        try {
            value = cache.get(key);
            log.debug("get,key:{}",key);
        } finally {
            stampedLock.unlockRead(stamp);
        }
        return value;
    }
}
