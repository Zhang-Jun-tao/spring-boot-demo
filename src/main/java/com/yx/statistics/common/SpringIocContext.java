package com.yx.statistics.common;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service //必须加该注解
public class SpringIocContext implements ApplicationContextAware{
	private static final Logger logger = Logger.getLogger(SpringIocContext.class);
	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
			try {
				if(arg0==null)
					throw new Exception("applicationContext is null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		applicationContext=arg0;
		logger.error("----------applicationContext--init()------------");
	}
}
