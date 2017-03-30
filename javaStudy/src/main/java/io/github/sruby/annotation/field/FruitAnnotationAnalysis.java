package io.github.sruby.annotation.field;

import io.github.sruby.annotation.field.FruitColor.Color;

import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 注解解析
 * @author liuwf on 2017年3月30日 下午5:03:37
 */
public class FruitAnnotationAnalysis
{
	private static Logger logger = LoggerFactory.getLogger(FruitAnnotationAnalysis.class);
	
	public void annlysis(Class classObject)
	{
		Field[] fields = classObject.getDeclaredFields();
		for (Field field : fields)
		{
			if(field.isAnnotationPresent(FruitColor.class))
			{
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				Color color = fruitColor.fruitColor();
				logger.info("color{}",color);
			}
			if(field.isAnnotationPresent(FruitName.class))
			{
				FruitName fruitName = field.getAnnotation(FruitName.class);
				String fruitNameValue = fruitName.value();
				logger.info("fruitNameValue{}",fruitNameValue);
			}
		}
	}
}
