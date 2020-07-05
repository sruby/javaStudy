package io.github.sruby.arithmetic.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test
 *
 * @author sruby on 2020-7-5 18:00
 */
class MyLinkedListTest {
    MyLinkedList myLinkedList;

    @BeforeEach
    void setUp() {
        myLinkedList = new MyLinkedList();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test(){
        myLinkedList.get(0);
    }

    @Test
    void get() {
    }

    @Test
    void addAtHead() {
    }

    @Test
    void addAtTail() {
    }

    @Test
    void addAtIndex() {
    }

    @Test
    void deleteAtIndex() {
    }
}