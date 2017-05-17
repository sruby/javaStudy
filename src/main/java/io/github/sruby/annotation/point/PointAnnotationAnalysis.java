package io.github.sruby.annotation.point;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

/**
 * 积分注解解析
 * @author liuwf on May 6, 2017 3:20:45 PM
 */
public class PointAnnotationAnalysis extends ApplicationObjectSupport
{
	private Logger logger = LoggerFactory.getLogger(PointAnnotationAnalysis.class);
	
	public void analysis(Class<?> clazz)
	{
		logger.debug("analysis start");
		//获取类的所有method
		Method[] methods = clazz.getMethods();
		for (Method method : methods)
		{
			//判断方法是否有被PointAnnotation注解
			if(method.isAnnotationPresent(PointAnnotation.class))
			{
				//获取PointAnnotation的注解
				PointAnnotation annotation = method.getAnnotation(PointAnnotation.class);
				String pointRuleNo = annotation.pointRuleNo();
				String beforeClass = annotation.beforeClass();
				
				//获取对应处理类的对象
				ApplicationContext applicationContext = this.getApplicationContext();
				PointHandle loginServicePointHandle = applicationContext.getBean(beforeClass,PointHandle.class);
				
				//执行前置业务
				loginServicePointHandle.invoke(pointRuleNo);
			}
		}
		logger.debug("analysis end");
	}
}
