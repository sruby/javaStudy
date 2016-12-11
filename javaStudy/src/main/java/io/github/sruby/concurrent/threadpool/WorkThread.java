package io.github.sruby.concurrent.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

public class WorkThread extends Thread
{
	private Runnable target;  
    private AtomicInteger counter;  
 
    public WorkThread(Runnable target, AtomicInteger counter) {  
        this.target = target;  
        this.counter = counter;  
    }  
    
    
	@Override
	public void run()
	{
		target.run();
	}
}
