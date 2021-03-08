package com.lx.entity.aop.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserInvocationHandler implements InvocationHandler {

	// 代理目标对象
	private Object target;

	public UserInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("代理类执行业务逻辑add方法前...");
		Object invoke = method.invoke(target, args);
		System.out.println("代理类执行业务逻辑add方法后...");

		return invoke;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
	}
}
