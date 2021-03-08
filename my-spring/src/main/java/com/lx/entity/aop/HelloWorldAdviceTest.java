package com.lx.entity.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/*
	对HelloWorld类进行增强（Advice，通知/增强）
 */
@Aspect // 必须是Spring Bean才能生效
public class HelloWorldAdviceTest {

	private static final String sayHello = "com.lx.entity.aop.SystemArchitecture.sayHello()";

	private static final String doSome = "com.lx.entity.aop.SystemArchitecture.doSome()";

	private static final String sleep = "com.lx.entity.aop.SystemArchitecture.sleep()";

	@Before(sayHello)
	public void beforeTest() {
		System.out.println("before test");
	}

	@After(sayHello)
	public void afterTest() {
		System.out.println("after test");
	}

	@Around(sayHello)
	public Object aroundTest(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("before...");
		Object o = null;
		try {
			o = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("after...");
		return o;
	}

	@Around(doSome)
	public Object doSome(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println(Arrays.toString(proceedingJoinPoint.getArgs()));
		return proceedingJoinPoint.proceed();
	}

	@AfterReturning(pointcut = sleep, returning = "returnVal")
	public void sleep(Object returnVal) {
		System.out.println("打印返回值：" + returnVal);
	}

	@Around(sleep)
	public Object sleep1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("准备开始sleep...");
		Object o = proceedingJoinPoint.proceed();
		System.out.println("sleep方法返回值为" + o);
		return o;

	}

}
