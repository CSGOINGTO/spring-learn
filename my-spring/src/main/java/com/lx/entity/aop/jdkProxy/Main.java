package com.lx.entity.aop.jdkProxy;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		UserInvocationHandler userInvocationHandler = new UserInvocationHandler(userService);
		UserService userProxy = (UserService) userInvocationHandler.getProxy();
		userProxy.add();
	}

}
