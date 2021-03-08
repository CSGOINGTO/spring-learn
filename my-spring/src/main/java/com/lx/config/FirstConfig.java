package com.lx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true) // 开启@AspectJ注解配置,并强制使用Cglib
@ComponentScan(basePackages = "com.lx")
public class FirstConfig {


}
