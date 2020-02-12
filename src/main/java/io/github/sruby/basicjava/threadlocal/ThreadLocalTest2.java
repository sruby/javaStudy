package io.github.sruby.basicjava.threadlocal;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * test
 */
public class ThreadLocalTest2  {
    static class TestThread extends Thread{
//        public ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        private  boolean isStop = false;
        private InvokeClass invokeClass = new InvokeClass();
        private int a;

        public TestThread(int a) {
            this.a = a;
        }

        public boolean isStop() {
            return isStop;
        }

        public void setStop(boolean stop) {
            isStop = stop;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"--"+a+";isStop:"+isStop);
            while (!isStop){
                try {
                    TimeUnit.SECONDS.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"--"+a);
                invokeClass.invokeByThread();
            }
        }
    }

    static class  InvokeClass {
        public InvokeClass() {
        }

        public void invokeByThread(){
            System.out.println(Thread.currentThread().getName()+"--"+"invokeByThread");
            TestThread testThread = (TestThread) Thread.currentThread();
            boolean stop = testThread.isStop();
            System.out.println(Thread.currentThread().getName()+"--"+"stop:"+stop);

        }
    }

    /**
     * junit测试方法执行完成之后，子线程也会停止，不会继续执行。
     * 不适合进行多线程的测试验证。
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        List<TestThread> threadList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            TestThread testThread = new TestThread(i);
            threadList.add(testThread);
            testThread.start();;
        }

        TimeUnit.SECONDS.sleep(8L);
        System.out.println("get");
        TestThread testThread = threadList.get(0);
        testThread.setStop(true);

        for (int i = 0; i < threadList.size(); i++){
            System.out.println("thread isstop:"+threadList.get(i).isStop());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<TestThread> threadList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            TestThread testThread = new TestThread(i);
            threadList.add(testThread);
            testThread.start();;
        }

        TimeUnit.SECONDS.sleep(8L);
        System.out.println("get");
        TestThread testThread = threadList.get(0);
        testThread.setStop(true);

        for (int i = 0; i < threadList.size(); i++){
            System.out.println("thread isstop:"+threadList.get(i).isStop());
        }
    }





}
