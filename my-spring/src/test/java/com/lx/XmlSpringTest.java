package com.lx;

import com.lx.entity.Person;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class XmlSpringTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		/**
		 * 1. 将资源文件转化为Resource文件
		 * 2. 将Resource文件转化为Document文件
		 * 3. 对Document文件进行解析，实际为Element文件解析
 		 */
		Person person = (Person) applicationContext.getBean("prodPerson");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		Person person1 = (Person) xmlBeanFactory.getBean("prodPerson");
		System.out.println(xmlBeanFactory.getBeanDefinition("prodPerson").getAttribute("key"));
		System.out.println(person1);
		System.out.println(person);
	}
}
