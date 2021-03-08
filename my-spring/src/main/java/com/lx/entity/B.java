package com.lx.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class B {

	@Autowired
	private C c;

	public B() {
	}

	public B(@Lazy C c) {
		this.c = c;
	}

	public void b() {
		c.c();
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public void say() {
		c.say();
	}
}
