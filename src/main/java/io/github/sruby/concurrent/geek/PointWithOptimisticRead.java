package io.github.sruby.concurrent.geek;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @description: StampedLock OptimisticRead demo
 * @author: sruby
 * @create: 2020-06-03 17:29
 */
@Slf4j
public class PointWithOptimisticRead {
    private int x;
    private int y;
    private final StampedLock stampedLock = new StampedLock();
    @SneakyThrows
    public double distanceFromOrigin(){
        long stamp = stampedLock.tryOptimisticRead();
        int curX = x;
        int curY = y;
        //check whether write when reading
        TimeUnit.SECONDS.sleep(1);
        if (!stampedLock.validate(stamp)){
            log.debug("validate");
            //upgraded non-Optimistic read
            stamp = stampedLock.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return Math.sqrt(curX * curX + curY * curY);
    }

    public void setX(int x,int y){
        long stamp = stampedLock.writeLock();
        try {
            this.x = x;
            this.y = y;
        } finally {
            stampedLock.unlock(stamp);
        }
    }
}
