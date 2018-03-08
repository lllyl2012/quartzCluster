package com.yl.quartz.cluster.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("simpleService")
public class SimpleService{
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleService.class); 
	public void testMethod1(){
		LOGGER.info("testMethod1.......1");
		System.out.println("1--testMethod1...."+System.currentTimeMillis()/1000);
	}
	public void testMethod2(){
		LOGGER.info("testMethod2......2");
	}
}
