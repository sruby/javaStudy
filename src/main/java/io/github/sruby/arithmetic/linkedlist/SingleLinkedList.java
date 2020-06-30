package io.github.sruby.arithmetic.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * linkList
 */
@Data
public class SingleLinkedList {
    private int index;
    private Node head;
    public SingleLinkedList(){
    }

    public void add(Object data){
        Node newData = new Node(data);
        if (index == 0){
            this.head = newData;
        }else {
            newData.next = head.next;
            head.next = newData;
        }
        index ++;
    }

    public void remove(Object data){
        Node node = head;
        if (data.equals(head.data)){
            head = head.next;
            index --;
            return;
        }
        while(node.next !=null){
            if (data.equals(node.next.data)){
                node.next = node.next.next;
                break;
            }
            node = node.next;
            index --;
        }
    }

    @AllArgsConstructor
    @RequiredArgsConstructor()
    @Data
    class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data = data;
        }
    }
}
