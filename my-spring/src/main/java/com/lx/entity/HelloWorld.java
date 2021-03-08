package com.lx.entity;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

	public void sayHello() {
		System.out.println("Hello World.........");
	}

	public void doSome(String some) {
		System.out.println("开始做：" + some);
	}

	public String sleep() {
		return "sleeping...";
	}
}
