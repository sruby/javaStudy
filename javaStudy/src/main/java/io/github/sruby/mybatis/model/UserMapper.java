package io.github.sruby.mybatis.model;

import java.util.List;

/**
 * 要注意的一个地方就是。在 User.xml 的配置文件中，mappernamespace="io.github.sruby.mybatis.model.UserMapper"
，命名空间非常重要，不能有错，必须与我们定义的 package和接口一致。
 * @author liuwf on Sep 12, 2016 9:13:17 PM
 */
public interface UserMapper
{
	/**
	 * selectUserByID 必须与User.xml 里面配置的 select 的id 对应（<selectid="selectUserByID"）
	 * @author liuwf on Sep 12, 2016 9:04:33 PM
	 * @param id
	 * @return
	 */
	public User selectUserByID(int id);
	
	public List selectUsers(String userName);
}
