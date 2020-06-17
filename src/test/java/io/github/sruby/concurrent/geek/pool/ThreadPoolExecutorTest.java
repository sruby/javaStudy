package io.github.sruby.concurrent.geek.pool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @description: thread pool test
 * @author: sruby
 * @create: 2020-06-15 11:15
 * https://www.baeldung.com/java-rejectedexecutionhandler
 */
@Slf4j
public class ThreadPoolExecutorTest {
    ReentrantLock lock = new ReentrantLock();

    public class WorkerThreadFactory implements ThreadFactory {
        //upper limit < ThreadPoolExecutor.maximumPoolSize,
        private int counter = 0;
        private String prefix = "";

        public WorkerThreadFactory(String prefix) {
            this.prefix = prefix;
        }

        public Thread newThread(Runnable r) {
            return new Thread(r, prefix + "-" + counter++);
        }
    }

    @SneakyThrows
    @Test
    public void testWorkerThreadFactory(){
        ThreadFactory threadFactory = new WorkerThreadFactory("test");

        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                log.debug("rejected");
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 10, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), threadFactory, rejectedExecutionHandler);

        threadPoolExecutor.execute(()->{
            log.debug("1"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("2"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("6"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("3"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("4"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("5"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        TimeUnit.SECONDS.sleep(10);
    }

    @SneakyThrows
    @Test
    public void testRejectedExecutionHandler(){
        ThreadFactory threadFactory = new WorkerThreadFactory("test");

        RejectedExecutionHandler rejectedExecutionHandler = (r, executor) -> log.debug("rejected");

        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 0,
                TimeUnit.SECONDS, workQueue, threadFactory, rejectedExecutionHandler);

        threadPoolExecutor.execute(()->{
            log.debug("1"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("2"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("6"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("3"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("4"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("5"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        TimeUnit.SECONDS.sleep(10);
    }

    @SneakyThrows
    @Test
    public void testCustomRejectedExecutionHandler(){
        ThreadFactory threadFactory = new WorkerThreadFactory("test");

        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 0,
                TimeUnit.SECONDS, workQueue, threadFactory, new GrowPolicy());

        threadPoolExecutor.execute(()->{
            log.debug("1"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPoolExecutor.execute(()->{
            log.debug("2"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPoolExecutor.execute(()->{
            log.debug("6"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("3"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("4"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.execute(()->{
            log.debug("5"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void abortPolicy(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, MILLISECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.AbortPolicy());

        executor.execute(() -> waitFor(250));

        Assertions.assertThrows(RejectedExecutionException.class,() -> executor.execute(() -> log.debug("Will be rejected")));
    }

    @Test
    public void callerRunsPolicy(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, MILLISECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        executor.execute(() -> waitFor(250));

        long startTime = System.currentTimeMillis();
        executor.execute(() -> waitFor(500));
        long blockedDuration = System.currentTimeMillis() - startTime;
    }

    @SneakyThrows
    private void waitFor(int i) {
        MILLISECONDS.sleep(250);
    }

    /**
     * increment the max pool size by one and then re-submit the same task
     */
    class GrowPolicy implements RejectedExecutionHandler {

        private final Lock lock = new ReentrantLock();

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            lock.lock();
            try {
                executor.setMaximumPoolSize(executor.getMaximumPoolSize() + 1);
            } finally {
                lock.unlock();
            }

            executor.submit(r);
        }
    }
}
