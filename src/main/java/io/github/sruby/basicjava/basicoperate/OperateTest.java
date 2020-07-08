package io.github.sruby.basicjava.basicoperate;

import org.junit.Test;

/**
 * https://www.cnblogs.com/eyjdbk/p/10962827.html
 */
public class OperateTest {
    /**
     * 如果只是a++;或者++a;这样不参与赋值操作，那结果都是一样，都是加1；
     */
    @Test
    public void test() {
        int i = 0;
        System.out.println(i++);
        System.out.println(i==0);
        System.out.println(i);
        System.out.println(++i);
    }

    @Test
    public void test2() {
        int a = 3;
        int b = a++;   //a先赋值给b，然后a再自己加1
        System.out.println("a="+a);  //输出a=4
        System.out.println("b="+b);    //输出b=3

        System.out.println("\n");

        a = 3;
        int c = ++a;   //a先加1，然后再赋值给c
        System.out.println("a="+a);    //输出a=4
        System.out.println("c="+c);    //输出c=4


        System.out.println("\n");


        c++;
        System.out.println(c);//输出5

        ++c;
        System.out.println(c);//输出6
    }
}
