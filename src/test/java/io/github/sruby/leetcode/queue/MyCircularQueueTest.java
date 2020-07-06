package io.github.sruby.leetcode.queue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyCircularQueueTest {
    private MyCircularQueue myCircularQueue;
    @Before
    public void setUp() throws Exception {
        myCircularQueue = new MyCircularQueue(3);
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * ["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
     * [[3],[1],[2],[3],[4],[],[],[],[4],[]]
     * Expected answer: [null,true,true,true,false,3,true,true,true,4]
     */
    @Test
    public void test() {
        Assert.assertTrue(myCircularQueue.enQueue(1));
        Assert.assertTrue(myCircularQueue.enQueue(2));
        Assert.assertTrue(myCircularQueue.enQueue(3));
        Assert.assertTrue(!myCircularQueue.enQueue(4));
        Assert.assertTrue(myCircularQueue.Rear() == 3);
        Assert.assertTrue(myCircularQueue.isFull());
        Assert.assertTrue(myCircularQueue.deQueue());
        Assert.assertTrue(myCircularQueue.enQueue(4));
        Assert.assertTrue(myCircularQueue.Rear()==4);
    }

    /**
     * ["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
     * [[6],[6],[],[],[],[5],[],[],[],[],[],[]]
     */
    @Test
    public void test2() {
        String[] array = {"MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"};
        String param = "[[6],[6],[],[],[],[5],[],[],[],[],[],[]]";


    }

    @Test
    public void enQueue() {
    }

    @Test
    public void deQueue() {
    }

    @Test
    public void front() {
    }

    @Test
    public void rear() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void isFull() {
    }
}