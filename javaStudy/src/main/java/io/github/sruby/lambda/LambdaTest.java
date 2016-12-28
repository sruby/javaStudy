package io.github.sruby.lambda;

import org.junit.Test;


public class LambdaTest
{
	public static void main(String[] args)
	{
		
	}
	
	public void runThread() {
	    new Thread(new Runnable() {
	        public void run() {
	            System.out.println("Run!");
	        }
	    }).start();
	}
	
	@Test
	public void runThreadUseLambda() {
		new Thread(()->{
			System.out.println("run!!!!");
		}).start();
	}
}
