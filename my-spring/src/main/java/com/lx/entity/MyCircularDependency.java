package com.lx.entity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MyCircularDependency {

	private Map<String, Object> beanCache = new HashMap<>();

	public Object getBean(String beanName) {
		if (beanCache.containsKey(beanName)) return beanCache.get(beanName);
		try {
			Class<?> clazz = Class.forName(beanName);
			Object instance = clazz.getDeclaredConstructor().newInstance();
			beanCache.put(beanName, instance);
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (beanCache.containsKey(field.getType().getName())) {
					field.set(instance, beanCache.get(field.getName()));
				} else {
					field.set(instance, getBean(field.getType().getName()));
				}
			}
			return instance;
		} catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		MyCircularDependency myCircularDependency = new MyCircularDependency();
		A a = (A) myCircularDependency.getBean(A.class.getName());
		B b = (B) myCircularDependency.getBean(B.class.getName());
		C c = (C) myCircularDependency.getBean(C.class.getName());
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

}
