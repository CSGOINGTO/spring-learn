package com.lx.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class C {

	@Autowired
	private A a;

	public C() {
	}

	public C(@Lazy A a) {
		this.a = a;
	}

	public void c() {
		a.a();
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

	public void say() {
		System.out.println("我是C...");
		a.sayOver();
	}
}
