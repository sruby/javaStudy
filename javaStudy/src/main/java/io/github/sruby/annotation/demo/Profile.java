package io.github.sruby.annotation.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * 基本资料注解 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Profile
{
	/** 
	 * ID 
	 * 
	 * @return 
	 */
	public int id() default -1;
	
	/** 
	 * 身高 
	 * 
	 * @return 
	 */
	public int height() default 0;
	
	/** 
	 * 籍贯 
	 * 
	 * @return 
	 */
	public String nativePlace() default "";
}