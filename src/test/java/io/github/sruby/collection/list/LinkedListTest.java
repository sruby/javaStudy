package io.github.sruby.collection.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

@Slf4j
public class LinkedListTest {
    @Test
    void test() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("a");
        linkedList.add("a");
        log.debug("linkedList:{}",linkedList);
    }
}
