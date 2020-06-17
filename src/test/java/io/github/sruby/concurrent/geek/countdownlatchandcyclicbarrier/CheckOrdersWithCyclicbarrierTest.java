package io.github.sruby.concurrent.geek.countdownlatchandcyclicbarrier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckOrdersWithCyclicbarrierTest {
    private CheckOrdersWithCyclicbarrier checkOrdersWithCyclicbarrier = new CheckOrdersWithCyclicbarrier();
    @Test
    void checkAll() {
        checkOrdersWithCyclicbarrier.checkAll();
    }
}