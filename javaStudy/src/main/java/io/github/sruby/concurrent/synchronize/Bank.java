package io.github.sruby.concurrent.synchronize;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟银行类
 * @author sruby on 2016年7月23日 上午12:18:23
 */
public class Bank
{
	private double[] accounts;
	private ReentrantLock lock = new ReentrantLock();
	/**
	 * 
	 * @param num 账户数量
	 * @param initialBalance 初始化资金
	 */
	public Bank(int num,double initialBalance)
	{
		accounts = new double[num];
		
		for (int i = 0; i < accounts.length; i++)
		{
			accounts[i] = initialBalance;
		}
	}
	
	/**
	 * 获取账户总数量
	 * @author sruby on 2016年7月23日 上午12:25:13
	 * @return
	 */
	public int getAmount()
	{
		return accounts.length;
	}
	
	/**
	 * 转账
	 * @author sruby on 2016年7月23日 上午12:25:06
	 * @param from
	 * @param to
	 * @param amount
	 */
	public void transfer(int from, int to, double amount)
	{
		//获得锁,需要执行完try所有语句才会释放,在释放之前,其他线程是处于阻塞状态
		lock.lock();
		try
		{
			if(accounts[from] < amount)
			{
				System.out.println("资金不足");
				return;
			}
			accounts[from] -= amount;
			accounts[to] += amount;
		}
		finally
		{
			lock.unlock();
		}
		
	}
	
	/**
	 * 获取银行总资产
	 * @author sruby on 2016年7月23日 上午12:24:54
	 * @return
	 */
	public double getTotalBalance()
	{
		double totalBalance = 0;
		for (int i = 0; i < accounts.length; i++)
		{
			System.out.println("每个账户的金额:"+accounts[i]);
			totalBalance += accounts[i];
		}
		return totalBalance;
	}
}
 