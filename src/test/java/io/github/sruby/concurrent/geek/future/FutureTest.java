package io.github.sruby.concurrent.geek.future;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description: Future test
 * @author: sruby
 * @create: 2020-06-16 11:00
 */
@Slf4j
public class FutureTest {
    @Test
    public void submit() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Result result = new Result("1");
        Future<Result> submit = executor.submit(new Task(result),result);
        Result s = submit.get();
        log.debug("S:{}",s);
        Assert.assertEquals("2",s.getName());
    }

    class Task implements  Runnable{
        private Result result;
        public Task(Result str){
            this.result = str;
        }

        @Override
        public void run() {
            result.setName("2");
            log.debug("result:{}",result);
        }
    }

    @Data
    @AllArgsConstructor
    class Result{
        private String name;
    }
}
