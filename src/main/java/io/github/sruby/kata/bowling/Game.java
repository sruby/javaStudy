package io.github.sruby.kata.bowling;


/**
 * 保龄球计分
 * @author sruby on Aug 15, 2017 9:09:03 PM
 */
public class Game
{
	private int rolls[] = new int[21];
	private int currentRoll = 0;
	
	/**
	 * 打保龄球
	 * @author sruby on Aug 15, 2017 9:13:37 PM
	 * @param i
	 */
	public void roll(int pins)
	{
		rolls[currentRoll++] = pins;
	}
	
	/**
	 * 计分
	 * @author sruby on Aug 15, 2017 9:49:38 PM
	 * @return
	 */
	public int score()
	{
		int score = 0;
		int frameIndex = 0;
		for (int frame = 0; frame < 10; frame++ )
		{
			/**
			 * 全中，奖励后面两个球的分数
			 */
			if(isStrike(frameIndex))
			{
				score += 10 + strikeBonus(score, frameIndex);
				frameIndex++;
			}
			else if(isSpare(frameIndex)) //如果两个球的分数之后是10，则是补全，额外奖励下一个球的分数
			{
				score += 10 + spareBonus(frameIndex);
				frameIndex += 2;
			}
			else
			{
				score += sumOfBallInFrame(frameIndex);
				frameIndex += 2;
			}
		}
		return score;
	}

	/**
	 * 补中奖励
	 * @author sruby on Aug 16, 2017 9:57:05 PM
	 * @param frameIndex
	 * @return
	 */
	private int spareBonus(int frameIndex)
	{
		return rolls[frameIndex+2];
	}

	/** 
	 * 全中奖励
	 * @author sruby on Aug 16, 2017 9:54:01 PM
	 * @param score
	 * @param frameIndex
	 * @return
	 */
	private int strikeBonus(int score, int frameIndex)
	{
		return rolls[frameIndex+1] + rolls[frameIndex+2];
	}

	/**
	 * 一个格子中两个球的分数汇总
	 * @author sruby on Aug 16, 2017 9:53:05 PM
	 * @param frameIndex
	 * @return
	 */
	private int sumOfBallInFrame(int frameIndex)
	{
		return rolls[frameIndex] + rolls[frameIndex+1];
	}
	
	/**
	 * 是否全中
	 * @author sruby on Aug 16, 2017 9:50:46 PM
	 * @param frameIndex
	 * @return
	 */
	private boolean isStrike(int frameIndex)
	{
		return rolls[frameIndex] == 10;
	}
	
	/**
	 * 是否是补全
	 * @author sruby on Aug 16, 2017 9:13:03 PM
	 * @param frameIndex
	 * @return
	 */
	private boolean isSpare(int frameIndex)
	{
		return rolls[frameIndex] + rolls[frameIndex+1] == 10;
	}
}
