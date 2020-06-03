package io.github.sruby.concurrent.geek.BO;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: demo for lock & condition
 * @author: sruby
 * @create: 2020-06-02 15:57
 */
@Data
public class BlockedQueue {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFullCondition = lock.newCondition();
    private final Condition notBlankCondition = lock.newCondition();

    private Queue queue= new ArrayDeque();

    /**
     * in
     * @param x
     */
    @SneakyThrows
    public void enq(String x){
        lock.lock();
        try {
            while (queue.size() > 10){
                notFullCondition.await();
            }
            queue.add(x);
            notBlankCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    /**
     * out
     */
    @SneakyThrows
    public void dep(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                notBlankCondition.await();
            }
            queue.poll();
            notFullCondition.signal();
        }finally {
            lock.unlock();
        }
    }
}
