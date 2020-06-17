package io.github.sruby.concurrent.geek.countdownlatchandcyclicbarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @description: check order
 * thread wait by Cyclicbarrier
 * @author: sruby
 * @create: 2020-06-08 16:11
 */
@Slf4j
public class CheckOrdersWithCyclicbarrier {
    List<Integer> pedingOrders = new ArrayList<>();
    List<Integer> deliveringOrders = new ArrayList<>();
    private Vector<Integer> pendingOrdersV = new Vector<>();
    private Vector<Integer> deliveringOrdersV = new Vector<>();
    Executor executor = new ThreadPoolExecutor(2,4,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2));
    Executor executorCyclicBarrier = new ThreadPoolExecutor(1,2,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2));
    final CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()->{
        executorCyclicBarrier.execute(this::check);
    });

    public void check(){
        Integer remove = pendingOrdersV.remove(0);
        Integer remove1 = deliveringOrdersV.remove(0);
        Integer diffOrders = checkOrder(remove,remove1);
        save(diffOrders);
    }

    public void checkAll(){
        executor.execute(()->{
            pedingOrders = getPedingOrders();
            pendingOrdersV.addAll(pedingOrders);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executor.execute(()->{
            deliveringOrders = getDeliveringOrders();
            deliveringOrdersV.addAll(deliveringOrders);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
    }

    private void save(Integer diffOrder) {
        log.debug("save order，diffOrder：{}",diffOrder);
    }

    private Integer checkOrder(Integer pedingOrder, Integer deliveringOrder) {
        log.debug("check order diff");
        return 1;
    }

    private List<Integer> getDeliveringOrders() {
        log.debug("check getDeliveringOrders");
        List<Integer> pedingOrders = Arrays.asList(1,2);
        return pedingOrders;
    }

    private List<Integer> getPedingOrders() {
        log.debug("check getPedingOrders");
        List<Integer> pedingOrders = Arrays.asList(1,2);
        return pedingOrders;
    }

    private boolean isUnCheckOrder() {
        return true;
    }
}
