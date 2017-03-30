package io.github.sruby.lambda;

import java.util.List;
import java.util.function.Predicate;


public class PredicateTest
{
	public void filter(List<String> list, Predicate predicate)
	{
		for (String string : list)
		{
			if(predicate.test(string))
			{
				System.out.println(string);
			}
		}
	}
}
