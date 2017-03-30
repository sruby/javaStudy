package io.github.sruby.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor
{
	/**
	 * 颜色枚举
	 * @author liuwf on 2017年3月27日 下午9:07:12
	 */
	public enum Color{RED,BLUE,GREEN};
	
	/**
	 * 颜色属性
	 * @author liuwf on 2017年3月27日 下午9:08:05
	 * @return
	 */
	Color fruitColor() default Color.GREEN;
}
