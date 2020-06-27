package io.github.sruby.interfacetest;

/**
 * https://www.geeksforgeeks.org/private-methods-java-9-interfaces/
 * Java 8 Interface Changes
 * @author sruby on 2020-6-26 16:40
 */
public interface InterfaceWithStaticMethod {
    void div(int a, int b);
    default int add(int a,int b){
        return a+b;
    }

    //only invoke by Interface
    static int mul(int a,int b){
        return a*b;
    }
}
