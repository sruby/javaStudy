package io.github.sruby.leetcode.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * stack
 */
public class MinStack {
    private List<Integer> array;

    /** initialize your data structure here. */
    public MinStack() {
        this.array = new ArrayList<>();
    }
    
    public void push(int x) {
        this.array.add(x);
    }
    
    public void pop() {
        if (this.array.isEmpty()){
            return;
        }
        this.array.remove(this.array.size()-1);
    }
    
    public int top() {
        if (this.array.isEmpty()){
            return -1;
        }
        return this.array.get(this.array.size()-1);
    }
    
    public int getMin() {
        Integer min = Collections.min(this.array);
        return min;
    }
}
