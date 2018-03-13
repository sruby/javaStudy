package io.github.sruby.spring.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


public class UserService
{
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	//缓存到name为cache1的缓存对象中
	@Cacheable(value="cache1")
	public User findUser()
	{
		logger.info("findUser start");
		return new User(1, "cacheName", "20", "china");
	}
	
	/**
	 * 默认key生成： （所以findUser2和findUser是使用的同一个key）
		默认key的生成按照以下规则： 
		- 如果没有参数,则使用0作为key（如果注解在其他无入参的方法并且用默认key则会出现冲突）
		- 如果只有一个参数，使用该参数作为key 
		- 如果又多个参数，使用包含所有参数的hashCode作为key
	 * @author sruby on 2018年3月12日 下午5:36:42
	 * @return
	 */
	@Cacheable(value="cache1")
	public User findUser2()
	{
		logger.info("findUser2 start");
		return new User(1, "cacheName2", "202", "china2");
	}
	
	@CacheEvict(value="cache1",key="")
	public void updateUser()
	{
		logger.info("updateUser start");
	}
}
