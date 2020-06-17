package io.github.sruby.concurrent.geek.future;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @description: test
 * @author: sruby
 * @create: 2020-06-16 14:53
 */
@Slf4j
public class MultiThreadTaskWithFutureTask {

    class TaskOne implements Callable {
        private FutureTask<String> futureTask;
        public TaskOne(FutureTask<String> futureTask){
            this.futureTask =  futureTask;
        }

        @Override
        public String call() throws Exception {
            log.debug("boil water");
            String taskTwoResult = futureTask.get();
            log.debug("taskTwoResult:{}",taskTwoResult);
            return "tea";
        }
    }

    class TaskTwo implements Callable{
        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(5);
            log.debug("tea leaf ready！");
            return "tea leaf";
        }
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTaskTwo = new FutureTask<>(new TaskTwo());
        FutureTask<String> futureTaskOne = new FutureTask<>(new TaskOne(futureTaskTwo));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(futureTaskOne);
        executorService.submit(futureTaskTwo);

        String oneResult = futureTaskOne.get();
        log.debug("oneResult:{}",oneResult);
    }
}
