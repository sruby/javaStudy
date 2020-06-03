package io.github.sruby.concurrent.geek;

import io.github.sruby.concurrent.geek.BO.Account;
import io.github.sruby.concurrent.geek.BO.AccountWithWait;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: sruby
 * @create: 2020-05-29 11:05
 **/
public class DeadLockDemo {

    @SneakyThrows
    @Test
    public void transportLockClass(){
        Account accountA = new Account(200,"A");
        Account accountB = new Account(200,"B");
        Account accountC = new Account(200,"C");
        Thread threadA = new Thread(() -> {
            accountA.transportLockClass(accountB, 100);
        });
        Thread threadB = new Thread(() -> {
            accountB.transportLockClass(accountC, 100);
        });

        threadA.start();
        threadB.start();

        TimeUnit.SECONDS.sleep(6);
        System.out.println(accountA);
        System.out.println(accountB);
        System.out.println(accountC);
    }

    @SneakyThrows
    @Test
    public void transportDeadLock(){
        Account accountA = new Account(200,"A");
        Account accountB = new Account(200,"B");
        Thread threadA = new Thread(() -> {
            accountA.transportDeadLock(accountB, 100);
        });
        Thread threadB = new Thread(() -> {
            accountB.transportDeadLock(accountA, 200);
        });

        threadA.start();
        threadB.start();

        TimeUnit.SECONDS.sleep(6);
        System.out.println(accountA);
        System.out.println(accountB);
    }

    @SneakyThrows
    @Test
    public void transportOnceLock(){
        Account accountA = new Account(200,"A");
        Account accountB = new Account(200,"B");
        Thread threadA = new Thread(() -> {
            accountA.transportOnceLock(accountB, 100);
        });
        Thread threadB = new Thread(() -> {
            accountB.transportOnceLock(accountA, 200);
        });

        threadA.start();
        threadB.start();

        TimeUnit.SECONDS.sleep(6);
        System.out.println(accountA);
        System.out.println(accountB);
    }
    @SneakyThrows
    @Test
    public void transportOnceLock2(){
        Account accountA = new Account(200,"A");
        Account accountB = new Account(200,"B");
        Thread threadA = new Thread(() -> {
            accountA.transportOnceLock2(accountB, 100);
        });
        Thread threadB = new Thread(() -> {
            accountB.transportOnceLock2(accountA, 200);
        });

        threadA.start();
        threadB.start();

        TimeUnit.SECONDS.sleep(6);
        System.out.println(accountA);
        System.out.println(accountB);
    }

    @SneakyThrows
    @Test
    public void transportOnceLock2WithWait(){
        AccountWithWait accountA = new AccountWithWait(200,"A");
        AccountWithWait accountB = new AccountWithWait(200,"B");
        Thread threadA = new Thread(() -> {
            accountA.transportOnceLock2(accountB, 100);
        });
        Thread threadB = new Thread(() -> {
            accountB.transportOnceLock2(accountA, 200);
        });

        threadA.start();
        threadB.start();

        TimeUnit.SECONDS.sleep(6);
        System.out.println(accountA);
        System.out.println(accountB);

        Assert.assertEquals(accountA.getBalance(),300);
        Assert.assertEquals(accountB.getBalance(),100);
    }

    @SneakyThrows
    @Test
    public void transportBreakWaitCondition(){
        Account accountA = new Account(200,"A");
        Account accountB = new Account(200,"B");
        Thread threadA = new Thread(() -> {
            accountA.transportBreakWaitCondition(accountB, 100);
        });
        Thread threadB = new Thread(() -> {
            accountB.transportBreakWaitCondition(accountA, 200);
        });

        threadA.start();
        threadB.start();

        TimeUnit.SECONDS.sleep(6);
        System.out.println(accountA);
        System.out.println(accountB);
    }
}
