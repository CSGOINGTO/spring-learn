package com.lx.entity.aop.cjlibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerTest {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(EnhancerTest.class);
		enhancer.setCallback(new MethodInterceptorImpl());

		EnhancerTest enhancerTest = (EnhancerTest) enhancer.create();
		enhancerTest.test();
		// 先调用toString()，然后hashCode()
		System.out.println(enhancerTest);
	}

	public void test() {
		System.out.println("EnhancerTest test()...");
	}

	private static class MethodInterceptorImpl implements MethodInterceptor {

		@Override
		public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
			System.out.println("Before invoke " + method);
			Object result = methodProxy.invokeSuper(o, objects);
			System.out.println("After invoke " + method);
			return result;
		}
	}

}
