package io.github.sruby.concurrent.geek;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PointWithOptimisticReadTest {
    private PointWithOptimisticRead pointWithOptimisticRead = new PointWithOptimisticRead();

    @SneakyThrows
    @Test
    void distanceFromOrigin() {
        new Thread(()->{
            pointWithOptimisticRead.setX(2,3);
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            double distanceFromOrigin = pointWithOptimisticRead.distanceFromOrigin();
            log.debug("distanceFromOrigin:{}",distanceFromOrigin);
        }).start();

        new Thread(()->{
            pointWithOptimisticRead.setX(5,3);
        }).start();

        TimeUnit.SECONDS.sleep(10);

    }

    @Test
    void setX() {
    }
}