package io.github.sruby.concurrent.synchronize;

/**
 * 转账线程类
 * @author sruby on 2016年7月23日 上午12:27:40
 */
public class TransferRunnable implements Runnable
{
	@Override
	public void run()
	{
		Bank bank = new Bank(10, 10000);
		int num = bank.getAmount();
		while (true)
		{
			int from = (int)(num * Math.random());
			int to = (int)(num * Math.random());
			double amount = (double)(10000 * Math.random());
//			System.out.println("from:"+from+",to:"+to+",amount:"+amount);
			try
			{
				bank.transfer(from, to, amount);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			System.out.println("银行总金额"+bank.getTotalBalance());
//			try
//			{
//				Thread.sleep(1000L);
//			}
//			catch (InterruptedException e)
//			{
//				e.printStackTrace();
//			}
		}
		
	}
	
}
