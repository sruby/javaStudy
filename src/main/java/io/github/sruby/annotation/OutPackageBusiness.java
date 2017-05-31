package io.github.sruby.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.sruby.annotation.point.PointRelationsBusiness;

/**
 * 
 * @author liuwf on May 31, 2017 2:37:21 PM
 */
public class OutPackageBusiness implements PointRelationsBusiness
{
	private Logger logger = LoggerFactory.getLogger(OutPackageBusiness.class);
	
	public void test()
	{
		logger.debug("outPackageBusiness test");
	}
}
