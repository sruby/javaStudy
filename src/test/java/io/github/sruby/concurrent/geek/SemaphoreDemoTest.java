package io.github.sruby.concurrent.geek;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class SemaphoreDemoTest {
    private CountDownLatch countDownLatch = new CountDownLatch(2);
    private SemaphoreDemo semaphoreDemo = new SemaphoreDemo(countDownLatch);

    public static void main(String[] args) {

    }

    @SneakyThrows
    @Test
    void add() {
        new Thread(()->{
            semaphoreDemo.add(2);
        }).start();


        new Thread(()->{
            semaphoreDemo.add(3);
        }).start();

        TimeUnit.SECONDS.sleep(6);

    }
}