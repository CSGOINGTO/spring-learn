package com.lx;

import com.lx.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostProcessorTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("postProcessor.xml");
		Student student = (Student) applicationContext.getBean("s");
		student.say();
	}
}
