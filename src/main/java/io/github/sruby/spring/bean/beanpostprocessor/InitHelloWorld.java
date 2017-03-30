package io.github.sruby.spring.bean.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean后置处理器
 * BeanPostProcessor 接口定义回调方法，你可以实现该方法来提供自己的实例化逻辑，依赖解析逻辑等。
 * 你也可以在 Spring 容器通过插入一个或多个 BeanPostProcessor 的实现来完成实例化，配置和初始化一个bean之后实现一些自定义逻辑回调方法。
 * @author sruby on 2016年10月3日 上午1:32:49
 */
public class InitHelloWorld implements BeanPostProcessor
{
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
	{
		System.out.println("BeforeInitialization : " + beanName);
		return bean; // you can return any other object as well
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
	{
		System.out.println("AfterInitialization : " + beanName);
		return bean; // you can return any other object as well
	}
}
