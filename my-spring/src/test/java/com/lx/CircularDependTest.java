package com.lx;

import com.lx.entity.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("circularDependTest.xml");
		A a = (A) applicationContext.getBean("a");
		System.out.println(a);
	}
}
