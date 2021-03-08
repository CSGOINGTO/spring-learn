package com.lx.entity.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {

	// 切点，匹配方式有execution/within/annotation/bean等
	@Pointcut("execution(* *.sayHello())")
	public void sayHello() {
	}

	@Pointcut("execution(* *.doSome(String))")
	public void doSome(){
	}

	@Pointcut("execution(String *.sleep())")
	public void sleep(){}
}
