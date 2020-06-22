package io.github.sruby.concurrent.geek.balking;

/**
 * SingletonByBalking
 *
 * @author sruby on 2020-6-22 23:09
 */
public class SingletonByBalking {
    private SingletonByBalking(){};
    private static volatile  SingletonByBalking singletonByBalking;

    /**
     *
     * @return
     */
    public static SingletonByBalking getInstance() {
        if (singletonByBalking !=null){
            return singletonByBalking;
        }
        synchronized (SingletonByBalking.class) {
            if (singletonByBalking != null){
                return  singletonByBalking;
            }
            singletonByBalking = new SingletonByBalking();
            return singletonByBalking;
        }
    }
}
