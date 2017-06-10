package io.github.sruby.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * 序列化测试类
 * @author liuwf on Jun 10, 2017 3:34:46 PM
 */
public class Client
{
	/**
	 * 序列化
	 * @author liuwf on Jun 10, 2017 3:35:53 PM
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void serialize()
	{
		UserSerializable userSerializable = new UserSerializable();
		userSerializable.setAge(11);
		userSerializable.setName("xiaoming");
		
		ObjectOutputStream  objectOutput = null;
		try
		{
			objectOutput = new ObjectOutputStream(new FileOutputStream("userserialize"));
			objectOutput.writeObject(userSerializable);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(objectOutput);
		}
		
		
	}
	
	/**
	 * 反序列化
	 * @author liuwf on Jun 10, 2017 3:36:01 PM
	 */
	@Test
	public void deserialization()
	{
		ObjectInputStream inputStream = null;
		File file = new File("userserialize");
		try
		{
			inputStream = new ObjectInputStream(new FileInputStream(file));
			UserSerializable userSerializable = (UserSerializable) inputStream.readObject();
			System.out.println(userSerializable.getAge()+userSerializable.getName());
		}
		catch (ClassNotFoundException | IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(inputStream);
//			try
//			{
//				FileUtils.forceDelete(file);
//			}
//			catch (IOException e)
//			{
//				e.printStackTrace();
//			}
		}
	}
	
	
}
