package io.github.sruby.kata.bowling;

import junit.framework.TestCase;

/**
 * 保龄球游戏测试
 * @author sruby on Aug 15, 2017 9:11:00 PM
 */
public class BowlingGameTest extends TestCase
{
	private Game game;
	
	protected void setUp()
	{
		game = new Game();
	}
	
	public void testGutterGame()
	{
		int n = 20;
		int pins = 0;
		rollMany(n, pins);
		assertEquals(0, game.score());
	}

	/**
	 * 打多次保龄球
	 * @author sruby on Aug 15, 2017 9:54:27 PM
	 * @param n
	 * @param pins
	 */
	private void rollMany(int n, int pins)
	{
		for (int i = 0; i < n; i++)
		{
			game.roll(pins);
		}
	}
	
	/**
	 * 所有得分是1
	 * @author sruby on Aug 15, 2017 9:54:11 PM
	 */
	public void testAllOnes()
	{
		rollMany(20, 1);
		assertEquals(20, game.score());
	}
	
	/**
	 * 测试一次补中
	 * @author sruby on Aug 15, 2017 9:56:02 PM
	 */
	public void testOneSpare()
	{
		rollSpare();
		game.roll(2);
		rollMany(17, 1);
		assertEquals(31, game.score());
	}

	/**
	 * 打出补全
	 * @author sruby on Aug 16, 2017 9:14:19 PM
	 */
	private void rollSpare()
	{
		game.roll(5);
		game.roll(5);
	}
	
	/**
	 * 测试全中
	 * @author sruby on Aug 16, 2017 9:15:30 PM
	 */
	public void testOneStrike()
	{
		rollStrike();
		rollMany(18, 1);
		assertEquals(30, game.score());
	}

	/** 
	 * 打出全中
	 * @author sruby on Aug 16, 2017 10:00:39 PM
	 */
	private void rollStrike()
	{
		game.roll(10);
	}
	
	public void testPerfectGame()
	{
		rollMany(12, 10);
		assertEquals(300, game.score());
	}
	
	
}
