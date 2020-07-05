package io.github.sruby.arithmetic.linkedlist;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    /**
     * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
     * [[],[1],[3],[1,2],[1],[1],[1]]
     */
    @Test
    public void test(){
        myLinkedList.addAtHead(1);
        Assert.assertTrue(myLinkedList.get(0) == 1);
        myLinkedList.addAtTail(3);
        Assert.assertTrue(myLinkedList.get(1) == 3);
        myLinkedList.addAtIndex(1,2);
        Assert.assertTrue(myLinkedList.get(1) == 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        Assert.assertTrue(myLinkedList.get(1) == 3);
        System.out.println(myLinkedList);
    }

    /**
     * ["MyLinkedList","addAtHead","deleteAtIndex"]
     * [[],[1],[0]]
     */
    @Test
    public void test2(){
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        Assert.assertTrue(myLinkedList.get(1) == 1);
        myLinkedList.deleteAtIndex(1);
        Assert.assertTrue(myLinkedList.get(1) == -1);
    }

    /**
     * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
     * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
     */
    @Test
    public void test3(){
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3,0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);

        Assert.assertTrue(myLinkedList.get(4) == 4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5,0);
        myLinkedList.addAtHead(6);
    }

    /**
     * ["MyLinkedList","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","addAtTail","addAtTail","deleteAtIndex","addAtHead","addAtHead","get","addAtTail","addAtHead",
     * "get","addAtTail","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","get","addAtIndex","addAtHead","get","addAtHead","deleteAtIndex","addAtHead","addAtTail",
     * "addAtTail","addAtIndex","addAtTail","addAtHead","get","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtHead","addAtTail","addAtHead","addAtHead",
     * "addAtTail","addAtTail","get","get","addAtHead","addAtTail","addAtTail","addAtTail","addAtIndex","get","addAtHead","addAtIndex","addAtHead","addAtTail","addAtTail",
     * "addAtIndex","deleteAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","addAtTail","addAtHead","get","addAtIndex",
     * "addAtTail","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","deleteAtIndex","get","get","addAtHead","get","addAtTail","addAtTail","addAtIndex",
     * "addAtIndex","addAtHead","addAtTail","addAtTail","get","addAtIndex","addAtHead","deleteAtIndex","addAtTail","get","addAtHead","get","addAtHead","deleteAtIndex","get",
     * "addAtTail","addAtTail"]
     * [[],[38],[66],[61],[76],[26],[37],[8],[5],[4],[45],[4],[85],[37],[5],[93],[10,23],[21],[52],[15],[47],[12],[6,24],[64],[4],[31],[6],[40],[17],[15],[19,2],[11],[86],[17],
     * [55],[15],[14,95],[22],[66],[95],[8],[47],[23],[39],[30],[27],[0],[99],[45],[4],[9,11],[6],[81],[18,32],[20],[13],[42],[37,91],[36],[10,37],[96],[57],[20],[89],
     * [18],[41,5],[23],[75],[7],[25,51],[48],[46],[29],[85],[82],[6],[38],[14],[1],[12],[42],[42],[83],[13],[14,20],[17,34],[36],[58],[2],[38],[33,59],[37],[15],[64],
     * [56],[0],[40],[92],[63],[35],[62],[32]]
     */
    @Test
    public void test4(){

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