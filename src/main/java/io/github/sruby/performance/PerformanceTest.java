package io.github.sruby.performance;

import org.junit.Test;

/**
 * 性能优化
 * @author liuwf on 2017年1月22日 下午3:55:24
 */
public class PerformanceTest
{
	@Test
	public void doTest()
	{
		double l;
		long then = System.currentTimeMillis();
		int nLoops = 50;
		for (int i = 0; i < nLoops; i++)
		{
			l = compute(40);
			System.out.println(l);
			
		}
		long now = System.currentTimeMillis();
		System.out.println("Elapsed time:" + (now - then));
	}
	
	private double compute(int n)
	{
		if (n < 0)
			throw new IllegalArgumentException("Must be > 0");
		if (n == 0)
			return 0d;
		if (n == 1)
			return 1d;
		double d = compute(n - 2) + compute(n - 1);
		if (Double.isInfinite(d))
			throw new ArithmeticException("Overflow");
		return d;
	}
}
