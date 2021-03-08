package com.lx;

import com.lx.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factoryBeanTest.xml");
		Student student = (Student) applicationContext.getBean("studentFB");
		System.out.println(student);
		System.out.println(applicationContext.getBean("&studentFB"));
	}
}
