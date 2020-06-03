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
public class AccountWithWait {
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

        private List<AccountWithWait> als = new ArrayList<>();

        @SneakyThrows
        synchronized void apply(AccountWithWait from , AccountWithWait target){
            while (als.contains(from) || als.contains(target)){
                this.wait();
            }

            als.add(from);
            als.add(target);
        }

        synchronized void free(AccountWithWait from , AccountWithWait target){
            als.remove(from);
            als.remove(target);
            this.notifyAll();
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
    public void transportOnceLock2(AccountWithWait target, int amt) {
        Allocator.getInstance().apply(this, target);
        try {
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
        } finally {
            Allocator.getInstance().free(this,target);
        }
    }

}
