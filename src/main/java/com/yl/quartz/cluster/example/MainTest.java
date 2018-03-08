package com.yl.quartz.cluster.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext("classpath:application.xml","classpath:applicationContext-quartz.xml");
		System.out.println(springContext);
	}
}
