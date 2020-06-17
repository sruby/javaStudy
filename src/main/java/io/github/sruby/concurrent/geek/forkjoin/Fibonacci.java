package io.github.sruby.concurrent.geek.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @description: Fibonacci base on fork/join
 * @author: sruby
 * @create: 2020-06-17 13:38
 */
public class Fibonacci extends RecursiveTask<Integer> {
    final  int n;
    public Fibonacci(int n){
        this.n = n;
    }
    @Override
    protected Integer compute() {
        if (n<=1){
            return n;
        }

        Fibonacci f1 = new Fibonacci(n-1);
        f1.fork();

        Fibonacci f2 = new Fibonacci(n-2);
        return  f2.compute() + f1.join();
    }
}
