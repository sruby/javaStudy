package io.github.sruby.concurrent.synchronize;

/**
 * 非线程安全的
 * @author sruby on 2016年7月23日 上午12:26:04
 */
public class UnSynchBankTest
{
	public static void main(String[] args)
	{
		new Thread(new TransferRunnable()).start();
		new Thread(new TransferRunnable()).start();
	}
}
