package com.lx.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class A {

	@Autowired
	private B b;

	public A() {
	}

	public A(@Lazy B b) {
		this.b = b;
	}

	public void a() {
		b.b();
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public void say() {
		b.say();
	}

	public void sayOver() {
		System.out.println("我是A，是宣布说话环节结束...");
	}
}
