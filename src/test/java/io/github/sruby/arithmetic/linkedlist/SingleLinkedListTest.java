package io.github.sruby.arithmetic.linkedlist;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.analysis.function.Sin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class SingleLinkedListTest {
    private SingleLinkedList singleLinkedList = new SingleLinkedList();
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        assertTrue(singleLinkedList.getIndex() == 4);
        log.debug("singleLinkedList:{}",singleLinkedList);

        singleLinkedList.remove(1);
        assertTrue(singleLinkedList.getIndex() == 3);
        log.debug("singleLinkedList:{}",singleLinkedList);

        singleLinkedList.remove(4);
        assertTrue(singleLinkedList.getIndex() == 2);
        log.debug("singleLinkedList:{}",singleLinkedList);
    }

    @Test
    public void remove() {
    }
}