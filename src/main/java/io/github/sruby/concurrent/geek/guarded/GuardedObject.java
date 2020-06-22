package io.github.sruby.concurrent.geek.guarded;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * GuardedObject
 *
 * @author sruby on 2020-6-22 22:57
 */
public class GuardedObject<T> {
    T obj;
    final ReentrantLock reentrantLock = new ReentrantLock();
    Condition doneCondition = reentrantLock.newCondition();
    final int timeout = 1;

    /**
     * get shared obj
     */
    T get(Predicate<T> p){
        reentrantLock.lock();
        try {
            while (!p.test(obj)){
                try {
                    doneCondition.await(timeout, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
        return obj;
    }

    /**
     * event notice
     * @param obj
     */
    void onChange(T obj){
        reentrantLock.lock();
        try {
            this.obj = obj;
            doneCondition.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }
}
