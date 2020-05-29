package io.github.sruby.concurrent.geek.BO;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: sruby
 * @create: 2020-05-29 11:05
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Account {
    private int balance;
    private String accountId;

    /**
     * 分配资源
     */
    static class Allocator{
        private static Allocator instance;
        private Allocator(){}
        public static Allocator getInstance(){
            if (null ==  instance){
                synchronized (Allocator.class){
                    if (null == instance){
                        instance = new Allocator();
                    }
                }
            }
            return instance;
        }

        private List<Account> als = new ArrayList<>();

        synchronized boolean apply(Account from ,Account target){
            if (als.contains(from) || als.contains(target)){
                return false;
            }else {
                als.add(from);
                als.add(target);
            }
            return true;
        }

        synchronized void free(Account from ,Account target){
            als.remove(from);
            als.remove(target);
        }
    }

    /**
     * lock class
     * @param target
     * @param amt
     */
    @SneakyThrows
    public void transportLockClass(Account target, int amt) {
        synchronized (Account.class){
            System.out.println("target start:"+target);
            this.balance = balance - amt;
            TimeUnit.SECONDS.sleep(1);
            target.setBalance(target.getBalance() + amt);
            System.out.println("target end:"+target);
        }
    }
    /**
     * dead lock
     * @param target
     * @param amt
     */
    @SneakyThrows
    public void transportDeadLock(Account target, int amt) {
        //lock out account
        synchronized (this){
            log.debug("sleep before,this:{},target:{}",this,target);
            TimeUnit.SECONDS.sleep(1);
            log.debug("sleep after,this:{},target:{}",this,target);
            //lock in account
            synchronized (target){
                log.debug("target start:"+target);
                this.balance = balance - amt;
                target.setBalance(target.getBalance() + amt);
                log.debug("target end:"+target);
            }
        }
    }

    /**
     * 解决死锁方式一：一次性申请所有的资源，而不是分开申请
     * dead lock
     * @param target
     * @param amt
     */
    @SneakyThrows
    public void transportOnceLock(Account target, int amt) {
        //lock out account
        synchronized (this.toString()+target.toString()){
            TimeUnit.SECONDS.sleep(3);
            log.debug("sleep after,this:{},target:{}",this,target);
            //lock in account
            System.out.println("target start:"+target);
            this.balance = balance - amt;
            TimeUnit.SECONDS.sleep(1);
            target.setBalance(target.getBalance() + amt);
            System.out.println("target end:"+target);
        }
    }
    /**
     * 解决死锁方式一：一次性申请所有的资源，而不是分开申请
     * 使用Allocator做资源分配
     *
     * @param target
     * @param amt
     */
    @SneakyThrows
    public void transportOnceLock2(Account target, int amt) {
        try {
            while (Allocator.getInstance().apply(this, target)){
                //lock out account
                synchronized (this){
                    log.debug("sleep before,this:{},target:{}",this,target);
                    TimeUnit.SECONDS.sleep(1);
                    log.debug("sleep after,this:{},target:{}",this,target);
                    //lock in account
                    synchronized (target){
                        log.debug("target start:"+target);
                        this.balance = balance - amt;
                        target.setBalance(target.getBalance() + amt);
                        log.debug("target end:"+target);
                    }
                }
            }
        } finally {
            Allocator.getInstance().free(this,target);
        }
    }

    /**
     * 解决死锁方式二：破坏不可抢占条件
     *
     *
     * @param target
     * @param amt
     */
    @SneakyThrows
    public void transportBreakCondition(Account target, int amt) {

    }
    /**
     * 解决死锁方式三：破坏循环等待条件
     * 对资源进行排序
     *
     * @param target
     * @param amt
     */
    @SneakyThrows
    public void transportBreakWaitCondition(Account target, int amt) {
        Account small = new Account();
        Account large = new Account();

        if (this.accountId.compareTo(target.accountId) > 0 ){
            large = this;
            small = target;
        }else {
            large = target;
            small = this;
        }

        //lock out account
        synchronized (small){
            log.debug("sleep before,this:{},target:{}",this,target);
            TimeUnit.SECONDS.sleep(1);
            log.debug("sleep after,this:{},target:{}",this,target);
            //lock in account
            synchronized (large){
                log.debug("target start:"+target);
                this.balance = balance - amt;
                target.setBalance(target.getBalance() + amt);
                log.debug("target end:"+target);
            }
        }
    }
}
