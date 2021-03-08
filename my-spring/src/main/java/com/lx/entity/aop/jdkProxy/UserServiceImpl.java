package com.lx.entity.aop.jdkProxy;

public class UserServiceImpl implements UserService {

	@Override
	public void add() {
		System.out.println("我是正常业务逻辑中的add方法");
	}
}
