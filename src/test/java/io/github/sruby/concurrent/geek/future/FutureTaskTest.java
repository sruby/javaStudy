package io.github.sruby.concurrent.geek.future;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @description: FutureTask test
 * @author: sruby
 * @create: 2020-06-16 14:42
 */
@Slf4j
public class FutureTaskTest {
    @SneakyThrows
    @Test
    public void test(){
        FutureTask<Integer> futureTask = new FutureTask(() -> {
            log.debug("futuretask test");
            return 2;
        });

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(futureTask);
        log.debug("result:{}",futureTask.get());
    }
}
