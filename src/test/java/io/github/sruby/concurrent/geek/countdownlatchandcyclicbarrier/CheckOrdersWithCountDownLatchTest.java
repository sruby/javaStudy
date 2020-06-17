package io.github.sruby.concurrent.geek.countdownlatchandcyclicbarrier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckOrdersWithCountDownLatchTest {
    private CheckOrdersWithCountDownLatch checkOrders = new CheckOrdersWithCountDownLatch();

    @Test
    void check() {
        checkOrders.check();
    }
}