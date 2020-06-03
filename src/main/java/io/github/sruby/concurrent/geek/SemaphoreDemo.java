package io.github.sruby.concurrent.geek;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description: Semaphore demo
 * @author: sruby
 * @create: 2020-06-03 15:30
 */
@Slf4j
@Data
@RequiredArgsConstructor
public class SemaphoreDemo {
    private final Semaphore semaphore = new Semaphore(1);
    @NonNull
    private CountDownLatch countDownLatch;
    int sum = 0;
    public void add(int i){
        try {
            semaphore.acquire();
            sum += i;
            TimeUnit.SECONDS.sleep(2);
            log.debug("sum:{}",sum);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
