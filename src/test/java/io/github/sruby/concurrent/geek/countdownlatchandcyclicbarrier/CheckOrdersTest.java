package io.github.sruby.concurrent.geek.countdownlatchandcyclicbarrier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckOrdersTest {
    private CheckOrders checkOrders = new CheckOrders();

    @Test
    void check() {
        checkOrders.check();
    }
}