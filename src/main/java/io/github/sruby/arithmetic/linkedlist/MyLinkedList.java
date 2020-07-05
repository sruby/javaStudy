package io.github.sruby.arithmetic.linkedlist;

/**
* @Description: leetcode Singly Linked List
* @author: sruby
* @Date: 2020-7-5 17:12
*/
class MyLinkedList {
    private Node head;
    private int count;
    class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (head == null || index >= count){
            return -1;
        }

        Node curNode = head;
        while ( index-->0){
            curNode = curNode.next;
        }
        return curNode.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null){
            head = newNode;
        }else {
            newNode.next = head;
            head =  newNode;
        }
        count ++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null){
            head = new Node(val);;
        }else {
            Node curNode = head;
            while (curNode.next !=null){
                curNode = curNode.next;
            }
            curNode.next = new Node(val);
        }

        count++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length
     * of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > count){
            return;
        }
        if (index == count){
            addAtTail(val);
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        Node preNode = head;
        while (index-->1){
            preNode = preNode.next;
        }
        Node newNode = new Node(val);
        newNode.next = preNode.next;
        preNode.next = newNode;
        count++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= count || count == 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            count--;
            return;
        }
        Node curNode = head;
        while (index-->1){
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
        count--;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */