package io.github.sruby.concurrent;

import org.junit.Test;

/**
 * 龟兔赛跑单线程
 * @author liuwf on 2016年5月29日 上午11:39:35
 */
public class ToitoseHareRace
{
	public static void main(String[] args)
	{
		int totalStep = 10;
		int toitoseStepLength = 1;
		int hareStepLength = 2;
		int toitoseSetpNum = 0;
		int hareStepNum = 0;
		
		while (toitoseSetpNum < totalStep && hareStepLength<totalStep)
		{
			toitoseSetpNum += toitoseStepLength;
			
			int random = (int) (Math.random()*10);
			boolean isSleep = random%2 ==0 ? true:false;
			
			if(isSleep)
			{
				hareStepNum += hareStepLength;
			}
			if(toitoseSetpNum == totalStep)
			{
				System.out.println("toitose won!");
				break;
			}
			if(hareStepNum == totalStep)
			{
				System.out.println("hare won!");
				break;
			}
		}
		
		System.out.println("toitoseSetpNum"+toitoseSetpNum+"hareStepNum"+hareStepNum);
		
	}
	
	@Test
	public void test()
	{
		int random = (int) (Math.random()*10);
		System.out.println(random);
		System.out.println(random/2 ==0 ? true:false);
		System.out.println(random/2);
		System.out.println(random%2);
	}
}
