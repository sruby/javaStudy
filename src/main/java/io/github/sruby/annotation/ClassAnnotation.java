package io.github.sruby.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface ClassAnnotation
{
	/**
	 * test
	 * @author liuwf on 2017年3月27日 下午8:28:09
	 * @return
	 */
	public String test() default "test";
}
