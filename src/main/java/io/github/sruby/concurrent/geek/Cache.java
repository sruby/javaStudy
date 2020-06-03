package io.github.sruby.concurrent.geek;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: cache used ReadWriteLock
 * @author: sruby
 * @create: 2020-06-03 16:27
 */
@Slf4j
public class Cache {
    private static Map<String,String> cache = new HashMap<>();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final Lock writeLock = readWriteLock.writeLock();
    @SneakyThrows
    public void put(String key, String value){
        try {
            writeLock.lock();
            TimeUnit.SECONDS.sleep(1);
            cache.put(key,value);
            log.debug("put,key:{}",key);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(String key){
        Lock readLock = readWriteLock.readLock();
        String value;
        try {
            readLock.lock();
            value = cache.get(key);
            log.debug("get,key:{}",key);
        } finally {
            readLock.unlock();
        }
        return value;
    }
}
