package io.github.sruby.concurrent.geek.completionservice;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description: CompletionService test
 * @author: sruby
 * @create: 2020-06-16 18:01
 */
@Slf4j
public class CompletionServiceTest {
    @Test
    public void test() throws InterruptedException, ExecutionException {
        Executor executor = Executors.newFixedThreadPool(3);
        CompletionService<String> completionService = new ExecutorCompletionService(executor);
        List<Future<String>> futureList = new ArrayList<>(3);
        Future<String> query1 = completionService.submit(() -> {
            log.debug("query1");
            return "query1";
        });

        Future<String> query2 = completionService.submit(() -> {
            log.debug("query2");
            return "query2";
        });
        Future<String> query3 = completionService.submit(() -> {
            log.debug("query3");
            return "query3";
        });
        futureList.add(query1);
        futureList.add(query2);
        futureList.add(query3);

        try {
            for (int i = 0; i < 3; i++){
                String result = completionService.take().get();
                log.debug("result:{}",result);
                if (StringUtils.isNotBlank(result)){
                    break;
                }
            }
        } finally {
            for (Future future:futureList){
                future.cancel(true);
            }
        }
    }
}
