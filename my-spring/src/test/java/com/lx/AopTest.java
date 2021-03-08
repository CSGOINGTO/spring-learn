package com.lx;

import com.lx.entity.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aopTest.xml");
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		helloWorld.sayHello();
		helloWorld.doSome("干活！");
		helloWorld.sleep();
	}
}
