package com.lx.entity.postProcessor;

import com.lx.entity.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class StudentPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Student) {
			((Student) bean).say();
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Student) {
			Student student = (Student) bean;
			student.setName("process student...");
			student.setAge(100);
			student.setTeacherName("spring teacher...");
			student.say();
		}
		return bean;
	}
}
