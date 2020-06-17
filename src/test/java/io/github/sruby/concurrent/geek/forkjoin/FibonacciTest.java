package io.github.sruby.concurrent.geek.forkjoin;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

@Slf4j
class FibonacciTest {

    @Test
    void test() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        Fibonacci fibonacci = new Fibonacci(30);
        Integer invoke = forkJoinPool.invoke(fibonacci);
        Assert.assertTrue(832040==invoke);
        log.debug("result:{}",invoke);
    }
}