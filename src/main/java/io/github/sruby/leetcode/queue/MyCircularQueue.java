package io.github.sruby.leetcode.queue;

/**
 * leetcode Circular Queue
 * @author sruby
 * @date 2020/7/6 11:04
 */
class MyCircularQueue {
    private Integer[] array;
    private int headIndex;
    private int tailIndex;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.array = new Integer[k];
        this.size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        array[tailIndex] = value;
        tailIndex = (tailIndex + 1) % size;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        array[headIndex] = null;
        headIndex = (headIndex + 1) % size;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return array[headIndex];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        if(tailIndex - 1 >= 0){
            return array[tailIndex-1];
        }else {
            return array[size - 1];
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if ((headIndex == tailIndex) && array[headIndex] ==null){
            return true;
        }
        return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((headIndex == tailIndex) && array[headIndex] !=null){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */