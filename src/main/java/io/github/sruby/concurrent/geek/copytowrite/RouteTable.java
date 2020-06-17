package io.github.sruby.concurrent.geek.copytowrite;

import lombok.ToString;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description: Route table
 * @author: sruby
 * @create: 2020-06-17 16:59
 */
@ToString
public class RouteTable {
    private static Map<String, CopyOnWriteArraySet> concurrentHashMap = new ConcurrentHashMap<>();

    public Set<Route> get(String iface){
        return concurrentHashMap.computeIfAbsent(iface,r->new CopyOnWriteArraySet());
    }

    public void add(String iface,Route route){
        Set<Route> copyOnWriteArraySet = concurrentHashMap.computeIfAbsent(iface, r -> new CopyOnWriteArraySet());
        copyOnWriteArraySet.add(route);
    }


    public void remove(String iface,Route route){
        Set<Route> copyOnWriteArraySet = concurrentHashMap.computeIfAbsent(iface, r -> new CopyOnWriteArraySet());
        copyOnWriteArraySet.remove(route);
    }


}
