package io.github.sruby.annotation.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 姓名注解
 * @author liuwf on 2017年3月30日 下午4:59:55
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface Name
{
	String value() default "";
}
