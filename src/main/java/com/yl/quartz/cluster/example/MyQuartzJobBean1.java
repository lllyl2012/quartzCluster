package com.yl.quartz.cluster.example;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class MyQuartzJobBean1 extends QuartzJobBean{

	private static final Logger LOGGER = LoggerFactory.getLogger(MyQuartzJobBean1.class);
	
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		SimpleService simpleService = getApplicationContext(context).getBean("simpleService",SimpleService.class);
		simpleService.testMethod1();
	}

	private ApplicationContext getApplicationContext(final JobExecutionContext jobExecutionContext) {
		try {
			return (ApplicationContext)jobExecutionContext.getScheduler().getContext().get("applicationContextKey");
		} catch (Exception e) {
			LOGGER.error("jobExecutionContext.getScheduler()",e);
			throw new RuntimeException();
		}
	}
}
