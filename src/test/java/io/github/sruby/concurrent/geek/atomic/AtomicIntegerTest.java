package io.github.sruby.concurrent.geek.atomic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:Atomic test
 * @author: sruby
 * @create: 2020-06-12 17:18
 */
@Slf4j
public class AtomicIntegerTest {
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    @Test
    public void getAndIncrement() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                atomicInteger.getAndIncrement();
                log.debug("atomicInteger inner:{}",atomicInteger);
            }).start();
            TimeUnit.MILLISECONDS.sleep(10);
        }
        TimeUnit.SECONDS.sleep(3);
        log.debug("atomicInteger:{}",atomicInteger);
    }
    @Test
    public void addAndGet() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                atomicInteger.addAndGet(2);
                log.debug("atomicInteger inner:{}",atomicInteger);
            }).start();
//            TimeUnit.MILLISECONDS.sleep(10);
        }
        TimeUnit.SECONDS.sleep(3);
        log.debug("atomicInteger:{}",atomicInteger);
    }
}
