package io.github.sruby.concurrent.geek.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description: ArrayBlockingQueue test
 * @author: sruby
 * @create: 2020-06-09 16:30
 */
@Slf4j
public class ArrayBlockingQueueTest {
    private ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2);


    @Test
    public void add(){
        for (int i = 0; i < 10; i++){
            arrayBlockingQueue.add(i);
        }
    }
    @Test
    public void put() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            arrayBlockingQueue.put(i);
            log.debug("arrayBlockingQueue:{}",arrayBlockingQueue);
        }
    }
    @Test
    public void offer() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            arrayBlockingQueue.offer(i,2, TimeUnit.SECONDS);
            log.debug("arrayBlockingQueue:{}",arrayBlockingQueue);
        }
    }

    @Test
    public void offer2() {
        for (int i = 0; i < 10; i++){
            arrayBlockingQueue.offer(i);
            log.debug("arrayBlockingQueue:{}",arrayBlockingQueue);
        }
    }
}
