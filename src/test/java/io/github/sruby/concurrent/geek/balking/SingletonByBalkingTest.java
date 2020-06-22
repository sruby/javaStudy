package io.github.sruby.concurrent.geek.balking;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SingletonByBalking
 *
 * @author sruby on 2020-6-22 23:14
 */
class SingletonByBalkingTest {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    private SingletonByBalking instance;
    private SingletonByBalking instance2;
    private SingletonByBalking instance3;

    @Test
    void getInstance() {
        executor.submit(()-> {
            instance = SingletonByBalking.getInstance();
            return instance;
        });
        executor.submit(()-> {
            instance2 = SingletonByBalking.getInstance();
            return instance2;
        });
        executor.submit(()-> {
            instance3 = SingletonByBalking.getInstance();
            return instance3;
        });

        Assert.assertSame(instance,instance2);
        Assert.assertSame(instance3,instance2);
    }
}