package io.github.sruby.basicjava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 反射相关类使用
 * @author sruby
 *
 */
public class Client 
{
	/**
	 * 测试通过反射生成一个对象
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public void testNewInstance() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
	    /**
	     * 获取Car类的对象
	     */
	    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
	    Class carClass = contextClassLoader.loadClass("io.github.sruby.basicjava.reflect.Car");
	    
	    /**
	     * 获取默认构造器并生成Car的实例
	     */
	    Constructor declaredConstructor = carClass.getDeclaredConstructor();
	    Car object = (Car) declaredConstructor.newInstance();
	    
	    /**
	     * 通过反射方法设置属性
	     */
	    Method method = carClass.getMethod("setBrand", String.class);
	    method.invoke(object, "baoma");
	    
	    System.out.println(object.toString());
	    
	    
	}
}
