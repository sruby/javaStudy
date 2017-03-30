package io.github.sruby.annotation.field;

import org.junit.Test;


public class FruitAnnotationAnalysisTest
{
	private FruitAnnotationAnalysis fruitAnnotationAnalysis = new FruitAnnotationAnalysis();
	
	@Test
	public void test()
	{
		fruitAnnotationAnalysis.annlysis(Apple.class);
	}
	
}
