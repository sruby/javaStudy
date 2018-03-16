package io.github.sruby.spring.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;


public class UserService
{
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	private User user = new User();
	
	//缓存到name为cache1的缓存对象中
	@Cacheable(value="cache1")
	public User findUser()
	{
		logger.info("findUser set cache");
		user = new User(1, "cacheName", "20", "china");
		return user;
	}
	
	//缓存到name为cache1的缓存对象中
	@Cacheable(value="cache1")
	public User findUserByUserId(int userId)
	{
		logger.info("findUser set cache by userId");
		user = new User(userId, "cacheName", "20", "china");
		return user;
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
		user = new User(1, "cacheName2", "202", "china2");
		return user;
	}
	
	/**
	 * 缺省key清除所有缺省key的缓存
	 * @author sruby on 2018年3月14日 下午2:27:29
	 */
	@CacheEvict(value="cache1")
	public void updateUser()
	{
		logger.info("updateUser cache evict");
	}
	
	/**
	 * 按照key来清除特定缓存
	 * @author sruby on 2018年3月14日 下午2:27:29
	 */
	@CacheEvict(value="cache1", key="#user.getId")
	public void updateUserByUserId()
	{
		logger.info("updateUser cache evict");
	}
	
	@CachePut(value="cache1")
	public void putUser()
	{
		logger.info("putUser cache put");
	}
}
