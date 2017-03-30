package io.github.sruby.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.cnblogs.com/peida/archive/2013/04/24/3036689.html
 * @author liuwf on 2017年3月27日 下午9:00:03
 */
@ClassAnnotation
public class AnnotationClient
{
	private static Logger logger = LoggerFactory.getLogger(AnnotationClient.class);
	
	public static void main(String[] args)
	{
		logger.debug("test");
	}
}
