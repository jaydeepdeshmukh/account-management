package com.jd.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.jd")
@PropertySource("classpath:accountInfo.properties")
@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfig {

	
}
