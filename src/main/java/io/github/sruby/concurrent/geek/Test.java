package io.github.sruby.concurrent.geek;

public class Test {
  private long count = 0;
  private synchronized void add10K() {
    int idx = 0;
    while(idx++ < 10000) {
      count += 1;
    }
    System.out.println("count:"+count);
  }
  public static void calc() throws InterruptedException {
    final Test test = new Test();
    // 创建两个线程，执行add()操作
    Thread th1 = new Thread(()->{
      test.add10K();
    });
    Thread th2 = new Thread(()->{
      test.add10K();
    });
    // 启动两个线程
    th1.start();
    th2.start();
    // 等待两个线程执行结束
    th1.join();
    th2.join();
  }

  public static void main(String[] args) throws InterruptedException {
    calc();
  }
}