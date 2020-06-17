package io.github.sruby.concurrent.geek.completablefuture;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: CompletableFuture test
 * @author: sruby
 * @create: 2020-06-16 17:03
 */
@Slf4j
public class CompletableFutureTest {
    @Test
    public void test(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(()->{
            log.debug("boil water");
            sleep();
        }, executor);

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
           log.debug("tea leaf ready");
            sleep();
            return "tea leaf";
        }, executor);

        CompletableFuture<String> f3 = f1.thenCombine(f2, (aVoid, s) -> {
            log.debug("tea ready,s:{}",s);
            return "tea";
        });

        String join = f3.join();
        log.debug("join:{}",join);
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
