package io.github.sruby.annotation.point;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 积分注解
 * @author liuwf on May 6, 2017 3:17:21 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PointAnnotation
{
	String pointRuleNo() default "";
	String beforeClass() default "";
	
}
