package io.github.sruby.concurrent.geek.countdownlatchandcyclicbarrier;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: check order
 * thread wait by join
 * @author: sruby
 * @create: 2020-06-08 16:11
 */
@Slf4j
public class CheckOrders {
    List<Integer> pedingOrders = new ArrayList<>();
    List<Integer> deliveringOrders = new ArrayList<>();
    @SneakyThrows
    public void check(){

//        while(isUnCheckOrder()){
            Thread pedingThread = new Thread(() -> pedingOrders = getPedingOrders());
            pedingThread.start();
            Thread deliveringThread = new Thread(() -> deliveringOrders = getDeliveringOrders());
            deliveringThread.start();

            pedingThread.join();
            deliveringThread.join();

            List<Integer> diffOrders = checkOrder(pedingOrders,deliveringOrders);
            save(diffOrders);
//        }
    }

    private void save(List<Integer> diffOrders) {
        log.debug("save order，diffOrders：{}",diffOrders);
    }

    private List<Integer> checkOrder(List<Integer> pedingOrders, List<Integer> deliveringOrders) {
        log.debug("check order diff");
        List<Integer> diffOrders = Arrays.asList(1);
        return diffOrders;
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
