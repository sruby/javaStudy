package io.github.sruby.concurrent.geek.copytowrite;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class RouteTableTest {
    private RouteTable routeTable = new RouteTable();
    private String iface;
    private Route routeGet;

    @BeforeEach
    void setUp() {
        iface = "/get";
        routeGet = Route.builder().ip("127.0.0.1").port(80).statue("ok").build();
        routeTable.add(iface, routeGet);
        routeTable.add("/update",Route.builder().ip("127.0.0.1").port(81).statue("ok").build());
    }

    @Test
    void get() {
        Set<Route> routes = routeTable.get(iface);
        log.debug("routes:{}",routes);
    }

    @Test
    void add() {
    }

    //TODO delete all?
    @Test
    void remove() {
        log.debug("routeTable:{}",routeTable);
        routeTable.remove(iface,routeGet);
        log.debug("routeTable:{}",routeTable);
    }
}