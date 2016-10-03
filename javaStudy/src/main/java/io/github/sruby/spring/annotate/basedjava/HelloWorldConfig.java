package io.github.sruby.spring.annotate.basedjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.sruby.spring.bean.HelloWorld;
import io.github.sruby.spring.di.constructorbased.SpellChecker;
import io.github.sruby.spring.di.constructorbased.TextEditor;

/**
 * 等同于下面的 XML 配置：
 *<beans>
 *  <bean id="helloWorld" class="com.tutorialspoint.HelloWorld" />
 *</beans>
 *带有 @Configuration 的注解类表示这个类可以使用 Spring IoC 容器作为 bean 定义的来源。
 *@Bean 注解告诉 Spring，一个带有 @Bean 的注解方法将返回一个对象，该对象应该被注册为在 Spring 应用程序上下文中的bean。
 * @author sruby on 2016年10月4日 上午12:41:47
 */
@Configuration
public class HelloWorldConfig
{
	
	
	@Bean
	public HelloWorld helloWorld()
	{
		return new HelloWorld();
	}
	
	/**
	 * 注入依赖
	 * @author sruby on 2016年10月4日 上午12:46:11
	 * @return
	 */
	@Bean
	public TextEditor textEditor()
	{
		return new TextEditor(spellChecker());
	}
	
	@Bean
	public SpellChecker spellChecker()
	{
		return new SpellChecker();
	}
}
