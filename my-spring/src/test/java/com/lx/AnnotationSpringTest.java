package com.lx;

import com.lx.config.FirstConfig;
import com.lx.entity.A;
import com.lx.entity.HelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationSpringTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(FirstConfig.class);
//		HelloWorld helloWorld = (HelloWorld) annotationConfigApplicationContext.getBean("helloWorld");
//		helloWorld.sayHello();
		A a = (A) annotationConfigApplicationContext.getBean("a");
		a.say();
	}
}
